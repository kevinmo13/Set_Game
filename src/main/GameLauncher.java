package main;

import java.util.List;

/**
 * Created by kevinmo on 12/14/15.
 */
public class GameLauncher {
    public static void main(String[] args){
        executeSimulateGame();
    }

    private static void executeSimulateGame(){
        Game g = new Game();
        List<GameSet> sets = g.simulateGame();
        int counter = 1;
        for(GameSet s : sets){
            System.out.println(String.format("Set %d: %s", counter++, s.toString()));
        }
        List<Card> remainingCards = g.getRemainingCards();
        for(Card c : remainingCards){
            System.out.println(c.toString());
        }
    }

}
