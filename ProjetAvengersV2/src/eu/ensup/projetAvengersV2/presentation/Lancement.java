package eu.ensup.projetAvengersV2.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import eu.ensup.projetAvengersV2.dao.Connexion;
import eu.ensup.projetAvengersV2.domaine.Avenger;
import eu.ensup.projetAvengersV2.exception.DAOException;
import eu.ensup.projetAvengersV2.service.AvengerService;


public class Lancement {

	public static void main(String[] args) throws Exception{
		AvengerService avengerService = new AvengerService();
		Connexion conn = new Connexion();
		Avenger avenger = new Avenger(null, null, 0, null);
		
		System.out.println("1 - Lister les Avengers");
		System.out.println("2 - Ajouter un Avenger");
		System.out.println("3 - Modifier un Avenger");
		System.out.println("4 - Supprimer un Avenger");
		System.out.println("5 - Afficher les informations d'un Avenger");
		
		System.out.println("Veuillez entrer votre choix : ");
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();

		switch (str) {
		case 1:
			/**
			 * Instenciation du tableau listAven
			 */
			ArrayList<Avenger> listAvenger = new ArrayList<Avenger>();
			/**
			 * Récupération du service et stockage dans listAven
			 */
			listAvenger = avengerService.listAvenger(avenger);
			
			System.out.println(listAvenger);
			
			break;

		case 2:
			Avenger AvengerAjout = new Avenger(null, null, 0, null);
			
			System.out.println("Nom : ");
			Scanner scEtuAjoutNom = new Scanner(System.in);
			String nom = scEtuAjoutNom.nextLine();
			AvengerAjout.setNom(nom);
			
			String testAvenger = avengerService.controlleAvenger(AvengerAjout);
			if(testAvenger.equals("1")) {
			break;
			}
			
			System.out.println("Costume : ");
			Scanner scEtuAjoutCostume = new Scanner(System.in);
			String Costume = scEtuAjoutCostume.nextLine();
			AvengerAjout.setCostume(Costume);
			
			System.out.println("Age : ");
			Scanner scEtuAjoutAge = new Scanner(System.in);
			int Age = scEtuAjoutAge.nextInt();
			AvengerAjout.setAge(Age);
			
			System.out.println("Pouvoir : ");
			Scanner scEtuAjoutPouvoir = new Scanner(System.in);
			String Pouvoir = scEtuAjoutPouvoir.nextLine();
			AvengerAjout.setPouvoir(Pouvoir);
			
			avengerService.ajouterAvenger(AvengerAjout);
			
			break;
			
		case 3:
			System.out.println("Selectionnez un étudiant : ");
			Scanner scAvengerSelc = new Scanner(System.in);
			int id = scAvengerSelc.nextInt();
			
			
			System.out.println("Nom : ");
			Scanner scModifEtuNom = new Scanner(System.in);
			String modifNom = scModifEtuNom.nextLine();
			avenger.setNom(modifNom);
			
			System.out.println("Costume : ");
			Scanner scModifEtuCostume = new Scanner(System.in);
			String modifCostume = scModifEtuNom.nextLine();
			avenger.setCostume(modifCostume);
			
			System.out.println("Age : ");
			Scanner scModifEtuAge = new Scanner(System.in);
			int modifAge = scModifEtuAge.nextInt();
			avenger.setAge(modifAge);
			
			System.out.println("Pouvoir");
			Scanner scModifEtuPouvoir = new Scanner(System.in);
			String modifPouvoir = scModifEtuPouvoir.nextLine();
			avenger.setPouvoir(modifPouvoir);
			
			avengerService.editerAvenger(avenger, id);
			break;
			
		case 4:
			System.out.println("Entrer l'identifiant de l'étudiant à supprimer : ");
			Scanner scAvengerSupp = new Scanner(System.in);
			int idSupp = scAvengerSupp.nextInt();
			// gestion des exceptions au niveau du services à faire
			avengerService.supprimerAvenger(idSupp);
			System.out.println("L'étudiant est bien supprimé");
			scAvengerSupp.close();
			break;
			
		case 5:
			System.out.println("Entrer l'identifiant de l'étudiant : ");
			Scanner scUnAvenger = new Scanner(System.in);
			int idUnEtu = scUnAvenger.nextInt();
			ArrayList<Avenger> listUnAvenger = new ArrayList<Avenger>();
			listUnAvenger = avengerService.listUnAvenger(avenger, idUnEtu);
			
			System.out.println(listUnAvenger);
			scUnAvenger.close();
			break;
		}
		
	}
	
}
