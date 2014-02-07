package teste;

import static org.junit.Assert.*;
import models.Alphabetique;

import org.junit.Before;
import org.junit.Test;

public class TesteAlphabetique {
	private Alphabetique m;
	@Before
	public void setUp(){
		m = new Alphabetique();
	}
	@Test
	public void refCle(){
		char[] tmp = new char[26];
		for(int i=0 ; i<26 ; i++) tmp[i] = ' ';
		//INIT referenceCle
		for(int i=0 ; i<26 ; i++) assertEquals(m.getReferenceCle()[i], tmp[i]);

		//SetCle("")
		m.setCle("");
		for(int i=0 ; i<26 ; i++) assertEquals(m.getReferenceCle()[i], tmp[i]);

		//SetCle(minuscule)
		m.setCle("hawkins");
		assertEquals(m.getReferenceCle()[0], 'h');
		assertEquals(m.getReferenceCle()[10], 'e');
		assertEquals(m.getReferenceCle()[25], 'z');

		//SetCle(majuscule)
		m.setCle("HAWKINS");
		assertEquals(m.getCle(), "hawkins");
		assertEquals(m.getReferenceCle()[0], 'h');
		assertEquals(m.getReferenceCle()[10], 'e');
		assertEquals(m.getReferenceCle()[25], 'z');

		//SetCle(char invalide)
		m.setCle("hawkinsù");
		assertEquals(m.getCle(), "");
		
		//SetCle(char redondant)
		m.setCle("haawkins");
		assertEquals(m.getCle(), "");
	}
	@Test
	public void decalageRien(){
		m.setDecalage(1);
		assertEquals(m.coder(""), "");
		m.setDecalage(-1);
		assertEquals(m.coder(""), "");
		m.setCle("");
		assertEquals(m.coder(""), "");
		m.setCle("aze");
		assertEquals(m.coder(""), "");
	}

	@Test
	public void decalageUneLettreDe1(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.coder("z"), "a");
		assertEquals(m.coder("A"), "Z");
		m.setDecalage(-1);
		assertEquals(m.coder("a"), "z");
		assertEquals(m.coder("Z"), "A");
	}
	@Test
	public void decalageUneLettreNMin(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(5);
		assertEquals(m.coder("x"), "c");
		m.setDecalage(-3);
		assertEquals(m.coder("o"), "l");
	}

	@Test
	public void decalageUneLettreNMaj(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(5);
		assertEquals(m.coder("X"), "C");
		m.setDecalage(-3);
		assertEquals(m.coder("O"), "L");
	}

	@Test
	public void decalageUnMot1(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.coder("Emmanuel"), "Fnnbovfm");
		m.setDecalage(-1);
		assertEquals(m.coder("Emmanuel"), "Dllzmtdk");
	}

	@Test
	public void decalageUnMotN(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(5);
		assertEquals(m.coder("Emmanuel"), "Jrrfszjq");
		m.setDecalage(-10);
		assertEquals(m.coder("Emmanuel"), "Uccqdkub");
	}

	@Test
	public void decalagePoint(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.coder("."), ".");
		m.setDecalage(-1);
		assertEquals(m.coder("."), ".");
	}

	@Test
	public void decalageEspace(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.coder(" "), " ");
		m.setDecalage(-1);
		assertEquals(m.coder(" "), " ");
	}

	@Test
	public void decalageLettreInconnu(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.coder("{"), "{");
		m.setDecalage(-1);
		assertEquals(m.coder("{"), "{");
	}

	@Test
	public void declageAccent(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.coder("é"), "f");
		m.setDecalage(-1);
		assertEquals(m.coder("û"), "t");
	}

	@Test
	public void decalageUnePhrasePlusN(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(3);
		assertEquals(m.coder("Emmanuel est cuit."), "Hppdqxho hvw fxlw.");
	}

	@Test
	public void decalageUnePhraseMoinsN(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(-3);
		assertEquals(m.coder("Hppdqxho hvw fxlw."), "Emmanuel est cuit.");
	}
}
