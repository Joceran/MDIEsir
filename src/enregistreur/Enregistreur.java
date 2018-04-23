package enregistreur;

import java.util.ArrayList;
import java.util.List;

import content.Buffer;

public class Enregistreur {

	private Boolean recording;
	private int nbSavedStates;
	private Buffer bf;
	
	Enregistreur(Buffer bf){
		nbSavedStates = 0;
		this.bf = bf;
		
	}
	
	public Boolean isRecording() {
		return recording;
	}
	
	public void enregistrer() {
		recording = true;
	}
	
	public void stopEnregistrement() {
		recording = false;
	}
	
	public Memento  rejouer() {
		if(!isRecording()) {
			return bf.ge;
		}
	}
	
	
}
