package models;

public class MelangeAlphanumerique {
	private int decalage;
	private String separateurLettres, separateurMots, separateurPhrases;

	public MelangeAlphanumerique(){
		decalage=0;
		separateurLettres = "/";
		separateurMots = "//";
		separateurPhrases = "///";
	}

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
					newChaine += (((sActuInt-Generale.DEBUT_MIN)+26+decalage)%26)+1;
					if(i+1<s.length() && s.charAt(i+1) != ' ' && s.charAt(i+1) != '.') newChaine += separateurLettres;
			}else if(sActuInt >= Generale.DEBUT_MAJ && sActuInt <= Generale.FIN_MAJ){
				newChaine += (((sActuInt-Generale.DEBUT_MAJ)+26+decalage)%26)+1;
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

	public void setDecelage(int i){
		decalage = i;
	}

}
