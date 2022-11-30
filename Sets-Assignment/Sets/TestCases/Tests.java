import org.junit.*;

import java.util.HashSet;

public class Tests {

    public HashSet<Word> test;

    @Before
    public void setup() {

        test = new HashSet<>();

    }

    @Test
    public void testEquals() {

        //Add a new word into the hashset
        Assert.assertTrue(test.add(new Word("sons")));

        //Add the same word again to check if it is in the hashset
        Assert.assertFalse(test.add(new Word("sons")));
        Assert.assertFalse(test.add(new Word("Sons")));
        Assert.assertFalse(test.add(new Word("\"sons\"")));
        Assert.assertFalse(test.add(new Word("'sons'")));

        //Adding words that may seem the same but are different
        Assert.assertTrue(test.add(new Word("son")));
        Assert.assertTrue(test.add(new Word("son's")));

    }

}
