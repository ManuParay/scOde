package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Morse {
	//--ATTRIBUT--
	private final String PATH_RESSOURCE = "src/ressource/";
	private final String REFERENCE_MORSE = "referenceMorse.csv";
	private final char[] ACCENT = Generale.g.getRefAccent();
	
	private Object ti, ta, tiInvesre, taInverse, separateurLettre, separateurMot, separateurPhrase;
	private int[][] reference; //Contient le nombre de TA TI TA et TI d'une lettre. Ex: a = 0*TA + 1*TI + 1*TA + 0*TI.
	private boolean estInverse, estBinaire;

	//--CONSTRUCTEUR--
	public Morse(){
		ti = '.';
		ta = '-';
		tiInvesre = ta;
		taInverse =  ti;
		separateurLettre = '/';
		separateurMot = "//";
		separateurPhrase = "///";
		estInverse = false;
		estBinaire = false;
		reference = new int[36][4]; //L'alphabet + 0 à 9 = 37
		initReference();
	}

	//--METHODE--
	/**
	 * Initialise un tableau pour connaitre le nombre de TA de chaque lettre. 
	 */
	private void initReference(){
		File f = new File(PATH_RESSOURCE+REFERENCE_MORSE);
		FileReader fr;
		try {
			fr = new FileReader(f);
			BufferedReader b = new BufferedReader(fr);
			int i = 0, j = 0;
			int tmp = b.read();
			while(tmp != -1){
				if(tmp != 44 && tmp != 10){ //44 = ' ' et 10 = '\n'
					reference[i][j] = tmp-48; //Dans la table ascii, 0 vaut 48, 1 vaut 49...
					j++;
					if(j>3){
						j=0;
						i++;
					}
				}
				tmp = b.read();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Le fichier de configuration referenceMorse ne peut pas etre ouvert.");
		}
		catch (IOException e){
			System.out.println("La lecture dans le fichier referenceMorse a rencontrer un probleme.");
		}
	}

	/**
	 * Permet de transformer une chaine en une serie de "." et de "-".
	 * Il est possible de changer la valeur d'un "." et d'un "-" en appellant setTi() et setTa().
	 * @param chaine, la chaine a transformer.
	 * @return un String la chaine transformer.
	 */
	public String coder(String chaine){
		String newChaine = "";
		chaine = chaine.toLowerCase();
		for(int i=0 ; i<chaine.length() ; i++){ //Pour chaque lettre de la chaine
			char charActu = chaine.charAt(i); 
			if(charActu >= 224 && charActu <= 253 ){ //char accentue
				charActu = ACCENT[charActu-224]; //Debut des char accentue a 128.
			}
			if(charActu > 96 && charActu < 123){ //97 = a et 122 = z
				for(int j=0 ; j<reference[0].length ; j++){ //Un lettre est composé d'un certain nombre de TA puis TI puis TA puis TI.
					for(int k=0 ; k<reference[charActu-97][j] ; k++){//Cette astuce nous donne l'indice du tableau directement.
						if(!estInverse){
							if(j%2 == 0) newChaine += ta;
							else newChaine += ti;
						}else{
							if(j%2 == 0) newChaine += taInverse;
							else newChaine += tiInvesre;
						}
					}
				}
				if(i+1<chaine.length() && ((int)chaine.charAt(i+1) > 96 && (int)chaine.charAt(i+1) < 123 
						|| (int)chaine.charAt(i+1) > 223 && (int)chaine.charAt(i+1) < 254))
					newChaine += separateurLettre;
			}else if(charActu == ' '){
				newChaine += separateurMot;
			}else if(charActu == '.'){
				newChaine += separateurPhrase;
			}else{
				newChaine += chaine.charAt(i); 
			}
		}
		return newChaine;
	}
	/**
	 * @return le tableau referancent la valeur de chaque lettre en mosre.
	 */
	public int[][] getReference(){
		return reference;
	}
	public void setInverse(boolean b){
		estInverse = b;
	}
	public boolean estInverse(){
		return estInverse;
	}
	public void setBinaire(boolean b){
		estBinaire = b;
		if(b){
			ti = "0";
			ta = "1";
			tiInvesre = ta;
			taInverse = ti;
		}else{
			ti = ".";
			ta = "-";
			tiInvesre = ta;
			taInverse = ti;
		}
	}
	public boolean estBinaire(){
		return estBinaire;
	}
}
