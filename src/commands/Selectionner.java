package commands;

import IHM.IHM;
import content.Buffer;

public class Selectionner implements Command {
	Buffer bf;
	IHM ihm;
	
	private int debut;
	private int fin;
	
	public Selectionner(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
		setDebut(0);
		setFin(0);
	}
	
	@Override
	public void execute() {
		bf.selectionner(getDebut(), getFin());
	}

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}
}
