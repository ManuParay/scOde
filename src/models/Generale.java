package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Generale {
	//--ATTRIBUT--
	public static Generale g = new Generale();
	public static final int DEBUT_MIN = 97;
	public static final int DEBUT_MAJ = 65;
	public static final int FIN_MIN = 122;
	public static final int FIN_MAJ = 90;
	public static final int DEBUT_ACCENT = 224;
	public static final int FIN_ACCENT = 255;
	private char[] referenceAccent;
	
	private final String PATH_RESSOURCE = "src/ressource/";
	private final String REFERENCE_ACCENT = "referenceAccent.csv";
	
	//--CONSTRUCTEUR--
	private Generale(){
		referenceAccent = new char[30];
		initRef();
	}
	
	//--METHODES--
	private void initRef(){
		File f = new File(PATH_RESSOURCE+REFERENCE_ACCENT);
		FileReader fr;
		try {
			fr = new FileReader(f);
			BufferedReader b = new BufferedReader(fr);
			int i = 0, j = 0;
			int tmp = b.read();
			while(tmp != -1){
				if(tmp != 44 && tmp != 10){ //44 = ',' et 10 = '\n'
					referenceAccent[i] = (char)tmp;
					i++;
				}
				tmp = b.read();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Le fichier de configuration referenceAccent ne peut pas etre ouvert.");
		}
		catch (IOException e){
			System.out.println("La lecture dans le fichier referenceAccent a rencontrer un probleme.");
		}
	}
	
	public char[] getRefAccent(){
		return referenceAccent;
	}
}
