package commands;

import IHM.IHM;
import content.Buffer;

public class Undo implements Command {
	Buffer bf;
	IHM ihm;
	
	public Undo(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
	}
	
	@Override
	public void execute() {
		LogCommand.logBefore("Undo", ihm, bf);
		this.ihm.getSelectionner();
		bf.undo();
		ihm.setTexte(bf.getContent());
		ihm.setCurseurPosition(bf.getContent().length());
		bf.setCurseur(ihm.getCurseurPosition());
		LogCommand.logAfter("Undo", ihm, bf);

	}

}
