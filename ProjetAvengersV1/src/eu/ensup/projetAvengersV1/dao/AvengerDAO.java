package eu.ensup.projetAvengersV1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eu.ensup.projetAvengersV1.domaine.Avenger;

public class AvengerDAO {
	Connexion conn = new Connexion();
	
	/**
	 * @param Avenger
	 * @return
	 * @throws DAOException
	 * Méthode au niveau du DAO permettant d'afficher tous les étudiants
	 */
	public ArrayList<Avenger> listAvenger(Avenger Avenger) throws SQLException {
		ArrayList<Avenger> ArrayListAvenger = new ArrayList<>();
		try {

			ResultSet res = conn.getConnection().executeQuery("SELECT nom, costume, age, pouvoir "
					+ "FROM avenger ;");

			while (res.next()) {
				Avenger AvengerList = new Avenger(null, null, 0, null);
				AvengerList.setNom(res.getString("nom"));
				AvengerList.setCostume(res.getString("costume"));
				AvengerList.setAge(res.getInt("age"));
				AvengerList.setPouvoir(res.getString("pouvoir"));
				
				ArrayListAvenger.add(AvengerList);
			}

		}

		catch (Exception e) {
			
		}

		return ArrayListAvenger;
	}

	/**
	 * @param Avenger
	 * @throws DAOException
	 * Méthode au niveau du DAO permettant d'ajouter un nouvel étudiant
	 */
	public void ajouterAvenger(Avenger Avenger) throws SQLException {
		try {
			conn.getConnection().executeUpdate("INSERT INTO avenger(nom, costume, age, pouvoir) values"
					+ "('"+ Avenger.getNom() +"','"+ Avenger.getCostume() +"','"+ Avenger.getAge() +
					"','"+ Avenger.getPouvoir() +"');");		

		} catch (Exception e) {
			
		}

	}


	/**
	 * @param id
	 * @throws DAOException
	 * Méthode au niveau du DAO permettant de supprimer un étudiant
	 */
	public void supprimerAvenger(int id) throws SQLException {
		// TODO Auto-generated method stub	
		try {
			conn.getConnection().executeUpdate("DELETE FROM `avenger` WHERE `id`='"+ id +"';");		

		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}

	/**
	 * @param Avenger
	 * @param id
	 * @throws DAOException
	 * Méthode au niveau du DAO permettant de mettre à jour un étudiants
	 */
	public void editerAvenger(Avenger Avenger, int id) throws SQLException {
		// TODO Auto-generated method stub	
		try {
			conn.getConnection().executeUpdate("UPDATE avenger SET nom = '"
					+ "" + Avenger.getNom() + ""
					+ "',costume = '" + Avenger.getCostume()+ ""
					+ "',age = '" + Avenger.getAge() + ""
					+ "',pouvoir = '" + Avenger.getPouvoir() + "';");	

		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	/**
	 * @param Avenger
	 * @param id
	 * @return
	 * @throws DAOException
	 * Méthode au niveau du DAO permettant d'afficher un étudiants
	 */
	public ArrayList<Avenger> listUnAvenger(Avenger Avenger, int id) throws SQLException {
		ArrayList<Avenger> ArrayListUnAvenger = new ArrayList<>();
		try {

			ResultSet res = conn.getConnection().executeQuery("SELECT nom, costume, age, pouvoir "
					+ "FROM avenger WHERE `id`='"+ id +"';");

			while (res.next()) {
				Avenger AvengerList = new Avenger(null, null, 0, null);
				AvengerList.setNom(res.getString("nom"));
				AvengerList.setCostume(res.getString("costume"));
				AvengerList.setAge(res.getInt("age"));
				AvengerList.setPouvoir(res.getString("pouvoir"));

				ArrayListUnAvenger.add(AvengerList);
			}

		}

		catch (Exception e) {
			
		}

		return ArrayListUnAvenger;
	}
}
