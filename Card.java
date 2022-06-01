
    /** Card.java
*   Author: Robert Baxter
*   
*   
*   Models a typical playing card
*
*/

class Card{
    
    private char suit;
    private int rank;

    // Initializes a card instance
    public Card(char suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    // Accessor for suit
    public char getSuit(){
        return suit;
    }
    
    // Accessor for rank
    public int getRank(){
        return rank;
    }

    public String getNewRank(){
        switch(rank){
            case 0 : return "Ace";
            case 1 : return "2";
            case 2 : return "3";
            case 3 : return "4";
            case 4 : return "5";
            case 5 : return "6";
            case 6 : return "7";
            case 7 : return "8";
            case 8 : return "9";
            case 9 : return "10";
            case 10 : return "Jack";
            case 11 : return "Queen";
            case 12 : return "King";
        }
        return null;
    }
    public String getNewSuit(){
        switch(suit){
            case 'h' : return "Hearts";
            case 's' : return "Spades";
            case 'd' : return "Diamonds";
            case 'c' : return "Clubs";
        }
        return null;
    }
        // Returns a human readable form of the card (eg. King of Diamonds)
        public String toString(){
            
        String desc = getNewRank() + " of " + getNewSuit();
        return desc;
    }
}

