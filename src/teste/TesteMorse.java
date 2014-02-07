package teste;

import static org.junit.Assert.*;
import java.io.IOException;
import models.Morse;

import org.junit.Before;
import org.junit.Test;


public class TesteMorse {
	private Morse m;
	@Before
	public void setUp(){
		m = new Morse();
	}
	//------------------INITIALISATION-------------
	@Test
	public void referenceCorrectementRemplieParCSV() throws IOException{
		assertTrue(m.getReference()[0][0] == 0);
		assertTrue(m.getReference()[35][0] == 5);
	}

	@Test
	public void accent(){
		assertEquals(m.coder("eé"), "./.");
	}
	//------------------GENERALE----------------
	@Test
	public void chaineVide() throws IOException{
		m.setInverse(false);
		assertEquals(m.coder(""), "");
		m.setInverse(true);
		assertEquals(m.coder(""), "");
		m.setBinaire(true);
		assertEquals(m.coder(""), "");
	}
	@Test
	public void chaineUnCharEspace() throws IOException{
		m.setInverse(false);
		assertEquals(m.coder(" "), "//");
		m.setInverse(true);
		assertEquals(m.coder(" "), "//");
		m.setBinaire(true);
		assertEquals(m.coder(" "), "//");
	}
	@Test
	public void chaineUnCharPoint() throws IOException{
		m.setInverse(false);
		assertEquals(m.coder("."), "///");
		m.setInverse(true);
		assertEquals(m.coder("."), "///");
		m.setBinaire(true);
		assertEquals(m.coder("."), "///");
	}
	@Test
	public void chaineCharInvalide() throws IOException{
		m.setInverse(false);
		assertEquals(m.coder("°"), "°");
		m.setInverse(true);
		assertEquals(m.coder("°"), "°");
		m.setBinaire(true);
		assertEquals(m.coder("°"), "°");
	}
	//------------------MOSRE----------------
	@Test
	public void chaineUnCharValide() throws IOException{
		m.setInverse(false);
		assertEquals(m.coder("a"), ".-");
		assertEquals(m.coder("A"), ".-");
		m.setInverse(true);
		assertEquals(m.coder("a"), "-.");
		assertEquals(m.coder("A"), "-.");
	}
	@Test
	public void chaineEstUnMotCorrect() throws IOException{
		m.setInverse(false);
		assertEquals(m.coder("Emmanuel"), "./--/--/.-/-./..-/./.-..");
		m.setInverse(true);
		assertEquals(m.coder("Emmanuel"), "-/../../-./.-/--./-/-.--");
	}
	@Test
	public void chaineEstUnePhraseCorrect() throws IOException{
		m.setInverse(false);
		assertEquals(m.coder("Emmanuel est cuit."), "./--/--/.-/-./..-/./.-..//./.../-//-.-./..-/../-///");
		m.setInverse(true);
		assertEquals(m.coder("Emmanuel est cuit."), "-/../../-./.-/--./-/-.--//-/---/.//.-.-/--./--/.///");
	}
	@Test
	public void chaineEstUnePhraseAvecParethentese() throws IOException{
		m.setInverse(false);
		assertEquals(m.coder("Emmanuel est (cuit)."), "./--/--/.-/-./..-/./.-..//./.../-//(-.-./..-/../-)///");
		m.setInverse(true);
		assertEquals(m.coder("Emmanuel est (cuit)."), "-/../../-./.-/--./-/-.--//-/---/.//(.-.-/--./--/.)///");
	}

	//--------------BINAIRE-------------------
	@Test
	public void binaireChaineUnCharValideMin() throws IOException{
		m.setBinaire(true);
		m.setInverse(false);
		assertEquals(m.coder("a"), "01");
		assertEquals(m.coder("A"), "01");
		m.setInverse(true);
		assertEquals(m.coder("a"), "10");
		assertEquals(m.coder("A"), "10");
	}
	@Test
	public void binaireChaineEstUnMotCorrect() throws IOException{
		m.setBinaire(true);
		m.setInverse(false);
		assertEquals(m.coder("Emmanuel"), "0/11/11/01/10/001/0/0100");
		m.setInverse(true);
		assertEquals(m.coder("Emmanuel"), "1/00/00/10/01/110/1/1011");
		
	}
	@Test
	public void binaireChaineEstUnePhraseCorrect() throws IOException{
		m.setBinaire(true);
		m.setInverse(false);
		assertEquals(m.coder("Emmanuel est cuit."), "0/11/11/01/10/001/0/0100//0/000/1//1010/001/00/1///");
		m.setInverse(true);
		assertEquals(m.coder("Emmanuel est cuit."), "1/00/00/10/01/110/1/1011//1/111/0//0101/110/11/0///");
	}
	@Test
	public void binaireChaineEstUnePhraseAvecParethentese() throws IOException{
		m.setBinaire(true);
		m.setInverse(false);
		assertEquals(m.coder("Emmanuel est (cuit)."), "0/11/11/01/10/001/0/0100//0/000/1//(1010/001/00/1)///");
		m.setInverse(true);
		assertEquals(m.coder("Emmanuel est (cuit)."), "1/00/00/10/01/110/1/1011//1/111/0//(0101/110/11/0)///");
	}
}