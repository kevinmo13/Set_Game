package unittests;

import main.Card;
import main.Deck;

import org.junit.*;

import java.util.List;

/**
 *
 * Created by kevinmo on 12/15/15.
 */
public class DeckTest {

    @Test
    public void testBuildDesk(){
        Deck d = new Deck();
        Assert.assertTrue(d.size() == 81);
        List<Card> cardsDrawn = d.drawCards(1);
        Assert.assertEquals(GlobalVar.c0, cardsDrawn.get(0));
    }

    @Test
    public void testDrawCards(){
        Deck d = new Deck();
        List<Card> cardsDrawn = d.drawCards(21);
        Assert.assertEquals(21, cardsDrawn.size());
    }

    @Test
    public void testIsEmpty(){
        Deck d = new Deck();
        Assert.assertFalse(d.isEmpty());
        d.drawCards(81);
        Assert.assertTrue(d.isEmpty());
    }
}
