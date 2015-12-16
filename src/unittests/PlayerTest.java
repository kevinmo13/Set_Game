package unittests;

import main.Card;
import main.GameSet;
import main.Player;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by kevinmo on 12/15/15.
 */
public class PlayerTest {
    private List<Card> boardWithSet;
    private List<Card> boardWithoutSet;

    @Before
    public void setUp(){
        boardWithSet = Arrays.asList(GlobalVar.c0, GlobalVar.c1, GlobalVar.c3, GlobalVar.c4, GlobalVar.c5, GlobalVar.c6);
        boardWithoutSet = Arrays.asList(GlobalVar.c0, GlobalVar.c1, GlobalVar.c3, GlobalVar.c4, GlobalVar.c6);
    }

    @Test
    public void testFindSet(){
        GameSet set = Player.findSet(boardWithSet);
        Assert.assertArrayEquals(set.toList().toArray(), new Card[]{GlobalVar.c3, GlobalVar.c4, GlobalVar.c5});
        GameSet notASet = Player.findSet(boardWithoutSet);
        Assert.assertTrue(notASet == null);
    }
}
