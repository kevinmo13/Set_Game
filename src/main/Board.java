package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinmo on 12/14/15.
 *
 * Class that displays all the cards in play from which a player can create a set
 */
public class Board {
    private List<Card> displayedCards;

    public Board(){
        displayedCards = new ArrayList<>();
    }

    /*
     * Method to display new cards to the board
     *
     * @param cardsToDisplay : cards to be added to the board
     *
     */
    public void displayCards(List<Card> cardsToDisplay){
        for(Card c : cardsToDisplay){
            displayedCards.add(c);
        }
    }

    /*
     * Method to remove cards from the board after a set has been found
     *
     * @param cardsToDiscard : cards to be removed from play
     */
    public void discardCards(List<Card> cardsToDiscard){
        for(Card c : cardsToDiscard){
            displayedCards.remove(c);
        }
    }

    /*
     * Method to return cards that are currently in play on the Board
     *
     * @return List<Card> : cards currently in play on the board
     */
    public List<Card> getCardsOnBoard(){
        return displayedCards;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(Card c : displayedCards){
            sb.append(String.format("%s\n", c.toString()));
        }
        return sb.toString();
    }


}