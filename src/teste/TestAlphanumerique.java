package teste;

import static org.junit.Assert.*;
import models.Alphanumerique;
import org.junit.Before;
import org.junit.Test;

public class TestAlphanumerique {
	Alphanumerique m;
	@Before
	public void setUp(){
		m = new Alphanumerique();
	}
	/*---------GENERAL---------*/
	@Test
	public void chaineVide(){
		assertEquals(m.coder(""), "");
		m.setDecalage(-1);
		assertEquals(m.coder(""), "");
		m.setDecalage(1);
		assertEquals(m.coder(""), "");
	}
	@Test
	public void charInconnu(){
		assertEquals(m.coder("#"), "#");
		m.setDecalage(-1);
		assertEquals(m.coder("#"), "#");
		m.setDecalage(1);
		assertEquals(m.coder("#"), "#");
	}
	@Test
	public void espace(){
		m.setDecalage(0);
		assertEquals(m.coder(" "), "//");
		m.setDecalage(-1);
		assertEquals(m.coder(" "), "//");
		m.setDecalage(1);
		assertEquals(m.coder(" "), "//");
	}
	@Test
	public void point(){
		m.setDecalage(0);
		assertEquals(m.coder("."), "///");
		m.setDecalage(-1);
		assertEquals(m.coder("."), "///");
		m.setDecalage(1);
		assertEquals(m.coder("."), "///");
	}
	/*----------NORMALE-----------------*/
	@Test
	public void charSimple(){
		m.setDecalage(0);
		assertEquals(m.coder("A"), "1");
		assertEquals(m.coder("a"), "1");
		m.setDecalage(-1);
		assertEquals(m.coder("A"), "26");
		assertEquals(m.coder("a"), "26");
		m.setDecalage(1);
		assertEquals(m.coder("Z"), "1");
		assertEquals(m.coder("z"), "1");
	}
	@Test
	public void charAccent(){
		m.setDecalage(0);
		assertEquals(m.coder("é"), "5");
		m.setDecalage(-1);
		assertEquals(m.coder("é"), "4");
		m.setDecalage(1);
		assertEquals(m.coder("é"), "6");
	}
	@Test
	public void mot(){
		m.setDecalage(0);
		assertEquals(m.coder("Manu"), "13/1/14/21");
		m.setDecalage(-1);
		assertEquals(m.coder("Manu"), "12/26/13/20");
		m.setDecalage(1);
		assertEquals(m.coder("Manu"), "14/2/15/22");
	}
	@Test
	public void phrase(){
		m.setDecalage(0);
		assertEquals(m.coder("Manu e."), "13/1/14/21//5///");
		m.setDecalage(-1);
		assertEquals(m.coder("Manu e."), "12/26/13/20//4///");
		m.setDecalage(1);
		assertEquals(m.coder("Manu e."), "14/2/15/22//6///");
	}
	/*------------BINAIRE ET BINAIRE DECALER (FIXE ou LONGUEUR MINIMAL)-------------*/
	@Test
	public void charSimpleBinaire(){
		m.setBinaire(true);
		//LONGUEUR MINIMAL
		m.setDecalage(0);
		assertEquals(m.coder("A"), "1");
		assertEquals(m.coder("a"), "1");
		m.setDecalage(-1);
		assertEquals(m.coder("A"), "11010");
		assertEquals(m.coder("a"), "11010");
		m.setDecalage(1);
		assertEquals(m.coder("Z"), "1");
		assertEquals(m.coder("z"), "1");
	}
	@Test
	public void charAccentBinaire(){
		m.setBinaire(true);
		//LONGUEUR MINIMAL
		m.setDecalage(0);
		assertEquals(m.coder("é"), "101");
		m.setDecalage(-1);
		assertEquals(m.coder("é"), "100");
		m.setDecalage(1);
		assertEquals(m.coder("é"), "110");
	}
	@Test
	public void motBinaire(){
		m.setBinaire(true);
		//LONGUEUR MINIMAL
		m.setDecalage(0);
		assertEquals(m.coder("Manu"), "1101/1/1110/10101");
		m.setDecalage(-1);
		assertEquals(m.coder("Manu"), "1100/11010/1101/10100");
		m.setDecalage(1);
		assertEquals(m.coder("Manu"), "1110/10/1111/10110");
	}
	@Test
	public void phraseBinaire(){
		m.setBinaire(true);
		//LONGUEUR MINIMAL
		m.setDecalage(0);
		assertEquals(m.coder("Manu e."), "1101/1/1110/10101//101///");
		m.setDecalage(-1);
		assertEquals(m.coder("Manu e."), "1100/11010/1101/10100//100///");
		m.setDecalage(1);
		assertEquals(m.coder("Manu e."), "1110/10/1111/10110//110///");
	}
}
