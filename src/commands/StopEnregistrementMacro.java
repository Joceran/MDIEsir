package commands;

import IHM.IHM;
import content.Buffer;

public class StopEnregistrementMacro implements Command {

	Buffer bf;
	IHM ihm; 
	
	public StopEnregistrementMacro(Buffer bf, IHM ihm) {
		this.bf = bf;
		this.ihm = ihm;
	}
	
	public void execute() {
		LogCommand.logBefore("Arreter l'enregistrement", ihm, bf);
		bf.stopenregistrement();
		LogCommand.logAfter("Arreter l'enregistrement", ihm, bf);
		
	}

}
