package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rmistry on 2014/07/20.
 */
public class AnagramWordHashImplTest {

    private static final String TEST_WORD = "AWord";
    private AnagramWordHash wordHash;

    @Before
    public void before() {
        wordHash = new AnagramWordHashImpl(TEST_WORD.hashCode());
    }

    @Test
    public void testCompareToEquals() throws Exception {
        String anotherWord = "AWord";
        AnagramWordHash anotherHash = new AnagramWordHashImpl(anotherWord.hashCode());

        Assert.assertTrue(wordHash.compareTo(anotherHash) == 0);

    }

    @Test
    public void testGetHashCode() throws Exception {
        Assert.assertEquals(TEST_WORD.hashCode(), wordHash.getHash().intValue());
    }
}
