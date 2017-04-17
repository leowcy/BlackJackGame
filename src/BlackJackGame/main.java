package BlackJackGame;

import java.util.Scanner;

/**
 * Created by leo on 17/4/5.
 */
public class main {

    public static void main(String[] args)
    {
        System.out.println("Welcome to Leo's Casino of Blackjack! How much do you want to buy in the Casino?");

        Scanner in3 = new Scanner(System.in);
        int money = in3.nextInt();
        System.out.println("Thanks for buying in. Enjoy you game. Your total money is: " + money+ " dollars.");

        int choose = 1;
        while(choose == 1) //choose 1 and the game will continue
        {
            BlackJackGame bj = new BlackJackGame(); //Initialization can only be set in the while loop
            System.out.println("1. Start the 21points Game 2. Exit.");
            Scanner in1 = new Scanner(System.in);
            choose = in1.nextInt();
            //start the 21 game
            if (choose == 1) {
                System.out.println("How much do you want to bet in this game?");
                Scanner in = new Scanner(System.in); //read input
                int moneyofthisgame = in.nextInt(); //the money the player bet in this game
                System.out.println("The Blackjack game started! You bet " + moneyofthisgame + "$! Good luck!");
                bj.GameStart(); //Game start and send two cards to the player and dealer//


               // int choose1 = 1; //choose1 is set to give the choice for player asking card or not
                System.out.println("1.Call for a card 2.Stop asking for card");
                Scanner in2 = new Scanner(System.in);
                int choose1 = in2.nextInt();
                int flag = 0;

                if(choose1 == 1)
                {
                    while (choose1 == 1 && bj.getpointofplayer() <= 21) //keep asking the player whether
                    // he asks for card anymore
                    {
                        if (flag > 0) {
                            System.out.println("1.Call for a card 2.Stop asking for card");

                            Scanner in4 = new Scanner(System.in);
                            choose1 = in4.nextInt();
                        }
                        if (choose1 == 1) {
                            bj.playeraskforcard(); //ask for another card and show the holding cards
                        }

                        if (bj.getpointofplayer() > 21) {
                            money = money - moneyofthisgame;

                            System.out.println("Bust! Dealer Win. You lose " + moneyofthisgame + " dollars. Now your " +
                                    "remaining is: " + money + " dollars.");



                            bj.showcard();
                        }

                        flag++;
                    }
                }

                if(choose1 == 2)// When the player chose 2, it meant that the player didn't bust
                                // and he wanted to compare with the dealer
                {

                    while (bj.getpointofdealer() < 17) {
                        bj.dealeraskforcard();
                    }

                    if (bj.getpointofdealer() > 21)
                    {
                        money = money + moneyofthisgame;
                        System.out.println("Dealer bust! Player win. You win " + moneyofthisgame + " dollars. Now your" +
                                " remaining is: " + money+ " dollars.");
                        bj.showcard();
                    }
                    else
                    {
                        if (bj.Whowinthegame() == 0)
                        {
                            money = money - moneyofthisgame;
                            System.out.println("Dealer Win. You lose " + moneyofthisgame + " dollars. Now your " +
                                    "remaining is: " + money+ " dollars.");
                            bj.showcard();
                        }
                        else if (bj.Whowinthegame() == 1)
                        {
                            money = money + moneyofthisgame;
                            System.out.println("Player win. You win " + moneyofthisgame + " dollars. Now your" +
                                    " remaining is: " + money+ " dollars.");
                            bj.showcard();
                        }
                        else if (bj.Whowinthegame() == 2)
                        {
                            System.out.println("Tie game. Your remaining is: " + money + " dollars.");
                            bj.showcard();
                        }
                    }

                }



            }
            else if (choose == 2) {} //exit the game
            else {System.out.println("Input error");}
        }
    }
}
