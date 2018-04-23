package content;

import java.util.ArrayList;
import java.util.List;

import commands.Command;

public class Enregistreur {

	private Boolean recording;
	private List<Enregistreur.Memento> savedStates;
	private Buffer bf;
	
	Enregistreur(Buffer bf){
		this.savedStates = new ArrayList<Enregistreur.Memento>();
		this.bf = bf;
		
	}
	
	public Boolean isRecording() {
		return recording;
	}
	
	public List<Enregistreur.Memento> getSavedStates() {
		return savedStates;
	}
	
	public void addSavedState(Enregistreur.Memento m) {
		this.savedStates.add(m);
	}
	
	public void enregistrer() {
		recording = true;
	}
	
	public void stopEnregistrement() {
		recording = false;
	}
	
	public List<Enregistreur.Memento>  rejouer() {
		if(!isRecording()) {
			return savedStates;
		}
		else {
			return null;
		}
	}
	
	public static class Memento {
		public final Command state;
		
		public Memento(Command stateToSave) {
			this.state = stateToSave;
		}
		
		public Command getSavedState() {
			return this.state;
		}
	}
	
	
	
}
