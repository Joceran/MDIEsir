package IHM;

import commands.Coller;
import commands.Command;
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

public class IHM {
	
	private Editeur editeur;
	
	private Copier copier;
	private Coller coller;
	private Couper couper;
	private Inserer inserer;
	private Selectionner selectionner;
	private Delete delete;
	private DeplacerCurseur deplacerCurseur;
	private Undo undo;
	private Redo redo;
	private EnregistrerMacro enrMacro;
	private StopEnregistrementMacro stopEncrMacro;
	private RejouerMacro rejouerMacro;
	
	private String texteAInserer;
	
	public void setEditeur(Editeur edt){
		this.editeur = edt;
	}
	
	void setCommandCouper(Command cmd){
		this.couper = (Couper) cmd;
	}
	
	void setCommandCopier(Command cmd){
		this.copier = (Copier) cmd;
	}
	
	void setCommandColler(Command cmd){
		this.coller = (Coller) cmd;
	}
	
	void setCommandInserer(Command cmd){
		this.inserer = (Inserer) cmd;
	}
	
	void setCommandSelectionner(Selectionner select){
		this.selectionner = select;
	}
	
	void setDelete(Delete delete){
		this.delete = delete;
	}
	
	void setDeplacerCurseur(Command cmd) {
		this.deplacerCurseur = (DeplacerCurseur) cmd;
	}
	
	public void setTexteAInserer(String s) {
		this.texteAInserer = s;
	}
	
	public void setUndo(Undo undo) {
		this.undo = undo;
	}
	
	public void setRedo(Redo redo) {
		this.redo =  redo;
	}

	public void getSelectionner(){
		setDebut(editeur.gettA().getSelectionStart());
		setFin(editeur.gettA().getSelectionEnd());
		selectionner.execute();
	}
	
	public void getCopier(){
		copier.execute();
	}
	
	public void getColler(){
		coller.execute();
	}
	
	public void getCouper(){
		couper.execute();
	}
	
	public void getInserer(){
		inserer.execute();
	}
	
	public String getTexteAInserer() {
		return this.texteAInserer;
	}
	
	public void getDelete(){
		delete.execute();
	}
	
	public void getDeplacerCurseur() {
		deplacerCurseur.execute();
	}
	
	public void getUndo() {
		undo.execute();
	}
	
	public void getRedo() {
		redo.execute();
	}
	
	public void setDebut(int d){
		this.selectionner.setDebut(d);
	}
	
	public void setFin(int f){
		this.selectionner.setFin(f);
	}
	
	public int getDebut(){
		return this.selectionner.getDebut();
	}
	
	public int getFin(){
		return this.selectionner.getFin();
	}
	
	public void setTexte(String s){
		editeur.gettA().setText(s);
	}
	
	public int getCurseurPosition() {
		return editeur.gettA().getSelectionStart();
	}
	
	public void setCurseurPosition(int pos) {
		editeur.gettA().setCaretPosition(pos);
	}

	public void getEnrMacro() {
		enrMacro.execute();;
	}

	public void setEnrMacro(EnregistrerMacro enrMacro) {
		this.enrMacro = enrMacro;
	}

	public void getStopEncrMacro() {
		stopEncrMacro.execute(); ;
	}

	public void setStopEncrMacro(StopEnregistrementMacro stopEncrMacro) {
		this.stopEncrMacro = stopEncrMacro;
	}

	public void getRejouerMacro() {
		rejouerMacro.execute();
	}

	public void setRejouerMacro(RejouerMacro rejouerMacro) {
		this.rejouerMacro = rejouerMacro;
	}
}
