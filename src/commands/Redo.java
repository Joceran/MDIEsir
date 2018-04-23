package commands;

import IHM.IHM;
import content.Buffer;

public class Redo implements Command {
	Buffer bf;
	IHM ihm;
	
	public Redo(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
	}
	
	@Override
	public void execute() {
		LogCommand.logBefore("Redo", ihm, bf);
		this.ihm.getSelectionner();
		bf.redo();
		ihm.setTexte(bf.getContent());
		ihm.setCurseurPosition(bf.getContent().length());
		bf.setCurseur(ihm.getCurseurPosition());
		LogCommand.logAfter("Redo", ihm, bf);

	}

}
