package models;

public class Alphabetique {
	//--ATTRIBUT--
	private int decalage;	
	private char[] accent;

	//--CONSTRUCTEUR--
	public Alphabetique(){
		decalage = 0;
		accent = Generale.g.getRefAccent();
	}

	//--METHODES--
	public String melanger(String s) {
		String chaineMelange = "";
		for(int i=0 ; i<s.length() ; i++){
			char charActu = s.charAt(i); 
			if(charActu >= 224 && charActu <= 253 ){ //char accentue
				charActu = accent[charActu-224]; //Debut des char accentue a 224.
			}
			if(charActu >= 65 && charActu <= 90){
				int tmp = (charActu+decalage)-65;
				if(tmp<0) tmp = 91-(65-tmp);
				chaineMelange += (char) ((tmp%26)+65);
			}else if(charActu >= 97 && charActu <= 122){
				int tmp = (charActu+decalage)-97;
				if(tmp<0) tmp = 123-(97-tmp);
				chaineMelange += (char) ((tmp%26)+97);
			}else{
				chaineMelange += charActu;
			}
		}
		return chaineMelange;
	}

	public void setDecalage(int n){
		decalage = n;
	}
		
	//--TESTE---
	public static void main(String args[]){
		new Alphabetique();
	}
}
