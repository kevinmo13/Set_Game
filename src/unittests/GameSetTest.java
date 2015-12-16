package unittests;

import main.Card;
import main.GameSet;
import org.junit.*;

/**
 *
 * Created by kevinmo on 12/15/15.
 */

public class GameSetTest {

    @Test
    public void testIsSet(){
        Card[] cardSet = new Card[]{GlobalVar.c0, GlobalVar.c1, GlobalVar.c2};
        Assert.assertTrue(GameSet.isSet(cardSet));
        Card[] notCardSet = new Card[] {GlobalVar.c0, GlobalVar.c1, GlobalVar.c2};
        Assert.assertTrue(GameSet.isSet(notCardSet));

    }
}