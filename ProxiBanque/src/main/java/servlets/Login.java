package servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Conseiller;
import service.IConseillerService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	@Inject
	private IConseillerService ics;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1- Récupération les paramètres
		Conseiller cons = new Conseiller();
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		//2- Traitement avec la couche service
	
		System.out.println(login+ mdp);
		
				cons = ics.authentificationConseiller(login, mdp);
	 
		if(cons.getId()!=0)
		{
		//3- Session 
		HttpSession session = request.getSession();
		session.setAttribute("leConseiller", cons);
		
		//5- Envoi à la Servlet
		request.getRequestDispatcher("/GestionClients?action=listeClients").forward(request,response);
		}
		else{
			request.getRequestDispatcher("/erreurAuthentification.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
