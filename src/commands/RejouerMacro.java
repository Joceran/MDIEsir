package commands;

import IHM.IHM;
import content.Buffer;

public class RejouerMacro implements Command{
	Buffer bf;
	IHM ihm; 
	
	public RejouerMacro(Buffer bf, IHM ihm) {
		this.bf = bf;
		this.ihm = ihm;
	}
	
	public void execute() {
		LogCommand.logBefore("Rejouer la macro", ihm, bf);
		bf.lire();
		ihm.setTexte(bf.getContent());
		ihm.setCurseurPosition(bf.getContent().length());
		bf.setCurseur(ihm.getCurseurPosition());
		LogCommand.logAfter("Rejouer la macro", ihm, bf);
		
	}
}
