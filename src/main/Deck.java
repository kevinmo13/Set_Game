package main;

import java.util.*;

/**
 * Created by kevinmo on 12/14/15.
 *
 * Class holding all the cards that will be used in the game before they are put in play
 */
public class Deck {
    private static final ResourceBundle CARD_ATTRIBUTES = ResourceBundle
            .getBundle("resources/CardAttributes");
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        buildDeck();
    }

    /*
     * Builds deck using the CardAttributes.properties file to create all the different combinations of cards
     *
     */
    private void buildDeck(){
        List<String[]> attributeList = new ArrayList<>();
        for(String key : CARD_ATTRIBUTES.keySet()){
            String[] values = CARD_ATTRIBUTES.getString(key).split(",");
            attributeList.add(values);
        }

        while(attributeList.size() > 1){
            String[] attribute1 = attributeList.remove(0);
            String[] attribute2 = attributeList.remove(0);
            attributeList.add(combineAttributes(attribute1, attribute2));
        }

        for(int i = 0; i < attributeList.get(0).length; i++){
            String[] cardAttributes = attributeList.get(0)[i].split(",");
            Card c = new Card(Arrays.asList(cardAttributes));
            cards.add(c);
        }
    }

    /*
     * Helper method to find all combinations of two attributes and return the list of combinations
     *
     * @param attribute1 : one attribute that will be combined with the other
     * @param attribute2 : the other attribute that will be used to find all combinations of the two attributes
     * @return String[] : array of all combinations of the two attributes
     */
    private String[] combineAttributes(String[] attribute1, String[] attribute2){
        String[] combinedArray = new String[attribute1.length *attribute2.length];
        int counter = 0;
        for(int i = 0; i < attribute1.length; i++){
            for(int j = 0; j < attribute2.length; j++){
                combinedArray[counter++] = String.format("%s,%s", attribute1[i], attribute2[j]);
            }
        }
        return combinedArray;
    }

    /*
     * Shuffles deck after building deck since deck is built the same way each time. Shuffling ensures a new game each time
     *
     */
    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    /*
     * Method to remove some number of cards from deck
     *
     * @param numCards : cards to remove from deck
     * @return List<Card> : list of cards that were removed from deck
     */
    public List<Card> drawCards(int numCards){
        List<Card> removedCards = new ArrayList<>();
        for(int i = 0; i < numCards; i++){
            removedCards.add(cards.remove(0));
        }
        return removedCards;
    }

    /*
     * Checks to see if there are any cards left in the deck to draw
     *
     * @return boolean : whether deck is empty
     */
    public boolean isEmpty(){
        return cards.size() == 0;
    }

    /*
     * Counts number of cards left in deck
     *
     * @return int : number of cards left
     */
    public int size(){
        return cards.size();
    }
}

