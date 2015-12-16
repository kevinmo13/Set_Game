package main;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by kevinmo on 12/14/15.
 *
 * Class representing a player in the game, Set. Player has the ability of finding sets and scoring points in the game.
 */
public class Player {
    private static final ResourceBundle GAME_RULES = ResourceBundle
            .getBundle("resources/Game");
    private static final int numCardsInSet = Integer
            .parseInt(GAME_RULES.getString("SetCardNumber"));
    private static int numPlayers = 0;
    private int score;
    private int playerID;

    public Player(){
        playerID = numPlayers++;
    }

    /*
     * Returns the ID of the player
     *
     * @return int : ID of the player
     */
    public int getPlayerID(){
        return playerID;
    }

    /*
     * Method to find a set given the current cards in play
     *
     * @param cardsOnBoard : cards in play that can be used to form a set
     * @return GameSet : set that is found on the board or null if no set is found
     */
    public static GameSet findSet(List<Card> cardsOnBoard){
        List<Card[]> cardCombinations = generateCombinations(cardsOnBoard);
        for(Card[] possibleSet : cardCombinations){
            if(GameSet.isSet(possibleSet)){
                return new GameSet(possibleSet);
            }
        }
        return null;
    }

    private static List<Card[]> generateCombinations(List<Card> cardsOnBoard){
        List<Card[]> combinations = new ArrayList<>();

        int[] setIndices = new int[numCardsInSet];

        if (numCardsInSet <= cardsOnBoard.size()) {

            // Adds the first combination which is the first n cards in the list where n is the number of cards in a set.
            for (int i = 0; i < numCardsInSet; i++){
                setIndices[i] = i;
            }
            combinations.add(getSubset(cardsOnBoard, setIndices));

            // Find all other combinations of cards by incrementing various indices in setIndices.
            while(true) {
                int i;
                // find position of item that can be incremented. Increment last index first and then progressively
                // increment lower indices until all combinations are found.
                for (i = numCardsInSet - 1; i >= 0 && setIndices[i] == cardsOnBoard.size() - numCardsInSet + i; i--);
                if (i < 0) {
                    break;
                } else {
                    setIndices[i]++; i++;
                    while(i < numCardsInSet){
                        setIndices[i] = setIndices[i - 1] + 1;
                        i++;
                    }
                    combinations.add(getSubset(cardsOnBoard, setIndices));
                }
            }
        }
        return combinations;
    }

    /*
     * Create combination of cards using indices provided by setIndices
     *
     * @param cardsOnBoard : cards currently in play to be used to generate combinations of cards
     * @param setIndices : indices that correspond to a card in cardsOnBoard
     * @return Card[] : array of cards representing a possible combination of cards in play
     */
    private static Card[] getSubset(List<Card> cardsOnBoard, int[] setIndices) {
        Card[] result = new Card[setIndices.length];
        for (int i = 0; i < setIndices.length; i++) {
            result[i] = cardsOnBoard.get(setIndices[i]);
        }
        return result;
    }

    /*
     * Return number of sets that player has found
     *
     * @return int : number of sets
     */
    public int getScore(){
        return score;
    }
}

