package content;

import java.util.ArrayList;
import java.util.List;


public class Buffer {

	private String content;
	PressePapier pp;
	Select sl;
	int curseur;
	
	private List<Buffer.Memento> savedStates;
	private int currentState;
	private int lastState;
	

	public Buffer(){
		setContent("");
		sl = new Select(this);
		pp = new PPImpl();
		curseur = 0;
		savedStates = new ArrayList<Buffer.Memento>();
		savedStates.add(new Memento(""));
		currentState = 0;
		lastState = 0;
	}
	
	public void couper(){
		System.out.println(sl.getDebut()+" | "+sl.getFin());
		pp.lire(sl.getSelection());
		StringBuilder str = new StringBuilder(content);
		str.delete(sl.getDebut(), sl.getFin());
		content = str.toString();
		savedStates.add(saveToMemento());
		currentState++;
		lastState = currentState;
	}
	
	public void copier(){
		pp.lire(sl.getSelection());
	}
	
	public void coller(){
		StringBuilder str = new StringBuilder(content);
		String s = pp.ecrire();
		if(s != null){
			str.insert(curseur, s);
			setContent(str.toString());
			savedStates.add(saveToMemento());
			currentState++;
			lastState = currentState;
		}
	}
	
	public void inserer(String s){
		StringBuilder str = new StringBuilder(content);
		
		if(s != null){
			str.insert(curseur, s);
			setContent(str.toString());
			savedStates.add(saveToMemento());
			currentState++;
			lastState = currentState;
		}
	}
	
	public void selectionner(int debut, int fin){
		assert((debut >= 0) && (fin <= getContent().length()) && (debut <= fin));
		sl.setDebut(debut);
		sl.setFin(fin);
	}

	public void delete() {
		StringBuilder str = new StringBuilder(content);
		
		if(str.length() > 0){
			str.delete(curseur-1, curseur);
			setContent(str.toString());
		}
		else {
			setContent("");
		}
		savedStates.add(saveToMemento());
		currentState++;
	}

	public String getContent() {
		return content;
	}
	
	public char getChar(int index){
		return content.charAt(index);
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getCurseur(){
		return this.curseur;
	}
	
	public void setCurseur(int c){
		this.curseur = c;
	}
	
	public String getClipboardContent() {
		return pp.ecrire();
	}
	
	public void undo() {
		if(currentState > 0) {
			currentState--;
			restoreFromMemento(savedStates.get(currentState));
		}
		else {
			restoreFromMemento(savedStates.get(0));
		}
		
	}
	
	public void redo() {
		if(currentState < savedStates.size()) {
			currentState++;
			restoreFromMemento(savedStates.get(currentState));
		}
	}
	
	public Memento saveToMemento(){
		return new Memento(this.getContent());
	}
	
	public void restoreFromMemento(Memento memento){
		this.setContent(memento.getSavedState());
	} 
	
	public int getCurrentStateNumber() {
		return currentState;
	}

	
	//Version 3 (WIP)
	public void lire() {
		// TODO Auto-generated method stub
		
	}

	public void enregistrer() {
		// TODO Auto-generated method stub
		
	}

	public void stopenregistrement() {	
		// TODO Auto-generated method stub
		
	}
	
	public static class Memento {
		public final String state;
		
		public Memento(String stateToSave){
			this.state = stateToSave;
		}
		
		public String getSavedState(){
			return this.state;
		}
	}
}
