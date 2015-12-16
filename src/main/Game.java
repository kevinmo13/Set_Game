package main;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by kevinmo on 12/14/15.
 *
 * Class to handle the game loop for Set. Initializes deck, board, and players and can play through a game.
 */
public class Game {
    private static final ResourceBundle GAME_RULES = ResourceBundle
            .getBundle("resources/Game");
    private static final int NUM_CARDS_ON_BOARD = Integer
            .parseInt(GAME_RULES.getString("BoardCardNumber"));
    private static final int NUM_CARDS_TO_ADD = Integer
            .parseInt(GAME_RULES.getString("NumberOfCardsToAdd"));
    private List<Player> gamePlayers;
    private Board gameBoard;
    private Deck gameDeck;

    public Game(){
        gameDeck = new Deck();
        gameBoard = new Board();
        gamePlayers = new ArrayList<>();
    }

    /*
     * Method to set number of players in game
     *
     * @param numPlayers: number of players in game
     *
     */
    private void initializePlayers(int numPlayers){
        for(int i = 0; i < numPlayers; i++){
            gamePlayers.add(new Player());
        }
    }

    /*
     * Method to initialize parts of the game before the game can start. i.e. shuffling deck, setting up board, etc.
     *
     */
    public void initializeGame(){
        gameDeck.shuffleDeck();
        gameBoard.displayCards(gameDeck.drawCards(NUM_CARDS_ON_BOARD));
    }

    /*
     * Automated game loop for Set. Handles playing through a game of set and returns all the sets that are found.
     *
     * @return List<GameSet> : list of sets that are removed during game play.
     */
    public List<GameSet> playGame(){
        List<GameSet> setsRemoved = new ArrayList<>();
        GameSet setToRemove = Player.findSet(gameBoard.getCardsOnBoard());
        while(!gameDeck.isEmpty() || setToRemove != null){
            // Game continues while cards are still in the deck or if there are any sets on the board
            if(setToRemove != null){            // Signifies that there is a legal move to be made
                setsRemoved.add(setToRemove);
                gameBoard.discardCards(setToRemove.toList());
            } else{                             // Signifies that more cards need to be added to
                gameBoard.displayCards(gameDeck.drawCards(NUM_CARDS_TO_ADD));
            }
            setToRemove = Player.findSet(gameBoard.getCardsOnBoard());
        }
        return setsRemoved;
    }

    /*
     * Method that initializes and plays game. Returns the sets removed during game play
     *
     * @return List<GameSet> : list of sets that are removed during game play.
     */
    public List<GameSet> simulateGame(){
        this.initializeGame();
        return this.playGame();
    }

    /*
     * Method to return list of cards on the board at any time.
     *
     * @return List<Card> : cards remaining on the board
     */
    public List<Card> getRemainingCards(){
        return gameBoard.getCardsOnBoard();
    }


}