public class River {
	//attributes
	private String symbol;
	private int location;
	private int str;
	
	//constructors
	public River(String s) {
		this(s, 0);
	}
	
	public River(String s, int l) {
		setSymbol(s);
		setLocation(l);
	}
	
	//setter & getters
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String s) {
		symbol = s;
	}
	
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int l) {
		location = l;
	}
	
	public int getSTR() {
		return str;
	}
	
	public void setSTR(int s) {
		str = s;
	}
}
