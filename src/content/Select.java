package content;

public class Select implements Selection{

	private Buffer bf;
	private int debut;
	private int fin;
	
	public Select(Buffer bf) {
		this.bf = bf;
		debut = 0;
		fin = 0;
	}

	@Override
	public void selDeb(int d) {
		debut = d;
	}

	@Override
	public void selFin(int f) {
		fin = f;
	}
	
	public String getSelection(){
		String res = "";
		for(int i = debut; i < fin; i++){
			res += bf.getChar(i);
		}
		return res;
	}

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}
	

}
