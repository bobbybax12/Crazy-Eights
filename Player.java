/** Player.java
*   Author: Robert Baxter
*   
*   Player class as part of Crazy Eights
*   To be used with Game, Card, Deck classes
*
*/

import java.util.ArrayList;
import java.util.Scanner;

class Player{
    
    public ArrayList<Card> hand; // the player's hand
    private Scanner input; //allows the user input
    public String response; //creates string for the user input


    public Player(){
    input = new Scanner(System.in);
    hand = new ArrayList<Card>(); //creating the players hand arrayList
    }

    // Adds a card to the player's hand
    public void addCard(Card c){
        hand.add(c);
    }
   
    // Covers all the logic regarding a human player's turn
    // public so it may be called by the Game class
    public Card playsTurn(Deck d){
        //prints out the players hand
        System.out.println(handToString());
        response = "draw";
        //will always draw if user asks for draw
        while(response.equals("draw")){
        System.out.println("Type 'draw' to draw a card, or type the number "+
        "next to the card in your hand that you wish to play");
        response = input.next();
        if(response.equals("draw")){
            addCard(d.deal());
            System.out.println(handToString());
        }
        }
            //this takes the card they want to play, removes it, and returns it
            Card temp = hand.get((Integer.parseInt(response))-1);
            hand.remove(temp);
            return temp;
        }
    

    
    // Accessor for the players hand
    public ArrayList<Card> getHand(){
        return hand;
    }
    //Accessor for the players hand size
    public int getHandSize(){
        int size = hand.size();
        return size;
    }


    // Returns a printable string representing the player's hand
    public String handToString(){
        String handOutput = "";
        int count = 1;
        for(Card x : hand){
        handOutput += count+"       "+x.toString()+"\n";
        count++;
        }
    return handOutput;
    }


} // end
