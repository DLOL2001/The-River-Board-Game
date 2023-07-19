import java.util.Random;

public class Trap extends River{
	Random r = new Random();
	private int trapStrength = 1 + r.nextInt(5);
	private int trapLocation = 2 + r.nextInt(97);
	
	//constructor - create Trap when called
	public Trap() {
		//Current's Symbol
		super("| TR |");
		//Trap's Strength
		super.setSTR(getTrapStrength());
		//Trap's Location
		setLocation(getTrapLocation());
	}	
	
	public int getTrapStrength(){
		return trapStrength;
	}
	
	public int getTrapLocation(){
		return trapLocation;
	}
}
