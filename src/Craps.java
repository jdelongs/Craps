import java.security.SecureRandom;

/**
 * Created by John on 2016-10-31.
 */
import java.util.Scanner;
public class Craps {

    private enum Status{WON, LOST, CONTINUE}

    public static void main(String[] args)
    {
        Status gameStatus;
        Scanner input = new Scanner(System.in);
        int wallet = 100;
        int bet;



        while (wallet > 0) {
            System.out.printf("You have $%d in your wallet: ", wallet);


            do {
                System.out.print("How much would you like to bet?");
                bet = input.nextInt();
            } while (bet > wallet);

            int sumOfDice = rollTheDice();

            final int SNAKE_EYES = 2;
            final int TREY = 3;
            final int SEVEN = 7;
            final int YO_LEVEN = 11;
            final int BOXCARS = 12;

            switch (sumOfDice)
            {
                //checks for a win
                case SEVEN:
                case YO_LEVEN:
                    gameStatus = Status.WON;
                    break;
                //check for a loss
                case SNAKE_EYES:
                case TREY:
                case BOXCARS:
                    gameStatus = Status.LOST;
                    break;
                default:
                    gameStatus = Status.CONTINUE;

            }//end of switch
            int myPoint = sumOfDice;

            while (gameStatus == Status.CONTINUE)
            {
                sumOfDice = rollTheDice();
                if (sumOfDice == myPoint)
                    gameStatus = Status.WON;
                if (sumOfDice == SEVEN)
                    gameStatus = Status.LOST;
            }//end of while loop

            if (gameStatus == Status.WON)
            {
                System.out.printf("Congrats u won %d: ", bet);
                wallet += bet;

            } else {

                System.out.printf("you lost $%d: ", bet);
                wallet -= bet;
            }

        }//end of while loop
    }//end of main method
    /**
     * this method will simulate rolling 2 dice and return the sum of the 2 dice
     */
    public static int rollTheDice()
    {
        SecureRandom rng = new SecureRandom();
     int dice1 = rng.nextInt(6) + 1;
     int dice2 = rng.nextInt(6) + 1;

        System.out.printf("die 1: %d  die 2: %d %n", dice1, dice2);
        System.out.println(" The Roll is: " + (dice1 + dice2));

        return dice1 + dice2;
    }

}//end of Craps class
