/**
 * This program simulates a rock paper scissors
 * game against a computer, that is only 5 games
 *
 * 10/13/19
 * Section 3 (Andrick Mercado)
 */
import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors {

	public static void main(String[] args) {
		final int ROCK       = 1;
		final int PAPER      = 2;
		final int SCISSORS   = 3;
		final int MAX_ROUNDS = 5;

		Scanner scnr = new Scanner(System.in);
		Random  rand = new Random(341L);

		String  computerMaterial = "";
		String  playerMaterial   = "";
		int     playerChoice     = 1;
		int     thisRound        = 1;
		boolean invalidChoice    = false;

	       System.out.println("Enter: 1 (rock), 2 (paper), 3 (scissors)\n");
	   
	          // TODO:  Write the test condition for looping MAX_ROUNDS times.
		while (thisRound<=MAX_ROUNDS) {

			playerChoice = scnr.nextInt();
			
			// TODO:  Write a switch statement that checks playerChoice
			//        Use the constants as case statements, e.g. case ROCK : ...
			//        for each choice, set playerMaterial to its string equivalent, e.g. playerMaterial = "Rock";
			//
			//        case default should set invalidChoice to true
         
                        switch(playerChoice){
                        case ROCK: playerMaterial = "Rock";break;
                        case PAPER: playerMaterial = "Paper";break;
                        case SCISSORS: playerMaterial = "Scissors";break;
                        default: invalidChoice = true;
                        }

                       // If invalid choice given by user, go back to top of loop and get another choice
			if (invalidChoice) {
				invalidChoice = false;
				continue;
			}
			// Generate computer selection
			int computerChoice = rand.nextInt(3) + 1;
			
			// TODO:  Write a switch statement that checks computerChoice
			//        Use the constants as case statements, e.g. case ROCK : ...
			//        for each choice, set computerMaterial to its string equivalent, e.g. computerMaterial = "Rock";
			//
			//        case default is not needed as the random number can only be 1, 2, or 3.
         
                       switch(computerChoice){
                        case ROCK: computerMaterial = "Rock";break;
                        case PAPER: computerMaterial = "Paper";break;
                        case SCISSORS: computerMaterial = "Scissors";break;
                        }
         
                         // Print choices
			System.out.println("Round " + thisRound + ": computer chose " + computerMaterial
					+ " and you chose " + playerMaterial);

			// Determine winner
			// TODO
			// IF the computerChoice is same as playerChoice print "Tie!"
			// ELSE IF computerChoice is ROCK and playerChoice is SCISSORS or
			//         computerChoice is PAPER and playerChoice is ROCK
			//         computerChoice is SCISSORS and playerChoice is PAPER
			//         print "Computer wins!"
			// ELSE    print "You win!"

                       if(computerChoice==playerChoice)
                       System.out.println("Tie!");
                       else if((computerChoice==ROCK&&playerChoice==SCISSORS)||(computerChoice==PAPER&&playerChoice==ROCK)||(computerChoice==SCISSORS&&playerChoice==PAPER))
                       System.out.println("Computer wins!");
                       else 
                       System.out.println("You win!");
                       
         
                        System.out.println();
			thisRound++;
		}
		System.out.println("Game over!");
	}
}

         