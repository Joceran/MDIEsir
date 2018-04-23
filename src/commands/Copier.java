package commands;

import IHM.IHM;
import content.Buffer;

public class Copier implements Command {
	Buffer bf;
	IHM ihm;
	
	public Copier(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
	}
	
	@Override
	public void execute() {
		LogCommand.logBefore("Copier", ihm, bf);
		this.ihm.getSelectionner();
		int curseur = ihm.getCurseurPosition();
		bf.copier();
		ihm.setTexte(bf.getContent());
		ihm.setCurseurPosition(curseur);
		bf.setCurseur(ihm.getCurseurPosition());
		LogCommand.logAfter("Copier", ihm, bf);
	}
	
}
