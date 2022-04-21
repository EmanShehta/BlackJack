/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author max
 */
public class Card {
    
    private int value;
     private int suit;
     private int rank;
      Boolean exist = true;
      Boolean exst = true;

    public Card(int suit, int rank, int value) {
        
        this.suit = suit;
        
        this.rank = rank;
        this.value=value;
    }


public Card ( Card C){
    this.rank=C.rank;
    this.suit=C.suit;
    this.value=C.value;
    this.exist=C.exist;
}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
