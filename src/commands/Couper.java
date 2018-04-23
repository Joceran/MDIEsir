package commands;

import IHM.IHM;
import content.Buffer;

public class Couper implements Command {
	Buffer bf;
	IHM ihm;
	
	public Couper(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
	}
	@Override
	public void execute() {
		LogCommand.logBefore("Couper", ihm, bf);
		this.ihm.getSelectionner();
		int curseur = ihm.getCurseurPosition();
		bf.couper();
		ihm.setTexte(bf.getContent());
		ihm.setCurseurPosition(curseur);
		bf.setCurseur(ihm.getCurseurPosition());
		LogCommand.logAfter("Couper", ihm, bf);
	}

}
