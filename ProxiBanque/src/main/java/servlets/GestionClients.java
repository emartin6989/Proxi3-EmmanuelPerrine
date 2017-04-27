package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Coordonnees;
import service.IConseillerService;
import service.exceptions.ClientGererParAutreConseillerException;
import service.exceptions.ClientInexistantException;
import service.exceptions.MontantNegatifException;
import service.exceptions.NombreClientsMaxAtteintException;
import service.exceptions.SoldeInsuffisantException;
import servlets.exceptions.NombreCompteMaxAtteintException;

/**
 * Servlet implementation class GestionClients
 */
@WebServlet("/GestionClients")
public class GestionClients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IConseillerService ics;

	/**
	 * Default constructor.
	 */
	public GestionClients() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("leConseiller") != null) {

			Conseiller cons = (Conseiller) session.getAttribute("leConseiller");

			if (request.getParameter("action").equals("editionClient")) {
				request.setCharacterEncoding("UTF-8");

				String id = request.getParameter("id");

				String adresse = request.getParameter("adresse");
				String codepostal = request.getParameter("cp");
				String ville = request.getParameter("ville");
				String telephone = request.getParameter("telephone");
				String email = request.getParameter("email");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				boolean entreprise = Boolean.parseBoolean(request.getParameter("entreprise"));

				Client c = new Client();
				Coordonnees coor = new Coordonnees();
				coor.setCp(codepostal);
				coor.setAdresse(adresse);
				coor.setVille(ville);
				coor.setEmail(email);
				coor.setTelephone(telephone);

				c.setId(Integer.parseInt(id));
				c.setEntreprise(entreprise);
				c.setNom(nom);
				c.setPrenom(prenom);

				ics.modifierClient(c, coor);

				request.setAttribute("nom", nom);
				request.setAttribute("prenom", prenom);

				request.getRequestDispatcher("/ResultatModClient.jsp").forward(request, response);
			}

			if (request.getParameter("action").equals("listeClients")) {

				// 2- Traitement avec la couche service

				List<Client> listeClients = new ArrayList<Client>();
				listeClients = (List<Client>) ics.listerClients(cons);
				request.setAttribute("listeClients", listeClients);

				// 4 Envoi à la JSP
				request.getRequestDispatcher("/listeClients.jsp").forward(request, response);
			}

			if (request.getParameter("action").equals("listeComptesClients")) {
				List<Compte> listeComptes = new ArrayList<Compte>();
				Client c = new Client();
				c.setId(Integer.parseInt(request.getParameter("id")));
				listeComptes = (List<Compte>) ics.listerComptes(c);
				request.setAttribute("listeComptes", listeComptes);
				request.getRequestDispatcher("/listeComptesClient.jsp").forward(request, response);
			}

			if (request.getParameter("action").equals("virementCompteACompte")) {
				request.setCharacterEncoding("UTF-8");
				String numCompteEmetteur = request.getParameter("numCompteEmetteur");
				String numCompteRecepteur = request.getParameter("numCompteRecepteur");
				String montant = request.getParameter("montant");
				String typeCompteEmetteur = request.getParameter("typeCompteEmetteur");
				String typeCompteRecepteur = request.getParameter("typeCompteRecepteur");
				


				if(typeCompteEmetteur.equalsIgnoreCase("courant")){
					CompteCourant cce = new CompteCourant();
					cce.setNumCompte(Integer.parseInt(numCompteEmetteur));
					if(typeCompteRecepteur.equalsIgnoreCase("courant")){
						CompteCourant ccr = new CompteCourant();
						ccr.setNumCompte(Integer.parseInt(numCompteRecepteur));
						try {
							ics.effectuerVirement(cons, cce, ccr, Integer.parseInt(montant));
						} catch (NumberFormatException | SoldeInsuffisantException | MontantNegatifException
								| ClientGererParAutreConseillerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						CompteEpargne cer = new CompteEpargne();
						cer.setNumCompte(Integer.parseInt(numCompteRecepteur));
						try {
							ics.effectuerVirement(cons, cce, cer, Integer.parseInt(montant));
						} catch (NumberFormatException | SoldeInsuffisantException | MontantNegatifException
								| ClientGererParAutreConseillerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else{
					if (typeCompteEmetteur.equalsIgnoreCase("epargne")){
					CompteEpargne cee = new CompteEpargne();
					cee.setNumCompte(Integer.parseInt(numCompteEmetteur));
					if(typeCompteEmetteur.equalsIgnoreCase("courant")){
						CompteCourant ccr = new CompteCourant();
						ccr.setNumCompte(Integer.parseInt(numCompteRecepteur));
						try {
							ics.effectuerVirement(cons, cee, ccr, Integer.parseInt(montant));
						} catch (NumberFormatException | SoldeInsuffisantException | MontantNegatifException
								| ClientGererParAutreConseillerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
					}else {
						CompteEpargne cer = new CompteEpargne();
						cer.setNumCompte(Integer.parseInt(numCompteRecepteur));
						try {
							ics.effectuerVirement(cons, cee, cer, Integer.parseInt(montant));
						} catch (NumberFormatException | SoldeInsuffisantException | MontantNegatifException
								| ClientGererParAutreConseillerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}
				}
				request.getRequestDispatcher("/virementCompteACompte.jsp").forward(request, response);
			}

			if (request.getParameter("action").equals("erreur")) {

				request.getRequestDispatcher("/erreur.jsp").forward(request, response);
			}

			if (request.getParameter("action").equals("ajouterClients")) {
				request.setCharacterEncoding("UTF-8");
				String adresse = request.getParameter("adresse");
				String codepostal = request.getParameter("cp");
				String ville = request.getParameter("ville");
				String telephone = request.getParameter("telephone");
				String email = request.getParameter("email");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				boolean entreprise = Boolean.parseBoolean(request.getParameter("entreprise"));

				Client c = new Client();
				Coordonnees coor = new Coordonnees();
				coor.setCp(codepostal);
				coor.setAdresse(adresse);
				coor.setVille(ville);
				coor.setEmail(email);
				coor.setTelephone(telephone);

				c.setEntreprise(entreprise);
				c.setNom(nom);
				c.setPrenom(prenom);

				try {
					ics.ajouterClient(cons, c, coor);
				} catch (NombreClientsMaxAtteintException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				request.setAttribute("idClient", c.getId());

				request.getRequestDispatcher("/formulaireCompte").forward(request, response);
			}

			if (request.getParameter("action").equals("supprimerClient")) {
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");

				Client c = new Client();
				c.setId(Integer.parseInt(id));

				try {
					ics.supprimerClient(cons, c, Integer.parseInt(id));
				} catch (NumberFormatException | ClientInexistantException | ClientGererParAutreConseillerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				request.getRequestDispatcher("/ResultatSupClient.jsp").forward(request, response);
			}

			if (request.getParameter("action").equals("ajouterCompte")) {
				request.setCharacterEncoding("UTF-8");
				String solde = request.getParameter("solde");
				String numCompte = request.getParameter("numCompte");

				Client c = new Client();
				c.setId(Integer.parseInt(request.getParameter("idClient")));
				Date dateOuverture = new Date();

				String decouvert = request.getParameter("decouvert");
				CompteCourant compteCour = new CompteCourant();
				compteCour.setDecouvert(Integer.parseInt(decouvert));
				compteCour.setSolde(Integer.parseInt(solde));
				compteCour.setDateOuverture(dateOuverture);
				compteCour.setNumCompte(Integer.parseInt(numCompte));
				try {
					ics.ajouterCompteCourant(c, compteCour);
				} catch (NombreCompteMaxAtteintException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

				String tauxRemuneration = request.getParameter("tauxRemuneration");
				CompteEpargne compteEpar = new CompteEpargne();
				compteEpar.setTauxRemuneration(Integer.parseInt(tauxRemuneration));
				compteEpar.setSolde(Integer.parseInt(solde));
				compteEpar.setDateOuverture(dateOuverture);
				compteEpar.setNumCompte(Integer.parseInt(numCompte));
				try {
					ics.ajouterCompteEpargne(c, compteEpar);
				} catch (NombreCompteMaxAtteintException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

				request.getRequestDispatcher("/Resultat").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("/authentificationConseiller.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
