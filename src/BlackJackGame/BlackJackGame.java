package BlackJackGame;

import java.util.Arrays;
import java.util.Random;
/**
 * Created by leo on 17/4/5.
 */
public class BlackJackGame {

    public int[] playercard = {-1,-1,-1,-1,-1};
    public int[] dealercard = {-1,-1,-1,-1,-1};
    public int numberofplayercard = 2;
    public int numberofdealercard = 2;

    public void GameStart() //Send to two initial cards to the user and dealer
    {
        Random ran = new Random();
        int number;

        for(int count = 0 ; count < 4; count++)
        {

            Boolean Alreaydeal = false;
            //need conditions before giving the card to player and dealer in case of duplicating cards
            while(!Alreaydeal)
            {
                number = ran.nextInt(52);//number from 0-51 of the cards
                if(!compare(playercard,number) && !compare(dealercard,number))
                {
                    if (count % 2 == 0)
                        {playercard[count / 2] = number;}
                    else if (count % 2 == 1)
                        {dealercard[count / 2] = number;}

                    Alreaydeal = true; //one number is set. Then go back to the For loop and start next loop
                }
            }
        }

        System.out.println("Your initial two cards are: " + transfer(playercard[0]) + " and " + transfer(playercard[1]));
    }

    public static boolean compare(int[] arr, int targetValue) // check the array if contains the target value
    {
        boolean outcome = false;

        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] == targetValue)
                outcome = true;
        }

        return outcome;
    }

    public void playeraskforcard() //player asks for another card and show the player's cards
    {
        Random ran1 = new Random();
        Boolean Send = false;
        while(!Send) //choose a card which is not sent yet
        {
            int number1 = ran1.nextInt(52);
            if (!compare(playercard, number1) && !compare(dealercard, number1)) {
                playercard[numberofplayercard] = number1;
                Send = true;
                numberofplayercard++;
            }

            //show the holding cards
            for (int count2 = 0; count2 < numberofplayercard; count2++) {
                System.out.print(transfer(playercard[count2]) + " ");
            }
            System.out.println("");
        }
    }

    public void dealeraskforcard()
    {
        Random ran2 = new Random();
        Boolean Send1 = false;
        while(!Send1)
        {
            int number = ran2.nextInt(52);
            if (!compare(playercard, number) && !compare(dealercard, number)) {
                dealercard[numberofdealercard] = number;
                Send1 = true;
                numberofdealercard++;
            }
        }
    }


    public void showcard() // show the cards of the player
    {
        System.out.print("Player's total points: ");
        System.out.println(getpointofplayer());
        System.out.print("Player cards: ");
        for (int count3 = 0; count3 < numberofplayercard; count3++)
        {
            System.out.print(transfer(playercard[count3])+" ");
        }

        System.out.println("");

        System.out.print("Dealer's total points: ");
        System.out.println(getpointofdealer());
        System.out.print("Dealer cards: ");
        for (int count3 = 0; count3 < numberofdealercard; count3++)
        {
            System.out.print(transfer(dealercard[count3])+" ");
        }

        System.out.println("");
        System.out.println("");

    }



    public int getpointofplayer() //calculate the total points of the player
    {
        int sum = 0;

        for(int count3 = 0; count3<numberofplayercard; count3++){
            int number = 1 + (playercard[count3] % 13) ;
            if (number>9)
                sum += 10;
            else
                sum += number;
        }

        if (compare(playercard,0) || compare(playercard,13) || compare(playercard,26) || compare(playercard,39))

        {
            if (sum + 10 <= 21)
             sum = sum + 10;

        }
        return sum;
    }

    public int getpointofdealer()
    {
        int sum1 = 0;

        for(int count4 = 0; count4<numberofdealercard; count4++)
        {
            int number1 = 1 + (dealercard[count4] % 13) ;
            if (number1>9)
                sum1 += 10;
            else
                sum1 += number1;
        }

        if (compare(dealercard,0) || compare(dealercard,13) || compare(dealercard,26) || compare(dealercard,39))
        {
            if (sum1 + 10 <= 21)
            { sum1 = sum1 + 10; }

        }
        return sum1;
    }

    public int Whowinthegame()
    {
        if(getpointofdealer() > getpointofplayer())
            return 0;
        else if (getpointofplayer() > getpointofdealer())
            return 1;
        else
            return 2;

    }

    public String transfer(int numberofcard) //transfer the number of card into real poker
    {
        int remain = numberofcard % 13; //the number of card
        int suit = numberofcard /13; // the suit of card
        String card = "a"; // the information of card

        if (suit == 0) //suit = 0 which means the cards are Spade.
        {
            if(remain<1)
                card = "Spades"+"A";

            else if(remain>=1 && remain<10)
                card = "Spades"+(1+remain);

            else if(remain>=10 && remain<11)
                card = "Spades"+"J";

            else if(remain==11)
                card = "Spades"+"Q";

            else if(remain==12)
                card = "Spades"+"K";
        }

        else if (suit == 1)
        {
            if(remain<1)
                card = "Heart"+"A";

            else if(remain>=1 && remain<10)
                card = "Heart"+(1+remain);

            else if(remain>=10 && remain<11)
                card = "Heart"+"J";

            else if(remain==11)
                card = "Heart"+"Q";

            else if(remain==12)
                card = "Heart"+"K";
        }

        else if (suit == 2)
        {
            if(remain<1)
                card = "Clubs"+"A";

            else if(remain>=1 && remain<10)
                card = "Clubs"+(1+remain);

            else if(remain>=10 && remain<11)
                card = "Clubs"+"J";

            else if(remain==11)
                card = "Clubs"+"Q";

            else if(remain==12)
                card = "Clubs"+"K";
        }

        else if (suit == 3)
        {
            if(remain<1)
                card = "Diamond"+"A";

            else if(remain>=1 && remain<10)
                card = "Diamond"+(1+remain);

            else if(remain>=10 && remain<11)
                card = "Diamond"+"J";

            else if(remain==11)
                card = "Diamond"+"Q";

            else if(remain==12)
                card = "Diamond"+"K";
        }
        return card;
    }
}