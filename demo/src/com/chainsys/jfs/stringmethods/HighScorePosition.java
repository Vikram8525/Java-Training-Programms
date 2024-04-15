package com.chainsys.jfs.stringmethods;

import java.util.Scanner;

public class HighScorePosition {

	public static void main(String[] args) {
				int a,b,c,d;
				Scanner sc = new Scanner(System.in);
				do {
					System.out.println("enter player a's +ve score for 1nd Players !");
					while (!sc.hasNextInt()) {
						System.out.println("That's not a valid  score!");
						sc.next(); 
					}
					a = sc.nextInt();
				} while (a <= 0);
				System.out.println("Enter Player 2 Score");
				b=sc.nextInt();
				do {
					System.out.println(" enter player b's +ve score for 2nd Players !");
					while (!sc.hasNextInt()) {
						System.out.println("That's not a valid  score!");
						sc.next(); 
					}
					b = sc.nextInt();
				} while (a <= 0);
				System.out.println("Enter Player 3 Score");
				c=sc.nextInt();
				System.out.println("Enter Player 4 Score");
				d=sc.nextInt();
		        displayHighScorePosition("Player1", calculateHighScorePosition(a));
		        displayHighScorePosition("Player2", calculateHighScorePosition(b));
		        displayHighScorePosition("Player3", calculateHighScorePosition(c));
		        displayHighScorePosition("Player4", calculateHighScorePosition(d));
		    }

		    public static void displayHighScorePosition(String playerName, int position) {
		        System.out.println(playerName + " managed to get into position " + position + " on the high score table.");
		    }

		    public static int calculateHighScorePosition(int playerScore) {
		        if (playerScore >= 1000) {
		            return 1;
		        } else if (playerScore >= 500 && playerScore < 1000) {
		            return 2;
		        } else if (playerScore >= 100 && playerScore < 500) {
		            return 3;
		        } else {
		            return 4;
		        }

	}

}
