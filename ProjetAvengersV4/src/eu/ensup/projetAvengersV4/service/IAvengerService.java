package eu.ensup.projetAvengersV4.service;

import java.util.ArrayList;

import eu.ensup.projetAvengersV4.domaine.Avenger;

public interface IAvengerService {
	public ArrayList<Avenger> listAvenger(Avenger Avenger) throws Exception;
	public void ajouterAvenger(Avenger Avenger) throws Exception;
	public void supprimerAvenger(int id) throws Exception;
	public void editerAvenger(Avenger Avenger, int id) throws Exception;
	public ArrayList<Avenger> listUnAvenger(Avenger Avenger, int id) throws Exception;
}
