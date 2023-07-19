import java.util.Scanner;

public class GameDriver {
	public static void main(String[] args) {		
		//Create Player
		Scanner input = new Scanner(System.in);
		
		//Game Introduction
		System.out.println("=========================");
		System.out.println("||  A River Board Game ||");
		System.out.println("=========================");
		System.out.println("||      The Rules:     ||");
		System.out.println("== == == == = == == == ==");
		System.out.println("||  Two Players Game   ||");
		System.out.println("||                     ||");
		System.out.println("||  Roll the Dice till ||");
		System.out.println("||  one is at the End  ||");
		System.out.println("||                     ||");
		System.out.println("||   Beware of Traps   ||");
		System.out.println("||     and Current     ||");
		System.out.println("=========================");
		
		System.out.println("Please Enter Your Name for The Record");
		
		//Player 1
		System.out.println("Player 1:");
		String p1 = input.next();
		Player P1 = new Player(p1);
		P1.setSymbol(" <P1> ");
		P1.setLocation(1);
		
		//Player 2
		System.out.println("Player 2:");
		String p2 = input.next();
		Player P2 = new Player(p2);
		P2.setSymbol(" <P2> ");
		P2.setLocation(1);
		
		//Create Board
		Board BRD = new Board(P1, P2);
		System.out.println("This is The Board! Good Luck!");
		
		BRD.displayBoard();
		
		//Initialize Turns/CurrentScore/TrapScore
		P1.setTurns(1);
		P2.setTurns(1);
		int p1CurrentHit = 0;
		int p1TrapHit = 0;
		int p2CurrentHit = 0;
		int p2TrapHit = 0;
		int moveCount = 0;
		
		//Game Part
		while (P1.getLocation() != 100 && P2.getLocation() != 100) {
			
			//Player 1 dice
			System.out.print("\n\n<<" + p1 +"'s TURN:" + P1.getTurns()+">>");
			P1.Move(P1.Dice());
			BRD.SPlayers();
			
			//Player 1 Current/Trap
			while(BRD.getCL().contains(P1.getLocation())
	        		|| BRD.getTL().contains(P1.getLocation()) && moveCount < 1){
				//Player 1 Current
                if(BRD.getCL().contains(P1.getLocation())){
                	int i = 0;
                	
                    while(BRD.getCL().get(i) != P1.getLocation()){
                    	i++;
                    }
                	System.out.println("\n\n<<<Hit the current!>>>");
                	System.out.printf("%s move forward %d steps.\n", p1, BRD.getCS().get(i));
                	p1CurrentHit++;
                	P1.Move(BRD.getCS().get(i));
                	moveCount ++;
                	BRD.SPlayers();
                }
                //Player 1 Trap
                else if (BRD.getTL().contains(P1.getLocation())){
                	int i = 0;
                    while(BRD.getTL().get(i) != P1.getLocation()){
                    	i++;
                    }
                	System.out.println("\n\n<<<Hit the trap!>>>");
                    System.out.printf("%s get knock back for %d steps.\n", p1, BRD.getTS().get(i) );
                    p1TrapHit++;
                    P1.Move(-1 * BRD.getTS().get(i));
                    moveCount ++;
                    BRD.SPlayers();
                }
                else{
                	break;
                }
            }
			moveCount = 0;
			
			//Player 2 dice
			System.out.print("\n\n<<" + p2 +"'s TURN:" + P2.getTurns()+">>");
			P2.Move(P2.Dice());
			BRD.SPlayers();
			//Player 2 Current/Trap
			while(BRD.getCL().contains(P2.getLocation())
	        		|| BRD.getTL().contains(P2.getLocation()) && moveCount < 1){
				//Player 2 Current
                if(BRD.getCL().contains(P2.getLocation())){
                	int i = 0;
                    while(BRD.getCL().get(i) != P2.getLocation()){
                    	i++;
                    }
                	System.out.println("\n\n<<<Hit the current!>>>");
                	System.out.printf("%s move forward %d steps.\n", p2, BRD.getCS().get(i) );
                	p2CurrentHit++;
                	P2.Move(BRD.getCS().get(i));
                	moveCount ++;
                	BRD.SPlayers();
                }
                //Player 2 Trap
                else if (BRD.getTL().contains(P2.getLocation())){
                	int i = 0;
                    while(BRD.getTL().get(i) != P2.getLocation()){
                    	i++;
                    }
                	System.out.println("\n\n<<<Hit the trap!>>>");
                    System.out.printf("%s get knock back for %d steps.\n", p2, BRD.getTS().get(i) );
                    p2TrapHit++;
                    P2.Move(-1 * BRD.getTS().get(i));
                    moveCount ++;
                    BRD.SPlayers();
                }
                else{
                	break;
                }
            }
			moveCount = 0;
			
		}
		//Result
		System.out.println("\n\n<<<Finish!>>>");
		P1.setTurns(P1.getTurns()-1);
		P2.setTurns(P2.getTurns()-1);
		Record record = new Record();
		//Draw
		if(P1.getLocation() == 100 && P2.getLocation() == 100) {
			System.out.println("\nResult : DRAW\n");
			System.out.println(p1 + "'s Score");
			System.out.println("CLEAR TURN:" + P1.getTurns());
			System.out.println("Current Hit:" + p1CurrentHit);
			System.out.println("Trap Hit:" + p1TrapHit);
			System.out.println("");
			System.out.println(p2 + "'s Score");
			System.out.println("CLEAR TURN:" + P2.getTurns());
			System.out.println("Current Hit:" + p2CurrentHit);
			System.out.println("Trap Hit:" + p2TrapHit);
		}
		//P1 Win
		else if(P1.getLocation() == 100 && P2.getLocation() != 100) {
			System.out.println("\nResult : " + p1 + " WIN!!\n");
			//Score
			System.out.println(p1 + "'s Score");
			System.out.println("CLEAR TURN:" + P1.getTurns());
			System.out.println("Current Hit:" + p1CurrentHit);
			System.out.println("Trap Hit:" + p1TrapHit);
			record.updateScoreBoard(P1);
		}
		//P2 Win
		else if(P1.getLocation() != 100 && P2.getLocation() == 100) {
			System.out.println("\nResult : " + p2 + " WIN!!\n");
			//Score
			System.out.println(p2 + "'s Score");
			System.out.println("CLEAR TURN:" + P2.getTurns());
			System.out.println("Current Hit:" + p2CurrentHit);
			System.out.println("Trap Hit:" + p2TrapHit);
			record.updateScoreBoard(P2);
		}
		System.out.println("");
	}
}