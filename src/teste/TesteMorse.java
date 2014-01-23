package teste;

import static org.junit.Assert.*;
import java.io.IOException;
import models.Morse;
import org.junit.Test;


public class TesteMorse {
	//------------------INITIALISATION-------------
	@Test
	public void referenceCorrectementRemplieParCSV() throws IOException{
		Morse cs = new Morse();
		assertTrue(cs.getReference()[0][0] == 0);
		assertTrue(cs.getReference()[35][0] == 5);
	}
	
	@Test
	public void accent(){
		Morse cs = new Morse();
		assertEquals(cs.morse("é"), ".");
	}
	//------------------NORMALE----------------
	@Test
	public void chaineVide() throws IOException{
		Morse cs = new Morse();
		assertEquals(cs.morse(""), "");
	}
	@Test
	public void chaineUnCharValideMin() throws IOException{
		Morse cs = new Morse();
		assertEquals(cs.morse("a"), ".-");
	}
	@Test
	public void chaineUnCharValideMax() throws IOException{
		Morse cs = new Morse();
		assertEquals(cs.morse("A"), ".-");
	}
	@Test
	public void chaineUnCharEspace() throws IOException{
		Morse cs = new Morse();
		assertEquals(cs.morse(" "), "//");
	}
	@Test
	public void chaineUnCharPoint() throws IOException{
		Morse cs = new Morse();
		assertEquals(cs.morse("."), "///");
	}
	@Test
	public void chaineCharInvalide() throws IOException{
		Morse cs = new Morse();
		assertEquals(cs.morse("°"), "°");
	}
	@Test
	public void chaineEstUnMotCorrect() throws IOException{
		Morse cs = new Morse();
		System.out.println(cs.morse("Emmanuel"));
		assertEquals(cs.morse("Emmanuel"), "./--/--/.-/-./..-/./.-..");
	}
	@Test
	public void chaineEstUnePhraseCorrect() throws IOException{
		Morse cs = new Morse();
		System.out.println(cs.morse("Emmanuel est cuit."));
		assertEquals(cs.morse("Emmanuel est cuit."), "./--/--/.-/-./..-/./.-..//./.../-//-.-./..-/../-///");
	}
	@Test
	public void chaineEstUnePhraseAvecParethentese() throws IOException{
		Morse cs = new Morse();
		assertEquals(cs.morse("Emmanuel est (cuit)."), "./--/--/.-/-./..-/./.-..//./.../-//(-.-./..-/../-)///");
	}
	
	//-----------------INVERSER---------------------------
	@Test
	public void InverseChaineVide() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse(""), "");
	}
	@Test
	public void InverseChaineUnCharValideMin() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse("a"), "-.");
	}
	@Test
	public void InverseChaineUnCharValideMax() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse("A"), "-.");
	}
	@Test
	public void InverseChaineUnCharEspace() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse(" "), "//");
	}
	@Test
	public void InverseChaineUnCharPoint() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse("."), "///");
	}
	@Test
	public void InverseChaineCharInvalide() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse("°"), "°");
	}
	@Test
	public void InverseChaineEstUnMotCorrect() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse("Emmanuel"), "-/../../-./.-/--./-/-.--");
	}
	@Test
	public void InverseChaineEstUnePhraseCorrect() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse("Emmanuel est cuit."), "-/../../-./.-/--./-/-.--//-/---/.//.-.-/--./--/.///");
	}
	@Test
	public void InverseChaineEstUnePhraseAvecParethentese() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		assertEquals(cs.morse("Emmanuel est (cuit)."), "-/../../-./.-/--./-/-.--//-/---/.//(.-.-/--./--/.)///");
	}
	//--------------BINAIRE NORMALE-------------------
	@Test
	public void binaireChaineVide() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse(""), "");
	}
	@Test
	public void binaireChaineUnCharValideMin() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse("a"), "01");
	}
	@Test
	public void binaireChaineUnCharValideMax() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse("A"), "01");
	}
	@Test
	public void binaireChaineUnCharEspace() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse(" "), "//");
	}
	@Test
	public void binaireChaineUnCharPoint() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse("."), "///");
	}
	@Test
	public void binaireChaineCharInvalide() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse("°"), "°");
	}
	@Test
	public void binaireChaineEstUnMotCorrect() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse("Emmanuel"), "0/11/11/01/10/001/0/0100");
	}
	@Test
	public void binaireChaineEstUnePhraseCorrect() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse("Emmanuel est cuit."), "0/11/11/01/10/001/0/0100//0/000/1//1010/001/00/1///");
	}
	@Test
	public void binaireChaineEstUnePhraseAvecParethentese() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(false);
		cs.setBinaire(true);
		assertEquals(cs.morse("Emmanuel est (cuit)."), "0/11/11/01/10/001/0/0100//0/000/1//(1010/001/00/1)///");
	}
	//--------------BINAIRE INVERSE-------------------
	@Test
	public void binaireInverseChaineVide() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse(""), "");
	}
	@Test
	public void binaireInverseChaineUnCharValideMin() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse("a"), "10");
	}
	@Test
	public void binaireInverseChaineUnCharValideMax() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse("A"), "10");
	}
	@Test
	public void binaireInverseChaineUnCharEspace() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse(" "), "//");
	}
	@Test
	public void binaireInverseChaineUnCharPoint() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse("."), "///");
	}
	@Test
	public void binaireInverseChaineCharInvalide() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse("°"), "°");
	}
	@Test
	public void binaireInverseChaineEstUnMotCorrect() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse("Emmanuel"), "1/00/00/10/01/110/1/1011");
	}
	@Test
	public void binaireInverseChaineEstUnePhraseCorrect() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse("Emmanuel est cuit."), "1/00/00/10/01/110/1/1011//1/111/0//0101/110/11/0///");
	}
	@Test
	public void binaireInverseChaineEstUnePhraseAvecParethentese() throws IOException{
		Morse cs = new Morse();
		cs.setInverse(true);
		cs.setBinaire(true);
		assertEquals(cs.morse("Emmanuel est (cuit)."), "1/00/00/10/01/110/1/1011//1/111/0//(0101/110/11/0)///");
	}
}