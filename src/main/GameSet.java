package main;

import java.util.*;

/**
 * Created by kevinmo on 12/14/15.
 *
 * Class representing a set in the game, Set.
 */
public class GameSet {
    private static final ResourceBundle GAME_RULES = ResourceBundle
            .getBundle("resources/Game");
    private static final ResourceBundle CARD_ATTRIBUTES = ResourceBundle
            .getBundle("resources/CardAttributes");
    private static final int numCardsInSet = Integer
            .parseInt(GAME_RULES.getString("SetCardNumber"));
    private Card[] cardSet;

    public GameSet(Card[] set){
        cardSet = set;
    }

    /*
     * A method that takes array of cards, and determines whether the cards make a set
     *
     * @param cards : array of cards that need to be checked to see if they form a set
     * @return boolean : whether array of cards was a set or not
     */
    public static boolean isSet(Card[] cards){
        int numCardAttributes = CARD_ATTRIBUTES.keySet().size();

        // Initialize the Sets
        List<Set<String>> attributeSets = new ArrayList<>();
        for(int i = 0; i < numCardAttributes; i++){
            attributeSets.add(new HashSet<>());
        }

        // Adds each cards attribute to the corresponding set
        for(Card c: cards){
            for(int i = 0; i < numCardAttributes; i++){
                attributeSets.get(i).add(c.getAttributes().get(i));
            }
        }

        // Checks to see if the set's size is one or the number of possible values for an attribute
        for(Set<String> s : attributeSets){
            if(s.size() != 1 && s.size() != numCardsInSet){
                return false;
            }
        }
        return true;
    }

    /*
     * Returns GameSet as a list
     *
     * @return List<Card> : the set in list form
     */
    public List<Card> toList(){
        return Arrays.asList(cardSet);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        for(Card c : cardSet){
            sb.append(c.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}