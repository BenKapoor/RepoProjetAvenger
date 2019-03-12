package eu.ensup.resacrenau.service;

import java.util.ArrayList;

import eu.ensup.resacrenau.dao.Connexion;
import eu.ensup.resacrenau.dao.DaoReservation;
import eu.ensup.resacrenau.domaine.Reservation;

public class ResaCrenauService {
	public ResaCrenauService(String heureDebut, String heureFin, String date, String nom, String prenom) {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param conn
	 * @return Liste les diff�rentes r�servation, des creneau et des utilisateurs
	 */
	public ArrayList<Reservation> listeReservationCreneau(Connexion conn) {

		DaoReservation daoReservation = new DaoReservation();

		ArrayList<Reservation> list = new ArrayList<>();

		list = daoReservation.listeReservation(conn);

		return list;
	}

}
