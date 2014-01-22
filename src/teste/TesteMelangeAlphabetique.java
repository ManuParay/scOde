package teste;

import static org.junit.Assert.*;

import models.Generale;
import models.MelangeAlphabetique;

import org.junit.Test;

public class TesteMelangeAlphabetique {
	@Test
	public void decalageRien(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger(""), "");
	}
	
	@Test
	public void decalageUneLettreDe1Min(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("z"), "a");
		m.setDecalage(-1);
		assertEquals(m.melanger("a"), "z");
	}
	
	@Test
	public void decalageUneLettreDe1Maj(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("Z"), "A");
		m.setDecalage(-1);
		assertEquals(m.melanger("A"), "Z");
	}
	
	@Test
	public void decalageUneLettreNMin(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(5);
		assertEquals(m.melanger("x"), "c");
		m.setDecalage(-3);
		assertEquals(m.melanger("o"), "l");
	}
	
	@Test
	public void decalageUneLettreNMaj(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(5);
		assertEquals(m.melanger("X"), "C");
		m.setDecalage(-3);
		assertEquals(m.melanger("O"), "L");
	}
	
	@Test
	public void decalageUnMot1(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("Emmanuel"), "Fnnbovfm");
		m.setDecalage(-1);
		assertEquals(m.melanger("Emmanuel"), "Dllzmtdk");
	}
	
	@Test
	public void decalageUnMotN(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(5);
		assertEquals(m.melanger("Emmanuel"), "Jrrfszjq");
		m.setDecalage(-10);
		assertEquals(m.melanger("Emmanuel"), "Uccqdkub");
	}
	
	@Test
	public void decalagePoint(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("."), ".");
		m.setDecalage(-1);
		assertEquals(m.melanger("."), ".");
	}
	
	@Test
	public void decalageEspace(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger(" "), " ");
		m.setDecalage(-1);
		assertEquals(m.melanger(" "), " ");
	}
	
	@Test
	public void decalageLettreInconnu(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("{"), "{");
		m.setDecalage(-1);
		assertEquals(m.melanger("{"), "{");
	}
	
	@Test
	public void declageAccent(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(1);
		assertEquals(m.melanger("é"), "f");
		m.setDecalage(-1);
		assertEquals(m.melanger("û"), "t");
	}
	
	@Test
	public void decalageUnePhrasePlusN(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(3);
		assertEquals(m.melanger("Emmanuel est cuit."), "Hppdqxho hvw fxlw.");
	}
	
	@Test
	public void decalageUnePhraseMoinsN(){
		MelangeAlphabetique m = new MelangeAlphabetique();
		m.setDecalage(-3);
		assertEquals(m.melanger("Hppdqxho hvw fxlw."), "Emmanuel est cuit.");
	}
}
