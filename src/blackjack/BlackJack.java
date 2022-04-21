/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author max
 */
public class BlackJack {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI();

        Game g = new Game();
        g.Generate();
        g.set_information();
        gui.runGUI(g.Cards, g.p[0].c, g.p[1].c, g.p[2].c, g.p[3].c);
        int idx = 0;
        Scanner s = new Scanner(System.in);
        for (int i = 0; idx <= 2; i++) {
            System.out.println("1-Hit  2-Stand");
            int n = s.nextInt();
            if (n == 1) {
                Card c = g.Select_Card(idx);
                gui.updatePlayerHand(c, idx);
                if (g.p[idx].getScore() == 21) {
                    g.p[idx].BLACKJACK = true;
                } else if (g.p[idx].getScore() > 21) {
                    g.p[idx].BLACKJACK = false;
                    g.p[idx].BUSTED = true;
                }
            } else {
                idx++;
            }
        }
         for (int k = 0; k < 52; k++) {
            if (g.Cards[k].exist == false) {
                g.Cards[k] = null;
            }
        }
        for (int i = 0;; i++) {
          Card c = g.Select_Card(idx);
            gui.updateDealerHand(c, g.Cards);
          //  c=null;
            if (g.p[idx].getScore() == 21) {
                g.p[idx].BLACKJACK = true;
                break;
            } else if (g.p[idx].getScore() > 21) {
                g.p[idx].BLACKJACK = false;
                g.p[idx].BUSTED = true;
                break;
            }
        }
        int b = 0;
        int p = 0;
        String h = "";
        for (int i = 0; i <= 3; i++) {
            if (g.p[i].BLACKJACK) {
                h = g.p[i].getName();
                b++;
            } else if (g.p[i].BUSTED) {
                p++;
            }
        }
        if (b == 1) {
            System.out.println("Winner name With Black Jack is " + h);
        } else if (p == 4) {
            System.out.println("PusHHHHHHH ");
        } else if (b == 4 || b == 3 || b == 2) {
            System.out.println("PusHHHHHHH");
        } else {
            System.out.println("High Score Of Game is  : " + g.Update());
        }

    }
}
