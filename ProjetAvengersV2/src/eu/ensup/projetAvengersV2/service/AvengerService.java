package eu.ensup.projetAvengersV2.service;

import java.sql.SQLException;
import java.util.ArrayList;

import eu.ensup.projetAvengersV2.dao.AvengerDAO;
import eu.ensup.projetAvengersV2.domaine.Avenger;
import eu.ensup.projetAvengersV2.exception.DAOException;
import eu.ensup.projetAvengersV2.exception.ServiceException;

public class AvengerService {
	AvengerDAO daoAvenger = new AvengerDAO();
	/**
	 * @param Avenger
	 * @return
	 * @throws SQLException
	 * Methode ListAvenger permettant de lister tous les étudiants
	 */
	public ArrayList<Avenger> listAvenger(Avenger Avenger) throws Exception{
		ArrayList<Avenger> ArrayAvenger = new ArrayList<>();
		ArrayAvenger = daoAvenger.listAvenger(Avenger);
		return ArrayAvenger;
	}
	
	/**
	 * @param Avenger
	 * @throws SQLException
	 * Methode permettant d'ajouter un étudiant
	 */
	public void ajouterAvenger(Avenger Avenger) throws Exception{
		
		daoAvenger.ajouterAvenger(Avenger);
	}
	
	/**
	 * @param id
	 * @throws SQLException
	 * Méthode permettant de supprimer un étudiant avec son identifiant
	 */
	public void supprimerAvenger(int id) throws Exception{
		
		daoAvenger.supprimerAvenger(id);
	}
	
	/**
	 * @param Avenger
	 * @param id
	 * @throws SQLException
	 * Méthode permettant de modifier les informations d'une étudiant 
	 */
	public void editerAvenger(Avenger Avenger, int id) throws Exception{
		
		daoAvenger.editerAvenger(Avenger, id);
	}
	
	/**
	 * @param Avenger
	 * @param id
	 * @return
	 * @throws SQLException
	 * Méthode permettant d'afficher les information d'un étudiant
	 */
	public ArrayList<Avenger> listUnAvenger(Avenger Avenger, int id) throws Exception {
		
		ArrayList<Avenger> ArrayUnAvenger = new ArrayList<>();
		ArrayUnAvenger = daoAvenger.listUnAvenger(Avenger, id);
		return ArrayUnAvenger;
	}
	
	public String controlleAvenger(Avenger avenger) throws ServiceException {
		
		if(avenger.getNom().equals("Hulk")) {
			new ServiceException();	
			return "1";
		}
				
		else
			return "2";
	}
	
}
