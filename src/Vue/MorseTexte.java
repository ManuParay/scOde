package Vue;

import java.util.Scanner;

import models.Morse;

public class MorseTexte {
	//--ATTRIBUT--
	private Morse morseModel;
	private Scanner sc;

	//--CONSTRUCTEUR--
	public MorseTexte(Morse m){
		morseModel = m;
		sc = new Scanner(System.in);
		startMorse();
	}

	//--METHODE--
	private void startMorse(){
		boolean valeurValide;
		while(true){
			valeurValide = true;
			String chaineACoder = "";
			int choix = 1;
			System.out.println("Entrez la phrase à coder en morse: ");
			chaineACoder = sc.nextLine();
			System.out.println("Choisissez le mode de codage");
			System.out.println("1: Normal  2: Inversé  3: ApparenceBinaire");
			try{
				choix = Integer.parseInt(sc.next());
				switch (choix) {
				case 1: morseModel.setInverse(false); morseModel.setBinaire(false); break; 
				case 12: morseModel.setInverse(true); morseModel.setBinaire(false); break;
				case 21: morseModel.setInverse(true); morseModel.setBinaire(false); break;
				case 3: morseModel.setInverse(false); morseModel.setBinaire(true); break;
				case 23: morseModel.setInverse(true); morseModel.setBinaire(true); break;
				case 32: morseModel.setInverse(true); morseModel.setBinaire(true); break;
				default: 
					morseModel.setInverse(false);
					morseModel.setBinaire(false);
					break;
				}
			}catch(NumberFormatException e){
				System.out.println("Valeur invalide");
				valeurValide = false;
				sc.nextLine();
			}
			if(valeurValide){
				System.out.println(morseModel.coder(chaineACoder));
				sc.nextLine();
			}
		}
	}

	//--TESTE--
	public static void main(String[] args){
		Morse modele = new Morse();
		new MorseTexte(modele);
	}
}
