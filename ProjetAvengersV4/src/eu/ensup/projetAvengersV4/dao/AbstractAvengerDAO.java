package eu.ensup.projetAvengersV4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eu.ensup.projetAvengersV4.domaine.Avenger;
import eu.ensup.projetAvengersV4.exception.DAOException;

public abstract class AbstractAvengerDAO implements IAvengerDAO {

	public abstract ArrayList<Avenger> listAvenger(Avenger Avenger) throws DAOException;
	public abstract void ajouterAvenger(Avenger Avenger) throws DAOException;
	public abstract void supprimerAvenger(int id) throws DAOException;
	public abstract void editerAvenger(Avenger Avenger, int id) throws DAOException;
	public abstract ArrayList<Avenger> listUnAvenger(Avenger Avenger, int id) throws DAOException;
	
	
	private static Connection connect = null;
	private static Statement statement = null;
	protected static Statement getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connect = DriverManager
						.getConnection("jdbc:mysql://localhost/avengers?user=root&password=");
				statement = connect.createStatement();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur 1");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur 2");
		}

		return statement;
	}

}
