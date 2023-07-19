import java.util.Random;

public class Current extends River{
	Random r = new Random();
	private int currentStrength = 1 + r.nextInt(5);
	private int currentLocation = 2 + r.nextInt(97);
	
	//constructor - create Current when called
	public Current() {
		//Current's Symbol
		super("| CR |");
		//Current's Strength
		super.setSTR(getCurrentStrength());
		//Current's Location
		setLocation(getCurrentLocation());		
	}
	
	public int getCurrentStrength(){
		return currentStrength;
	}
	
	public int getCurrentLocation(){
		return currentLocation;
	}
}

