import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public class Record {
	// attribute
	private Scanner ainput;
	private Formatter aoutput;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	// display record
	public void displayRecord() {
		System.out.println(" =======Record=======");
		System.out.println("NAME           TURNS");
		readRecordFile("Record.txt");
		System.out.println();
	}
	
	// update record
	public void updateScoreBoard(Player p) {
		checkWinner(p);
		writeRecordFile("Record.txt");
		displayRecord();
	}
	
	// read record from the file
	public void readRecordFile(String fileName) {
		try {
			ainput = new Scanner(new File(fileName));
			
			while(ainput.hasNext()) {
				Player p = new Player();
				p.setName(ainput.next());
				p.setTurns(ainput.nextInt());
				
				players.add(p);
				System.out.println(p);
			}
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("Record Not Found");
		}
		if (ainput != null) {
			ainput.close();
		}
	}
	
	// write record to the file
	public void writeRecordFile(String fileName) {
		try {
			aoutput = new Formatter(new File(fileName));
			
			for(int i = 0; i < players.size(); i++) {
				aoutput.format("%s\t\t\t%d\n", players.get(i).getName(), players.get(i).getTurns());
			}
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("Error open file");
		}
		if (aoutput != null) {
			aoutput.close();
		}
	}
	
	// check if the player is on record
	public void checkWinner(Player p) {
		players.add(p);
		for(int i = 0; i < players.size(); i++) {
			for (int j = i + 1; j < players.size(); j++) {
				if (players.get(i).getTurns() > players.get(j).getTurns()) {
					Collections.swap(players, i, j);
				}
			}
		}
		if (players.size() > 5) {
			players.remove(5);
		}
	}
}
