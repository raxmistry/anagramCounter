package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rmistry on 2014/07/20.
 */
public class DictionaryWordImplTest {

    private static final String TEST_WORD = "ATestWord";
    private static final String OTHER_WORD = "AnotherWord";

    DictionaryWord word1;
    DictionaryWord word2;

    @Before
    public void before() {

        word1 = new DictionaryWordImpl(TEST_WORD, TEST_WORD.hashCode());
        word2 = new DictionaryWordImpl(OTHER_WORD, OTHER_WORD.hashCode());
    }


    @Test
    public void testCompareToGreaterThan() {
        Assert.assertTrue(word1.compareTo(word2) < 0);
    }

    @Test
    public void testCompareToLessThan() {
        Assert.assertTrue(word2.compareTo(word1) > 0);
    }

    @Test
    public void testCompareEquals() {
        DictionaryWord equalWord = new DictionaryWordImpl(TEST_WORD, TEST_WORD.hashCode());
        Assert.assertTrue(word1.compareTo(equalWord) == 0);
    }

}
