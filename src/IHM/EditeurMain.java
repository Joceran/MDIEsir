package IHM;

import commands.Coller;
import commands.Copier;
import commands.Couper;
import commands.Delete;
import commands.DeplacerCurseur;
import commands.EnregistrerMacro;
import commands.Inserer;
import commands.Redo;
import commands.RejouerMacro;
import commands.Selectionner;
import commands.StopEnregistrementMacro;
import commands.Undo;
import content.Buffer;

public class EditeurMain {

	public static void main(String[] args) {
		Buffer bf = new Buffer();
	
		IHM ihm = new IHM();
		ihm.setCommandColler(new Coller(bf, ihm));
		ihm.setCommandCopier(new Copier(bf, ihm));
		ihm.setCommandCouper(new Couper(bf, ihm));
		ihm.setCommandInserer(new Inserer(bf, ihm));
		ihm.setCommandSelectionner(new Selectionner(bf, ihm));
		ihm.setDelete(new Delete(bf, ihm));
		ihm.setDeplacerCurseur(new DeplacerCurseur(bf, ihm));
		ihm.setUndo(new Undo(bf, ihm));
		ihm.setRedo(new Redo(bf, ihm));
		ihm.setStopEncrMacro(new StopEnregistrementMacro(bf, ihm));
		ihm.setEnrMacro(new EnregistrerMacro(bf, ihm));
		ihm.setRejouerMacro(new RejouerMacro(bf, ihm));
		
		Editeur edt = new Editeur(ihm);
		ihm.setEditeur(edt);
	}

}
