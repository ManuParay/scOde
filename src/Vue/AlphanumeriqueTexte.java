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
		while(true){
			String chaineACoder = "";
			int choix = 1;
			System.out.println("Entrez la phrase à melanger: ");
			chaineACoder = sc.nextLine();
			System.out.println("Choisissez le decalage:");
			try{
				choix = Integer.parseInt(sc.next());
				melangeAlphanumeriqueModele.setDecalage(choix);
			}catch(NumberFormatException e){
				System.out.println("Valeur invalide");
				return ;
			}
			System.out.println(melangeAlphanumeriqueModele.coder(chaineACoder));
			sc.nextLine();
		}
	}

	//--TESTE--
	public static void main(String[] args){
		Alphanumerique modele = new Alphanumerique();
		new AlphanumeriqueTexte(modele);
	}
}
