package commands;

import IHM.IHM;
import content.Buffer;

public class EnregistrerMacro implements Command {

	Buffer bf;
	IHM ihm; 
	
	public EnregistrerMacro(Buffer bf, IHM ihm) {
		this.bf = bf;
		this.ihm = ihm;
	}
	
	public void execute() {
		LogCommand.logBefore("Enregistrer une macro", ihm, bf);
		//bf.enregistrer();
		LogCommand.logAfter("Enregistrer une macro", ihm, bf);
		
	}

}
