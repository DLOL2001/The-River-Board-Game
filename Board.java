import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Board {
	//attributes
	private ArrayList<River> R = new ArrayList<River>();
	private ArrayList<Integer> CS = new ArrayList<Integer>();
	private ArrayList<Integer> CL = new ArrayList<Integer>();
	
	private ArrayList<Integer> TS = new ArrayList<Integer>();
	private ArrayList<Integer> TL = new ArrayList<Integer>();

	private ArrayList<Player> P = new ArrayList<Player>();

	//constructor
	public Board(Player p1, Player p2) {
		//create Traps and Currents
		Random r = new Random();
		int C = 2 + r.nextInt(10);
		int T = 2 + r.nextInt(10);
		
		//add them to the River
		for (int i = 0; i < C; i++) {
			Current current = new Current();
			if(CL.contains(current.getCurrentLocation()))
					break;
			else{
				R.add(current);
				CS.add(current.getCurrentStrength());
				CL.add(current.getCurrentLocation());
			}
		}
		
		for (int i = 0; i < T; i++) {
			Trap trap = new Trap();
			if(TL.contains(trap.getTrapLocation()) || CL.contains(trap.getTrapLocation()))
				break;
		else{
			R.add(trap);
			TS.add(trap.getTrapStrength());
			TL.add(trap.getTrapLocation());
			}
		}
		
		River B = new River("| SP |", 1);
		R.add(B);
		
		River F = new River("| FP |", 100);
		R.add(F);
		
		P.add(p1);
		P.add(p2);
	}
	
	//getters and setters
	public ArrayList<Integer> getCS(){
		return CS;
	}
	public ArrayList<Integer> getCL(){
		return CL;
	}
	
	public ArrayList<Integer> getTS(){
		return TS;
	}
	public ArrayList<Integer> getTL(){
		return TL;
	}
	
	//methods
	//Display the whole Board
	public void displayBoard() {
		DRow1A();
		DRow1B();
		DRow2();
		DRow3();
		DRow4();
		DRow5();
		System.out.print("\n");
	}
	
		//Show current Players' Location
		public void SPlayers() {
			int L1 = P.get(0).getLocation();
			int L2 = P.get(1).getLocation();
			
			if (L1 >= 1 && L1 <= 20 && L2 >= 1 && L2 <= 20) {
				SPlayersR1();
				DRow1A();
				DRow1B();
				for (int i = 0; i < 20; i++) {
					System.out.print(" ==== ");
				}
			}
			
			else if (L1 >= 21 && L1 <= 40 && L2 >= 21 && L2 <= 40) {
				SPlayersR2();
				DRow2();
				for (int i = 0; i < 20; i++) {
					System.out.print(" ==== ");
				}
			}
			
			else if (L1 >= 41 && L1 <= 60 && L2 >= 41 && L2 <= 60) {
				SPlayersR3();
				DRow3();
				for (int i = 0; i < 20; i++) {
					System.out.print(" ==== ");
				}
			}
			
			else if (L1 >= 61 && L1 <= 80 && L2 >= 61 && L2 <= 80) {
				SPlayersR4();
				DRow4();
				for (int i = 0; i < 20; i++) {
					System.out.print(" ==== ");
				}
			}
			
			else if (L1 >= 81 && L1 <= 100 && L2 >= 81 && L2 <= 100) {
				SPlayersR5();
				DRow5();
			}

			else {
				SPlayersR();
			}
			
		}
		
		public void SPlayersR() {
			for (int idx = 0; idx < 2; idx++) {
				int L = P.get(idx).getLocation();
				if (L >= 1 && L <= 20) {
					SPlayersR1();
					DRow1A();
					DRow1B();
					for (int i = 0; i < 20; i++) {
						System.out.print(" ==== ");
					}
					System.out.print("\n");
				}
				
				else if (L >= 21 && L <= 40) {
					SPlayersR2();
					DRow2();
					for (int i = 0; i < 20; i++) {
						System.out.print(" ==== ");
					}
					System.out.print("\n");
				}
				
				else if (L >= 41 && L <= 60) {
					SPlayersR3();
					DRow3();
					for (int i = 0; i < 20; i++) {
						System.out.print(" ==== ");
					}
					System.out.print("\n");
				}
				
				else if (L >= 61 && L <= 80) {
					SPlayersR4();
					DRow4();
					for (int i = 0; i < 20; i++) {
						System.out.print(" ==== ");
					}
					System.out.print("\n");
				}
				
				else if (L >= 81 && L <= 100) {
					SPlayersR5();
					DRow5();
					System.out.print("\n");
				}
			}
		}
	
	//Everything First Row
	public void DRow1A() {
		for (int i = 1; i <= 20; i++) {
			System.out.print(" ==== ");
		}
		System.out.print("\n");
		for (int i = 1; i <= 9; i++) {
			boolean isObject = false;
			for (River r: R) {
				if (r.getLocation() == i) {
					isObject = true;
					System.out.print(r.getSymbol());
				}
			}
			if (!isObject) {
				System.out.print("| 0" + i + " |");
			}
		}
	}
	
	public void DRow1B() {
		for (int i = 10; i <= 20; i++) {
			boolean isObject = false;
			for (River r: R) {
				if (r.getLocation() == i) {
					isObject = true;
					System.out.print(r.getSymbol());
				}
			}
			if (!isObject) {
				System.out.print("| " + i + " |");
			}
		}
		System.out.print("\n");
	}
	
	public void SPlayersR1() {
		if (P.get(0).getLocation() == P.get(1).getLocation()) {
			sameLocationR1();
		}
		else {
			for (int i = 1; i <= 20; i++) {
				boolean isObject = false;
				for (Player p: P) {
					if (p.getLocation() == i) {
						isObject = true;
						System.out.print(p.getSymbol());
					}
				}
				if (!isObject) {
					System.out.print("      ");
				}
			}
		}
		System.out.print("\n");
	}
	
	public void sameLocationR1() {
		for (int i = 1; i <= 20; i++) {
			boolean isObject = false;
			if (P.get(0).getLocation() == i) {
				isObject = true;
				System.out.print("<P1&2>");
			}
			if (!isObject) {
				System.out.print("      ");
			}
		}
	}
	
	//Everything Second Row
	public void DRow2() {
		for (int i = 21; i <= 40; i++) {
			System.out.print(" ==== ");
		}
		System.out.print("\n");
		for (int i = 21; i <= 40; i++) {
			boolean isObject = false;
			for (River r: R) {
				if (r.getLocation() == i) {
					isObject = true;
					System.out.print(r.getSymbol());
				}
			}
			if (!isObject) {
				System.out.print("| " + i + " |");
			}
		}
		System.out.print("\n");
	}
	
	public void SPlayersR2() {
		if (P.get(0).getLocation() == P.get(1).getLocation()) {
			sameLocationR2();
		}
		else {
			for (int i = 21; i <= 40; i++) {
				boolean isObject = false;
				for (Player p: P) {
					if (p.getLocation() == i) {
						isObject = true;
						System.out.print(p.getSymbol());
					}
				}
				if (!isObject) {
					System.out.print("      ");
				}
			}
		}
		System.out.print("\n");
	}
	
	public void sameLocationR2() {
		for (int i = 21; i <= 40; i++) {
			boolean isObject = false;
			if (P.get(0).getLocation() == i) {
				isObject = true;
				System.out.print("<P1&2>");
			}
			if (!isObject) {
				System.out.print("      ");
			}
		}
	}
	
	//Everything Third Row
	public void DRow3() {
		for (int i = 41; i <= 60; i++) {
			System.out.print(" ==== ");
		}
		System.out.print("\n");
		for (int i = 41; i <= 60; i++) {
			boolean isObject = false;
			for (River r: R) {
				if (r.getLocation() == i) {
					isObject = true;
					System.out.print(r.getSymbol());
				}
			}
			if (!isObject) {
				System.out.print("| " + i + " |");
			}
		}
		System.out.print("\n");
	}
	
	public void SPlayersR3() {
		if (P.get(0).getLocation() == P.get(1).getLocation()) {
			sameLocationR3();
		}
		else {
			for (int i = 41; i <= 60; i++) {
				boolean isObject = false;
				for (Player p: P) {
					if (p.getLocation() == i) {
						isObject = true;
						System.out.print(p.getSymbol());
					}
				}
				if (!isObject) {
					System.out.print("      ");
				}
			}
		}
		System.out.print("\n");
	}
	
	public void sameLocationR3() {
		for (int i = 41; i <= 60; i++) {
			boolean isObject = false;
			if (P.get(0).getLocation() == i) {
				isObject = true;
				System.out.print("<P1&2>");
			}
			if (!isObject) {
				System.out.print("      ");
			}
		}
	}
	
	//Everything Fourth Row
	public void DRow4() {
		for (int i = 61; i <= 80; i++) {
			System.out.print(" ==== ");
		}
		System.out.print("\n");
		for (int i = 61; i <= 80; i++) {
			boolean isObject = false;
			for (River r: R) {
				if (r.getLocation() == i) {
					isObject = true;
					System.out.print(r.getSymbol());
				}
			}
			if (!isObject) {
				System.out.print("| " + i + " |");
			}
		}
		System.out.print("\n");
	}
	
	public void SPlayersR4() {
		if (P.get(0).getLocation() == P.get(1).getLocation()) {
			sameLocationR4();
		}
		else {
			for (int i = 61; i <= 80; i++) {
				boolean isObject = false;
				for (Player p: P) {
					if (p.getLocation() == i) {
						isObject = true;
						System.out.print(p.getSymbol());
					}
				}
				if (!isObject) {
					System.out.print("      ");
				}
			}
		}
		System.out.print("\n");
	}
	
	public void sameLocationR4() {
		for (int i = 61; i <= 80; i++) {
			boolean isObject = false;
			if (P.get(0).getLocation() == i) {
				isObject = true;
				System.out.print("<P1&2>");
			}
			if (!isObject) {
				System.out.print("      ");
			}
		}
	}
	
	//Everything Fifth Row
	public void DRow5() {
		for (int i = 81; i <= 100; i++) {
			System.out.print(" ==== ");
		}
		System.out.print("\n");
		for (int i = 81; i <= 100; i++) {
			boolean isObject = false;
			for (River r: R) {
				if (r.getLocation() == i) {
					isObject = true;
					System.out.print(r.getSymbol());
				}
			}
			if (!isObject) {
				System.out.print("| " + i + " |");
			}					 
		}
		System.out.print("\n");
		for (int i = 0; i < 20; i++) {
			System.out.print(" ==== ");
		}
	}	

	public void SPlayersR5() {
		if (P.get(0).getLocation() == P.get(1).getLocation()) {
			sameLocationR5();
		}
		else {
			for (int i = 81; i <= 100; i++) {
				boolean isObject = false;
				for (Player p: P) {
					if (p.getLocation() == i) {
						isObject = true;
						System.out.print(p.getSymbol());
					}
				}
				if (!isObject) {
					System.out.print("      ");
				}
			}
		}
		System.out.print("\n");
	}

	public void sameLocationR5() {
		for (int i = 81; i <= 100; i++) {
			boolean isObject = false;
			if (P.get(0).getLocation() == i) {
				isObject = true;
				System.out.print("<P1&2>");
			}
			if (!isObject) {
				System.out.print("      ");
			}
		}
	}
}

