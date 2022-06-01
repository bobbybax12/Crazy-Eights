/** Game.java
*   Author: Robert Baxter
*   
*   
*   Game class for playing crazy eights in commandline
*   To be used with Player, Card, Deck classes
*
*/


import java.util.Scanner;
import java.util.ArrayList;

class Game{

    public Card faceup; //stores the faceup card
    private Scanner input; //creates scanner
    private Player p1; //player object
    private ArrayList<Card> compHand; //compHand arraylist for the computer
    private Deck d; //creates the deck that will be used
    private currentSuit;
    
    // sets up the Game object for play
    public Game(){
        input = new Scanner (System.in);
        p1 = new Player();
        d = new Deck();
        d.shuffle();
        //making CompHand
        compHand = new ArrayList<Card>();
        //adding cards to CompHand and player hand
        for(int i = 0;i<7;i++){
            compHand.add(d.deal());
            p1.addCard(d.deal());
        }
        faceup = d.deal(); //deals a card the becomes the faceup
        char currentSuit = faceup.getSuit(); //creates a current suit that will be matched by players
    }

    // Plays a game of crazy eights. 
    // Returns true to continue playing and false to stop playing
    boolean playAgain = true;

    public boolean play(){
        System.out.println("\nWelcome to Crazy Eights! You'll start with 7 "+
        "cards. \nYour job is to match a card in your hand with the up card."+
        "\nYou can match it by suit or rank.\n"+
        "If you play an 8, you can switch "+ 
        "the active suit.\nIf you run out of cards, you win!\nIf you make it "+
        "through the whole deck then whoever has the fewest cards"+
        " left wins!\n----------------------------------------------------\n");
        //checks to make sure that the players hands are >0 and that there is still a top card
       while(d.canDeal()==true&&compHand.size()>0&&p1.getHandSize()>0)
       {
        System.out.println("** The up card is the "+faceup+"**");
        faceup = p1.playsTurn(d);
        //allows user to input the rank for their crazy 8 card
        if(faceup.getNewRank().equals("8")){
            System.out.println("Choose a suit to set! (c,h,d,s)");
            currentSuit = input.next().charAt(0);
        }
        faceup = computerTurn();
        //currentsuit is kept as same suit as the crazy 8
        if(faceup.getNewRank().equals("8")){
            currentSuit = faceup.getSuit();
        }
    }
        //calls the end method if the while loop is not satisfied
        end();
        
        System.out.println("Would you like to play again? Yes or No?");
        String answer = input.nextLine();
        if (answer.equals("Yes")){
            playAgain = true;
        }else{
            System.out.println("Have a nice day!");
            playAgain = false;
        }
        return playAgain;
    }

    /* Naive computer player AI that does one of two actions:
        1) Plays the first card in their hand that is a valid play
        2) If no valid cards, draws until they can play
     */
     //controls all of the computers turn
     private Card computerTurn(){
         //loops through all of their cards to find one that satisifies if statement
        for(Card x : compHand){
            if(x.getNewSuit()==faceup.getNewSuit()||x.getNewRank()==faceup.getNewRank()
            ||faceup.getNewRank().equals("8")){
                faceup = x;
                compHand.remove(x);
                System.out.println("The computer played a "+faceup);
                System.out.println("________________________________________");
                return x;
            }
        }
        // if no card is found, another card is dealt to the hand and method is called again
        //this ensures that it will keep dealing until it finds a card that can be played
        compHand.add(d.deal());
        return computerTurn();
    }
    //this method creates all of the possible scenarios to end the game
    public void end(){
        //compHand size is zero, comp wins
        if(compHand.size()==0){
            System.out.println("The computer has ran out of cards!"+
            "You lost. Better luck next time.");
        }
        //player hand is zero, player wins
        else if((p1.getHand()).size()==0){
            System.out.println("You have no more cards and won! Congrats.");
        }
        //no cards left in the deck
        else if(d.canDeal()==false){
            //comphand larger than player hand, player wins
            if(compHand.size()>p1.getHand().size()){
                System.out.println("The computer has more cards than you! "+
                "You Won. Congrats.");
            }
            else{
            //player larger than comphand, comphand wins
                System.out.println("You had more cards and lost! Sorry.");
            }
        }
    }

}