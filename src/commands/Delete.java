package commands;

import IHM.IHM;
import content.Buffer;

public class Delete implements Command {
	Buffer bf;
	IHM ihm;
	
	public Delete(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
	}
	
	@Override
	public void execute() {
		LogCommand.logBefore("Delete", ihm, bf);
		int curseur = ihm.getCurseurPosition();
		bf.setCurseur(curseur);
		bf.delete();
		ihm.setTexte(bf.getContent());
		if (curseur > 0) {
			ihm.setCurseurPosition(curseur - 1);
			bf.setCurseur(curseur - 1);
		}
		LogCommand.logAfter("Delete", ihm, bf);
	}

}
