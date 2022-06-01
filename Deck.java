/** Deck.java
*   Author: Robert Baxter
*   
*   Models a typical deck of playing cards
*   To be used with Card class
*
*/
class Deck{

    private Card[] deck = new Card[52];// contains the cards to play with
    public int top; // controls the "top" of the deck to deal from
    public static final char[] suits = {'c', 'd', 'h', 's'};
    int counter;
    public static final int[] rank = {0,1,2,3,4,5,6,7,8,9,10,11,12};
    public Card faceUp;
    public char currentSuit;
    public String faceUpString;
    // constructs a default Deck
    public Deck(){
        int counter = 0;
        for(int i = 0;i<suits.length;i++){
            for(int j = 0;j<rank.length;j++){
                deck[counter] = new Card(suits[i],rank[j]);
                counter++;
            }
        }
    }

    // Deals the top card off the deck
    public Card deal(){
        top = top+1;
        return deck[top-1];
    }
    //gets face up string (accessor)
    public String getFaceUpString(){
        faceUpString = "The up card is the "+faceUp.getNewRank() + 
        " of " + faceUp.getNewSuit();
        return faceUpString;
    }
    //sets current suit to start game
    public void setCurrentSuit(){
        currentSuit = faceUp.getSuit();
    }
    //returns current suit
    public String getCurrentSuit(){
        String currentSuit = "The current suit is "+faceUp.getNewSuit();
        return currentSuit;
    }

    // returns true provided there is a card left in the deck to deal
    public boolean canDeal(){
        if (top>50){
            return false;
        }
        return true;
    }

    // Shuffles the deck
    public void shuffle(){
        for(int i = 0;i<15000;i++){
            int x = (int) (Math.random()*deck.length);
            int y = (int) (Math.random()*deck.length);
            Card temp = deck[x];
            deck[x]=deck[y];
            deck[y]=temp;
        }
    }

    // Returns a string representation of the whole deck
    public String toString(){
        String deckFull = "";
        for(int i = 0;i<deck.length;i++){
            deckFull+= deck[i] + "\n";
        }
        return deckFull;
    } 
}
