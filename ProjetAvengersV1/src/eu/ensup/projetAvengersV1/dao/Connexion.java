package eu.ensup.projetAvengersV1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	private static Connection connect = null;

	private static Statement statement = null;

	/**
	 * @return Cette méthode permet la connexion de l'application à la base de
	 *         donnée
	 */
	public static Statement getConnection() {
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

	/**
	 * Méthode permettant de fermer la connexion
	 */
	public static void closeConnection() {
		try {
			connect.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
