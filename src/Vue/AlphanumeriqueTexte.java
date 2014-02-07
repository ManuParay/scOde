package Vue;

import java.util.Scanner;
import models.Alphanumerique;

public class AlphanumeriqueTexte {
	//--ATTRIBUT--
	private Alphanumerique melangeAlphanumeriqueModele;
	private Scanner sc;

	//--CONSTRUCTEUR--
	public AlphanumeriqueTexte(Alphanumerique m){
		melangeAlphanumeriqueModele = m;
		sc = new Scanner(System.in);
		startMelangeAlphanumerique();
	}

	//--METHODE--
	private void startMelangeAlphanumerique(){
		boolean valeurValide;
		while(true){
			valeurValide = true;
			String chaineACoder = "";
			int choixDecalage = 1;
			System.out.println("Entrez la phrase à melanger: ");
			chaineACoder = sc.nextLine();
			System.out.println("Choisissez le decalage:");			
			try{
				choixDecalage = Integer.parseInt(sc.nextLine());
				melangeAlphanumeriqueModele.setDecalage(choixDecalage);
			}catch(NumberFormatException e){
				System.out.println("Valeur invalide");
				valeurValide = false;
			}
			if(valeurValide){
				System.out.println("Ecrire les nombres en binaire (O/n)?");
				String tmp = sc.nextLine(); 
				if(tmp.equals("n")) melangeAlphanumeriqueModele.setBinaire(false);
				else melangeAlphanumeriqueModele.setBinaire(true);

				System.out.println(melangeAlphanumeriqueModele.coder(chaineACoder));
			}
		}
	}

	//--TESTE--
	public static void main(String[] args){
		Alphanumerique modele = new Alphanumerique();
		new AlphanumeriqueTexte(modele);
	}
}
