package unittests;


import main.Board;
import main.Card;

import java.util.Arrays;
import java.util.List;

import org.junit.*;

/**
 * Created by kevinmo on 12/15/15.
 */
public class BoardTest {

    private List<Card> cardsToDisplay;
    private List<Card> cardsToDiscard;

    @Before
    public void setUp() throws Exception {
        cardsToDisplay = Arrays.asList(GlobalVar.c0, GlobalVar.c1, GlobalVar.c2, GlobalVar.c3, GlobalVar.c4, GlobalVar.c5);
        cardsToDiscard = Arrays.asList(GlobalVar.c0, GlobalVar.c1, GlobalVar.c2, GlobalVar.c3, GlobalVar.c4);
    }

    @Test
    public void testDisplayCards1() throws Exception {
        Board b = new Board();
        b.displayCards(cardsToDisplay);
        Assert.assertArrayEquals(cardsToDisplay.toArray(), b.getCardsOnBoard().toArray());
    }

    @Test
    public void testDiscardCards1() throws Exception {
        Board b = new Board();
        b.displayCards(cardsToDisplay);
        b.discardCards(cardsToDiscard);
        Assert.assertArrayEquals(new Card [] {GlobalVar.c5}, b.getCardsOnBoard().toArray());

    }

    @Test
    public void testToString1() throws Exception {
        Board b = new Board();
        b.displayCards(Arrays.asList(GlobalVar.c0, GlobalVar.c1));
        Assert.assertEquals("[ Diamond One Red Solid ]\n[ Diamond Two Red Solid ]\n", b.toString());
    }
}
