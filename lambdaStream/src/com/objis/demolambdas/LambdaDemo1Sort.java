package com.objis.demolambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.objis.demostreams.common.Genre;
import com.objis.demostreams.common.Personne;

public class LambdaDemo1Sort {
	   // BESOIN : Classer une liste de Personnes par ordre alphabetique (nom)
	public static void main(String[] args) {
		List<Personne> personnes = creerPersonnes();    // jeu de donn�es
	   System.out.println(personnes);
	   
	   Collections.sort(personnes, new ComparePersonneParNom()); 

	   
	  // Comparaison avec expression lambda 
	   Collections.sort(personnes, (p1, p2) -> p1.getNom().compareTo(p2.getNom()));
	   
	   // Comparaison avec expression lambda et nouvelle methode de tire Java 8
	   personnes.sort(Comparator.comparing(p->p.getNom()));
	   
	   // Comparaison avec r�f�rence de m�thode et nouvelle m�thode de trie JAava 8
	   personnes.sort(Comparator.comparing(Personne::getNom));
	   
	   System.out.println(personnes);
	   
	   List<String> listePersonnes;
	   
	   listePersonnes = personnes.stream()
			   .filter(person -> person.getAge() > 18)
			   .filter(person -> person.getGenre() == Genre.FEMME)
			   .map(person -> person.getNom().toUpperCase())
			   .collect(toList());
	   
	   
	}
	
	  public static int compare (Personne p1, Personne p2){
		  return p1.getNom().compareTo(p2.getNom());
	  }
	  
	  public static List<Personne> creerPersonnes() {
		    return Arrays.asList(
			    new Personne("Sarah", Genre.FEMME, 20),
			    new Personne("Sonia", Genre.FEMME, 22),
			    new Personne("Michel", Genre.HOMME, 20),
			    new Personne("Paul", Genre.FEMME, 32),
			    new Personne("Pauline", Genre.HOMME, 32),
			    new Personne("Julien", Genre.HOMME, 2),
			    new Personne("Julien", Genre.HOMME, 72),
			    new Personne("Jacques", Genre.FEMME, 12)
			  );
		  }	  
}