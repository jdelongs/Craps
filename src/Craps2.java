

import java.security.SecureRandom;//in// ports random number
import java.util.Scanner;

/**
 *
 * @author jwright
 */
public class Craps2 {

    private enum Status {WON, LOST, CONTINUE};//the 3 states of the game

    public static void main(String[] args)//start of program
    {
        Status gameStatus;//
        Scanner keyboard = new Scanner(System.in);
        int wallet = 100;
        int bet;

        while (wallet > 0)//while my wallet is greater than 0 print out you have how ever much in your wallet
        {
            System.out.printf("You have $%d in your wallet, ", wallet);

            do{
                System.out.print(" how much would you like to bet?");//only do this while bet is greater than wallet wallet
                bet = keyboard.nextInt();
            } while (bet > wallet);//still in a whle loop

            int sumOfDice = rollTheDice();//the sum of the dice = whatever dice one and two are rolled as

            final int SNAKE_EYES = 2;//int that never changes
            final int TREY = 3;
            final int SEVEN = 7;
            final int YO_LEVEN = 11;
            final int BOXCARS = 12;

            switch (sumOfDice)//the sum of the dice
            {
                //check for a win
                case SEVEN: //if 7 or ll then the gameStatus is equal to WON
                case YO_LEVEN:
                    gameStatus = Status.WON;
                    break;

                //check for a loss
                case SNAKE_EYES:// if Snake eyes or trey then gameStatus is equal to loss
                case TREY:
                case BOXCARS:
                    gameStatus = Status.LOST;
                    break;

                default:
                    gameStatus = Status.CONTINUE;// ese game status is equal to Continue

            }  // end of the switch

            int myPoint = sumOfDice; //my point is equal to sum of dice which is equal to the roll of the dice

            while (gameStatus == Status.CONTINUE)//while still in the orgiginal while loop so if gameStatus is actually equals the status continue
            {
                sumOfDice = rollTheDice();//
                if (sumOfDice == myPoint)
                    gameStatus = Status.WON;
                if (sumOfDice == SEVEN)
                    gameStatus = Status.LOST;
            }    //end of while loop

            if (gameStatus == Status.WON)
            {
                System.out.printf("Congratulations you win $%d ", bet);
                wallet += bet;
            }
            else
            {
                System.out.printf("Sorry, you have lost $%d ", bet);
                wallet -= bet;
            }
        }  //end of while loop

    }  //end of the main method

    /**
     * This method will simulate rolling 2 dice and return
     * the sum of the 2 dice
     */
    public static int rollTheDice()
    {
        SecureRandom rng = new SecureRandom();
        int die1 = rng.nextInt(6) + 1;
        int die2 = rng.nextInt(6) + 1;

        System.out.printf("die 1: %d    die 2: %d %n", die1, die2);
        return die1 + die2;
    }
}
