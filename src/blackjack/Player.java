/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
public class Player {
    int index=0;
    private String Name;
      private int Score;
       Boolean  BUSTED=false;
              Boolean  BLACKJACK=false;

      Card c[] = new Card[11];  
       void push (Card card)
       {
           c[index++]=card;
       }
       
       Player (String name)
       {
           this .Name=name;
       }
      
    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

   
}
