package eu.ensup.projetAvengersV4.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import eu.ensup.projetAvengersV4.domaine.Avenger;
import eu.ensup.projetAvengersV4.exception.DAOException;

public interface IAvengerDAO {
	public ArrayList<Avenger> listAvenger(Avenger Avenger) throws DAOException;
	public void ajouterAvenger(Avenger Avenger) throws DAOException;
	public void supprimerAvenger(int id) throws DAOException;
	public void editerAvenger(Avenger Avenger, int id) throws DAOException;
	public ArrayList<Avenger> listUnAvenger(Avenger Avenger, int id) throws DAOException;
}
