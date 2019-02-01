package eu.ensup.projetAvengersV2.exception;

public class DAOException extends Exception{
	public DAOException() {
		System.out.println("Problème venant du DAO : Verifier l'écriture des champs");
	}
}
