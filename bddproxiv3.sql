-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 28 Avril 2017 à 11:58
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bddproxiv3`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `Agence_id` int(11) NOT NULL,
  `dateCreation` varchar(255) DEFAULT NULL,
  `nomAgence` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE `carte` (
  `TYPE_CARTE` varchar(31) NOT NULL,
  `carte_id` int(11) NOT NULL,
  `dateExpiration` datetime DEFAULT NULL,
  `numeroCarte` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `TYPE_COMPTE` varchar(31) NOT NULL,
  `Compte_id` bigint(20) NOT NULL,
  `dateOuverture` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `tauxRemuneration` double DEFAULT NULL,
  `decouvert` double DEFAULT NULL,
  `agence_Agence_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------


CREATE TABLE `coordonnees` (
  `Coordonnees_id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `cp` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Structure de la table `credit`
--

CREATE TABLE `credit` (
  `TYPE_CREDIT` varchar(31) NOT NULL,
  `Credit_id` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  `montant` double NOT NULL,
  `taux` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `TYPE_PERSONNE` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `entreprise` bit(1) DEFAULT NULL,
  `coordonnees_Coordonnees_id` int(11) DEFAULT NULL,
  `conseiller_id` int(11) DEFAULT NULL,
  `AGENCE_ID` int(11) DEFAULT NULL,
  `agence_Agence_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Structure de la table `placement`
--

CREATE TABLE `placement` (
  `Placement_id` int(11) NOT NULL,
  `montant` double NOT NULL,
  `placeFinanciere` varchar(255) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`Agence_id`);

--
-- Index pour la table `carte`
--
ALTER TABLE `carte`
  ADD PRIMARY KEY (`carte_id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`Compte_id`),
  ADD KEY `FK_k8ycmr904763q8pf76elhvii` (`agence_Agence_id`),
  ADD KEY `FK_jypo7b7k528n3pbpm0armju7y` (`client_id`);

--
-- Index pour la table `coordonnees`
--
ALTER TABLE `coordonnees`
  ADD PRIMARY KEY (`Coordonnees_id`);

--
-- Index pour la table `credit`
--
ALTER TABLE `credit`
  ADD PRIMARY KEY (`Credit_id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_bggs2botli0nu0r61xp497mdc` (`coordonnees_Coordonnees_id`),
  ADD KEY `FK_dorgrgheop46kc1y0o9evdfav` (`conseiller_id`),
  ADD KEY `FK_2qf17sg79qljwlmitcajdkiq9` (`AGENCE_ID`),
  ADD KEY `FK_g3oko85s7cnjuv0urwe9j7x5m` (`agence_Agence_id`);

--
-- Index pour la table `placement`
--
ALTER TABLE `placement`
  ADD PRIMARY KEY (`Placement_id`),
  ADD KEY `FK_2n1jdotkvt0nkes4xyb7hx89w` (`client_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `Agence_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `carte`
--
ALTER TABLE `carte`
  MODIFY `carte_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `Compte_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `coordonnees`
--
ALTER TABLE `coordonnees`
  MODIFY `Coordonnees_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `credit`
--
ALTER TABLE `credit`
  MODIFY `Credit_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `placement`
--
ALTER TABLE `placement`
  MODIFY `Placement_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
