package models;

public class Alphanumerique {
	//--ATTRIBUT--
	private int decalage;
	private boolean binaire;
	private String separateurLettres, separateurMots, separateurPhrases;

	//--CONSTRUCTEUR--
	public Alphanumerique(){
		decalage=0;
		binaire = false;
		separateurLettres = "/";
		separateurMots = "//";
		separateurPhrases = "///";
	}

	//--METHODE--
	public Object coder(String s){
		String newChaine = "";
		for(int i=0 ; i<s.length() ; i++){
			char sActu = s.charAt(i);
			int sActuInt = (int) sActu;
			if(sActuInt >= Generale.DEBUT_ACCENT && sActuInt <= Generale.FIN_ACCENT){
				sActu = Generale.g.getRefAccent()[sActuInt-224]; //Debut des caractere accent a 224
				sActuInt = (int) sActu;
			}
			if(sActuInt >= Generale.DEBUT_MIN && sActuInt <= Generale.FIN_MIN){
					if(binaire) newChaine += Integer.toBinaryString((((sActuInt-Generale.DEBUT_MIN)+26+decalage)%26)+1);
					else newChaine += (((sActuInt-Generale.DEBUT_MIN)+26+decalage)%26)+1;
					if(i+1<s.length() && s.charAt(i+1) != ' ' && s.charAt(i+1) != '.') newChaine += separateurLettres;
			}else if(sActuInt >= Generale.DEBUT_MAJ && sActuInt <= Generale.FIN_MAJ){
				if(binaire) newChaine += Integer.toBinaryString((((sActuInt-Generale.DEBUT_MAJ)+26+decalage)%26)+1);
				else newChaine += (((sActuInt-Generale.DEBUT_MAJ)+26+decalage)%26)+1;
				if(i+1<s.length() && s.charAt(i+1) != ' ' && s.charAt(i+1) != '.') newChaine += separateurLettres;
			}else if(sActu == ' '){
				newChaine += separateurMots;
			}else if(sActu == '.'){
				newChaine += separateurPhrases;
			}else{
				newChaine += sActu;
			}
		}
		return newChaine;
	}

	public void setDecalage(int i){
		decalage = i;
	}
	public void setSeparateurLettres(String sLettres) {
		separateurLettres = sLettres;
	}
	public void setSeparateurMots(String sMots) {
		separateurMots = sMots;
	}
	public void setSeparateurPhrases(String sPhrases) {
		separateurPhrases = sPhrases;
	}
	public void setBinaire(boolean b){
		binaire = b;
	}
}
