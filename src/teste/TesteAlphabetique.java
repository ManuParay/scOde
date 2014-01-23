package teste;

import static org.junit.Assert.*;
import models.Alphabetique;
import org.junit.Test;

public class TesteAlphabetique {
	@Test
	public void decalageRien(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger(""), "");
	}
	
	@Test
	public void decalageUneLettreDe1Min(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("z"), "a");
		m.setDecalage(-1);
		assertEquals(m.melanger("a"), "z");
	}
	
	@Test
	public void decalageUneLettreDe1Maj(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("Z"), "A");
		m.setDecalage(-1);
		assertEquals(m.melanger("A"), "Z");
	}
	
	@Test
	public void decalageUneLettreNMin(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(5);
		assertEquals(m.melanger("x"), "c");
		m.setDecalage(-3);
		assertEquals(m.melanger("o"), "l");
	}
	
	@Test
	public void decalageUneLettreNMaj(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(5);
		assertEquals(m.melanger("X"), "C");
		m.setDecalage(-3);
		assertEquals(m.melanger("O"), "L");
	}
	
	@Test
	public void decalageUnMot1(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("Emmanuel"), "Fnnbovfm");
		m.setDecalage(-1);
		assertEquals(m.melanger("Emmanuel"), "Dllzmtdk");
	}
	
	@Test
	public void decalageUnMotN(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(5);
		assertEquals(m.melanger("Emmanuel"), "Jrrfszjq");
		m.setDecalage(-10);
		assertEquals(m.melanger("Emmanuel"), "Uccqdkub");
	}
	
	@Test
	public void decalagePoint(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("."), ".");
		m.setDecalage(-1);
		assertEquals(m.melanger("."), ".");
	}
	
	@Test
	public void decalageEspace(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger(" "), " ");
		m.setDecalage(-1);
		assertEquals(m.melanger(" "), " ");
	}
	
	@Test
	public void decalageLettreInconnu(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("{"), "{");
		m.setDecalage(-1);
		assertEquals(m.melanger("{"), "{");
	}
	
	@Test
	public void declageAccent(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("é"), "f");
		m.setDecalage(-1);
		assertEquals(m.melanger("û"), "t");
	}
	
	@Test
	public void decalageUnePhrasePlusN(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(3);
		assertEquals(m.melanger("Emmanuel est cuit."), "Hppdqxho hvw fxlw.");
	}
	
	@Test
	public void decalageUnePhraseMoinsN(){
		Alphabetique m = new Alphabetique();
		m.setDecalage(-3);
		assertEquals(m.melanger("Hppdqxho hvw fxlw."), "Emmanuel est cuit.");
	}
}
