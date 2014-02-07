package Vue;

import java.util.Scanner;
import models.Alphabetique;

public class AlphabetiqueTexte {
	//--ATTRIBUT--
	private Alphabetique melangeAlphabetiqueModele;
	private Scanner sc;

	//--CONSTRUCTEUR--
	public AlphabetiqueTexte(Alphabetique m){
		melangeAlphabetiqueModele = m;
		sc = new Scanner(System.in);
		startMelangeAlphabetique();
	}

	//--METHODE--
	private void startMelangeAlphabetique(){
		boolean valeurValide;
		while(true){
			valeurValide = true;
			String chaineACoder = "";
			int choix = 1;
			System.out.println("Entrez la phrase à melanger: ");
			chaineACoder = sc.nextLine();
			System.out.println("Choisissez le decalage:");
			try{
				choix = Integer.parseInt(sc.next());
				melangeAlphabetiqueModele.setDecalage(choix);
			}catch(NumberFormatException e){
				System.out.println("Valeur invalide");
				valeurValide = false;
				sc.nextLine();
			}
			if(valeurValide){
				System.out.println(melangeAlphabetiqueModele.coder(chaineACoder));
				sc.nextLine();
			}
		}
	}

	//--TESTE--
	public static void main(String[] args){
		Alphabetique modele = new Alphabetique();
		new AlphabetiqueTexte(modele);
	}
}
