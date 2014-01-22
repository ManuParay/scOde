package teste;

import static org.junit.Assert.*;

import models.Generale;
import models.MelangeAlphabetique;
import models.MelangeAlphanumerique;

import org.junit.Before;
import org.junit.Test;

public class TestMelangeAlphanumerique {
	MelangeAlphanumerique m;
	@Before
	public void setUp(){
		m = new MelangeAlphanumerique();
	}
	
	@Test
	public void chaineVide(){
		assertEquals(m.coder(""), "");
		m.setDecelage(-1);
		assertEquals(m.coder(""), "");
		m.setDecelage(1);
		assertEquals(m.coder(""), "");
	}
	@Test
	public void charInconnu(){
		assertEquals(m.coder("#"), "#");
		m.setDecelage(-1);
		assertEquals(m.coder("#"), "#");
		m.setDecelage(1);
		assertEquals(m.coder("#"), "#");
	}
	@Test
	public void charSimple(){
		m.setDecelage(0);
		assertEquals(m.coder("A"), "1");
		assertEquals(m.coder("a"), "1");
		m.setDecelage(-1);
		assertEquals(m.coder("A"), "26");
		assertEquals(m.coder("a"), "26");
		m.setDecelage(1);
		assertEquals(m.coder("Z"), "1");
		assertEquals(m.coder("z"), "1");
	}
	@Test
	public void charAccent(){
		m.setDecelage(0);
		assertEquals(m.coder("é"), "5");
		m.setDecelage(-1);
		assertEquals(m.coder("é"), "4");
		m.setDecelage(1);
		assertEquals(m.coder("é"), "6");
	}
	@Test
	public void espace(){
		m.setDecelage(0);
		assertEquals(m.coder(" "), "//");
		m.setDecelage(-1);
		assertEquals(m.coder(" "), "//");
		m.setDecelage(1);
		assertEquals(m.coder(" "), "//");
	}
	@Test
	public void point(){
		m.setDecelage(0);
		assertEquals(m.coder("."), "///");
		m.setDecelage(-1);
		assertEquals(m.coder("."), "///");
		m.setDecelage(1);
		assertEquals(m.coder("."), "///");
	}
	@Test
	public void mot(){
		m.setDecelage(0);
		assertEquals(m.coder("Manu"), "13/1/14/21");
		m.setDecelage(-1);
		assertEquals(m.coder("Manu"), "12/26/13/20");
		m.setDecelage(1);
		assertEquals(m.coder("Manu"), "14/2/15/22");
	}
	@Test
	public void phrase(){
		m.setDecelage(0);
		assertEquals(m.coder("Manu e."), "13/1/14/21//5///");
		m.setDecelage(-1);
		assertEquals(m.coder("Manu e."), "12/26/13/20//4///");
		m.setDecelage(1);
		assertEquals(m.coder("Manu e."), "14/2/15/22//6///");
	}
	
}