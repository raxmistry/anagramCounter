package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rmistry on 2014/07/18.
 */
public class AnagramImplTest {

    private static final String BRITISH_ENGLISH = "src/test/resources/british-english";
    private Anagram anagram;

    @Before
    public void before() {
        anagram = new AnagramImpl();
        Dictionary dictionary = DictionaryCreatorUtil.createDictionary(BRITISH_ENGLISH);
        anagram.setDictionary(dictionary);
    }

    @Test
    public void testCreateAnagram() {
        anagram.countAnagrams();
        Assert.assertNotNull(anagram);
    }

    @Test
    public void testCreateAnagramNull() {
        Dictionary dictionary = null;
        anagram.setDictionary(dictionary);

        anagram.countAnagrams();

    }
}
