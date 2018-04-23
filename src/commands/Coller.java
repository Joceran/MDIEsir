package commands;

import IHM.IHM;
import content.Buffer;
import enregistreur.Enregistreur;

public class Coller implements Command {
	Buffer bf;
	IHM ihm;
	Enregistreur enr;
	
	public Coller(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
	}
	@Override
	public void execute() {
		LogCommand.logBefore("Coller", ihm, bf);
		int curseur = ihm.getCurseurPosition();
		bf.setCurseur(curseur);
		bf.coller();
		ihm.setTexte(bf.getContent());
		ihm.setCurseurPosition(curseur + bf.getClipboardContent().length());
		bf.setCurseur(ihm.getCurseurPosition());
		LogCommand.logAfter("Coller", ihm, bf);
	}

}
