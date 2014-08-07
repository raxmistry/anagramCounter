package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rmistry on 2014/07/18.
 */
public class DictionaryStringSorterImplTest {

    public static final String TEST_STRING = "monster";
    public static final String SORTED_TEST_STRING = "emnorst";

    @Test
    public void getSortedStringTest() {

        DictionaryStringSorter dictionaryStringSorter = new DictionaryStringSorterImpl();

        String sortedString = dictionaryStringSorter.getSortedString(TEST_STRING);

        Assert.assertEquals(sortedString, SORTED_TEST_STRING);
    }
}
