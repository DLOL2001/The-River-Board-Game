import java.util.Random;
import java.util.Scanner;

public class Player{
	// attribute
	private String symbol;
	private String name;
	private int turns;
	private int location;
	
	// constructor
	public Player() {
		
	}
	
	public Player(String n) {
		setName(n);
		setTurns(0);
		location = 1;		
	}
	
	// getter and setter
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String s) {
		symbol = s;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public int getLocation() {
		return location;
	}
	
	public void setLocation(int l) {
		location = l;
	}
	
	//methods
	//Calculate Location
	public int Move(int steps) {
		//Calculate how many steps player needs to move back if Location + Steps > 100
		if (steps > (100 - location)) {
			int place;
			place = location + steps;
			location = 100 - (place % 100);
		}
		else if ((location + steps) < 1) {
			location = 1;
		}
		else {
			location = location + steps;
		}
		if (steps != 0) {
			System.out.printf("%s is now at position %d\n", name, location);
			System.out.println();
		}
		return location;
	}
	
	//Roll the Dice & Calculate the Steps
	public int Dice() {
		Scanner input = new Scanner(System.in);
		System.out.printf("\n%s's turn !\n", name);
		System.out.print("Press Enter to roll the dice !!");
		input.nextLine();
		System.out.println();
		Random r = new Random();
		int dice1 = 1 + r.nextInt(6);
		int dice2 = 1 + r.nextInt(6);
		int total = dice1 + dice2;
		System.out.printf("%s rolled: " + dice1 + " and " + dice2 + ". Total is: " + total + "\n", name);
		turns++;
		return total;
	}
	
	
	//toString
	public String toString() {
		return String.format("%s           %d", name, turns);
	}
}
