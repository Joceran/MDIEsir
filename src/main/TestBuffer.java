package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import content.Buffer;

public class TestBuffer {

	private Buffer bf;
	
	@Before
	public void setup(){
		bf = new Buffer();
	}
	
	@Test
	public void copy() {
		bf.setContent("Coucou");
		bf.selectionner(0, bf.getContent().length());
		bf.copier();
		bf.setCurseur(bf.getContent().length());
		bf.coller();
		
		assertEquals(bf.getContent(), "CoucouCoucou");
		
	}
	
	@Test
	public void cut(){
		bf.setContent("Coucou");
		bf.selectionner(0, bf.getContent().length());
		bf.couper();
		
		assertEquals(bf.getContent(), "");
		
		bf.setCurseur(bf.getContent().length());
		bf.coller();
		
		assertEquals(bf.getContent(), "Coucou");
		
	}
	
	//Le coller marche par extension
	
	

}
