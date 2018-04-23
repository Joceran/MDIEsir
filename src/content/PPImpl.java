package content;

public class PPImpl implements PressePapier {
	String pp;
	
	public PPImpl(){
		pp = "";
	}
	
	@Override
	public String ecrire() {
		String res = pp;
		return res;
	}

	@Override
	public void lire(String s) {
		pp = s;
	}
	
}
