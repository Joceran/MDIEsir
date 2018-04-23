package commands;

import IHM.IHM;
import content.Buffer;

public class DeplacerCurseur implements Command {
	Buffer bf;
	IHM ihm;
	
	public DeplacerCurseur(Buffer bf, IHM ihm){
		this.bf = bf;
		this.ihm = ihm;
	}
	
	@Override
	public void execute() {
		bf.setCurseur(ihm.getCurseurPosition());
	}
}
