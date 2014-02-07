package models;

public class Alphabetique {
	//--ATTRIBUT--
	private final char[] ACCENT = Generale.g.getRefAccent();

	private char[] referenceCle;
	private int decalage;
	private String cle;

	//--CONSTRUCTEUR--
	public Alphabetique(){
		decalage = 0;
		cle = "";
		referenceCle = new char[26];
		for(int i=0 ; i<26 ; i++) referenceCle[i] = ' ';
	}

	//--METHODES--
	public String coder(String s) {
		String chaineMelange = "";
		if(cle.equals("")){
			for(int i=0 ; i<s.length() ; i++){
				char charActu = s.charAt(i); 
				if(charActu >= 224 && charActu <= 253 ) //char accentue
					charActu = ACCENT[charActu-224]; //Debut des char accentue a 224.
				if(charActu >= 65 && charActu <= 90){ //CHAR MAJ
					if(!cle.equals("")) charActu = referenceCle[charActu-65];
					int tmp = (charActu+decalage)-65;
					if(tmp<0) tmp = 91-(65-tmp);
					chaineMelange += (char) ((tmp%26)+65);
				}else if(charActu >= 97 && charActu <= 122){ //char min
					if(!cle.equals("")) charActu = referenceCle[charActu-97];
					int tmp = (charActu+decalage)-97;
					if(tmp<0) tmp = 123-(97-tmp);
					chaineMelange += (char) ((tmp%26)+97);
				}else{
					chaineMelange += charActu;
				}
			}
		}else{ //Codage avec cle
			
		}

		return chaineMelange;
	}

	public void setDecalage(int n){
		decalage = n;
	}
	public void setCle(String s){
		cle = s.toLowerCase();
		for(int i=0 ; i<cle.length() ; i++)
			if(((int)cle.charAt(i) < 97 || (int)cle.charAt(i) > 122)
					|| (cle.indexOf(cle.charAt(i)) != cle.lastIndexOf(cle.charAt(i)))) cle = "";
		if(!s.equals("")){
			for(int i=0 ; i<cle.length() ; i++)
				referenceCle[i] = cle.charAt(i);

			int index = cle.length();
			for(int i=0 ; i<26 ; i++){
				if(!cle.contains(((char)(i+97))+"")){
					referenceCle[index] = (char) (i+97);
					index++;
				}
			}
		}
	}
	public String getCle(){
		return cle;
	}
	public char[] getReferenceCle(){
		return referenceCle;
	}

	//--TESTE---
	public static void main(String args[]){
		new Alphabetique();
	}
}
