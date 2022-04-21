/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author max
 */
public class Game {

    Scanner s = new Scanner(System.in);
    Player p[] = new Player[4];

    int High_Score = 0;

    Card[] Cards = new Card[52];

    void Generate() {
        int idx = 0;

        for (int suit = 0; suit < 4; ++suit) {
            for (int rank = 0; rank < 13; ++rank) {
                int value = rank + 1;
                if (value > 10) {
                    value = 10;
                }
                Card cards = new Card(suit, rank, value);
                Cards[idx++] = cards;

            }
        }
        /*   for (int Value = 1; Value <= 10; Value++) {
            for (int Suit = 0; Suit <= 3; Suit++) {
                Card cards = new Card(Suit, Value - 1, Value );
                Cards[idx++] = cards;} }
        int Value = 10;
        for (int rank = 0; rank <= 2; rank++) {
            for (int Suit = 0; Suit <= 3; Suit++) {
                Card cards = new Card(Suit,Value + rank,Value);
                Cards[idx++] = cards; }}*/
 /*   for(int i=0;i<idx;i++){
            System.out.print(Cards[i].getSuit());
                        System.out.print(Cards[i].getRank());
            System.out.println(Cards[i].getValue());}*/
    }

    void set_information() {
        String name1;
        for (int i = 0; i <= 3; i++) {
            if (i <= 2) {
                System.out.println("Enter Name of Player " + (i + 1));
                name1 = s.next();

                System.out.println("--------------------------------------------------------");
            } else {
                System.out.println("Enter Name of  Dealer :    ");
                name1 = s.next();

                System.out.println("--------------------------------------------------------");

            }

            Player player = new Player(name1);
            p[i] = player;

        }
        for (int i = 0; i <= 3; i++) {
            int idx1 = 0;
            int idx2 = 0;
            Random rand = new Random();
            while (true) {
                idx1 = rand.nextInt(52);
                if (Cards[idx1].exist == true) {
                    p[i].setScore(p[i].getScore() + Cards[idx1].getValue());
                    p[i].push(Cards[idx1]);
                    Cards[idx1].exist = false;
                    break;
                }
            }
            while (true) {
                idx2 = rand.nextInt(52);
                if (Cards[idx2].exist == true) {
                    p[i].setScore(p[i].getScore() + Cards[idx2].getValue());
                    p[i].push(Cards[idx2]);
                    Cards[idx2].exist = false;
                    break;
                }
            }
        }
        /*for (int i = 0; i <= 3; i++) {
            System.out.println(p[i].getName());
            System.out.println(p[i].getScore());
        }*/
    }

    Card Select_Card(int index_player) {
        int idx2 = 0;
        while (true) {
            Random rand = new Random();
            idx2 = rand.nextInt(52);
            if (Cards[idx2] != null) {
                if (Cards[idx2].exist == true) {
                    p[index_player].setScore(p[index_player].getScore() + Cards[idx2].getValue());
                    p[index_player].push(Cards[idx2]);
                    Cards[idx2].exist = false;
                    break;
                }
            }
        }
        return Cards[idx2];
    }

    int Update() {
        //  String high_score_nameplayer="";
        int max = 0;
        for (int i = 0; i <= 3; i++) {
            if (p[i].getScore() > max && p[i].getScore() <= 21) {
                max = p[i].getScore();
            }
        }
        //  System.out.println(high_score_nameplayer);
        return max;
    }

}
