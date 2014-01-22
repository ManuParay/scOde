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
		String chaineACoder = "";
		int choix = 1;
		System.out.println("Entrez la phrase a coder en morse: ");
		chaineACoder = sc.nextLine();
		System.out.println("Choisissez le mode de codage");
		System.out.println("1: Normal  2: Inversé  3: ApparenceBinaire");
		try{
			choix = Integer.parseInt(sc.next());
			switch (choix) {
			case 2: morseModel.setInverse(true); break;
			case 3: morseModel.setBinaire(true); break;
			default: 
				morseModel.setInverse(false);
				morseModel.setBinaire(false);
				break;
			}
		}catch(NumberFormatException e){
			System.out.println("Valeur invalide");
			return ;
		}
		System.out.println(morseModel.morse(chaineACoder));
	}
	
	//--TESTE--
	public static void main(String[] args){
		Morse modele = new Morse();
		MorseTexte m = new MorseTexte(modele);
	}
}
