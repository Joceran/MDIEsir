package commands;

import IHM.IHM;
import content.Buffer;

public class Inserer implements Command {
	Buffer bf;
	IHM ihm;
	
	public Inserer(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
	}
	
	@Override
	public void execute() {
		LogCommand.logBefore("Inserer", ihm, bf);
		int curseur = ihm.getCurseurPosition();
		String toInsert = ihm.getTexteAInserer();
		bf.setCurseur(curseur);
		bf.inserer(toInsert);
		ihm.setTexteAInserer("");
		ihm.setTexte(bf.getContent());
		ihm.setCurseurPosition(curseur + toInsert.length());
		bf.setCurseur(ihm.getCurseurPosition());
		LogCommand.logAfter("Inserer", ihm, bf);
	}
	
}
