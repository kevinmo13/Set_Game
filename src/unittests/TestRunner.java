package unittests;

/**
 * Created by kevinmo on 12/15/15.
 */
public class TestRunner {
    public static void main(String args[]) {
        String[] tests = new String[]{
                "unittests.CardTest",
                "unittests.GameSetTest",
                "unittests.DeckTest",
                "unittests.BoardTest",
                "unittests.PlayerTest"
        };
        org.junit.runner.JUnitCore.main(tests);
    }
}
