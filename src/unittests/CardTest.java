package unittests;

import org.junit.*;

/**
 *
 * Created by kevinmo on 12/15/15.
 */
public class CardTest {

    @Test
    public void testToString(){
        Assert.assertEquals(GlobalVar.c0.toString(), "[ Diamond One Red Solid ]");
    }

}