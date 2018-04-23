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
	
	@Test
	public void undo() {
		bf.inserer("a");
		bf.inserer("b");
		bf.undo();
		
		assertEquals(bf.getContent(), "a");
	}
	
	@Test
	public void redo() {
		bf.inserer("a");
		bf.inserer("b");
		bf.undo();
		bf.redo();
		
		assertEquals(bf.getContent(), "ab");
	}
	
	@Test
	public void deplacementCurseurEtEcriture() {
		bf.inserer("a");
		bf.setCurseur(bf.getCurseur() - 1);
		bf.inserer("b");
		
		assertEquals(bf.getContent(), "ba");
	}
	
	

}
