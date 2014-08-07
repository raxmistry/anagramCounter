package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmistry on 2014/07/18.
 */
public class DictionaryImplTest {

    public static final int EXPECTED = 99156;
    private static final String BRITISH_ENGLISH = "src/test/resources/british-english";
    private static final String SOME_WORD = "SomeWord";
    private Dictionary dictionary;


    @Before
    public void before() {
        dictionary = DictionaryCreatorUtil.createDictionary(BRITISH_ENGLISH);
    }

    /**
     * Checks if the word was successfully added to the dictionary
     */
    @Test
    public void isWordInDictionaryTrue() {

        List<String> wordList = new ArrayList<String>();
        wordList.add(SOME_WORD);
        dictionary.loadDictionary(wordList);

        Assert.assertTrue(dictionary.isWordInDictionary(SOME_WORD));
    }

    /**
     * Checks that false is returned if the word is not in the dictionary
     */
    @Test
    public void isWordInDictionaryFalse() {
        Assert.assertFalse(dictionary.isWordInDictionary(SOME_WORD));
    }

    /**
     * Check the dictionary size is correctly returned
     */
    @Test
    public void getSizeOfDictionaryTest() {
        Assert.assertEquals(EXPECTED, dictionary.getSizeOfDictionary());
    }

    /**
     * Check the dictionary size is correctly returned for an empty dictionary
     */
    @Test
    public void getSizeOfEmptyDictionaryTest() {
        Assert.assertEquals(0, new DictionaryImpl().getSizeOfDictionary());
    }

    @Test(expected = NullPointerException.class)
    public void nullHashGeneratorTest() {
        DictionaryFileLoader fileLoader = new DictionaryFileLoaderImpl(BRITISH_ENGLISH);
        List<String> wordList = new ArrayList<String>();
        try {
            wordList = fileLoader.loadDictionary();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Dictionary dictionary1 = new DictionaryImpl();
        dictionary1.setApostropheHandler(new ApostropheRemoverHandlerImpl());
        dictionary1.setDictionaryStringSorter(new DictionaryStringSorterImpl());
        dictionary1.setStringHashGenerator(null);
        dictionary1.loadDictionary(wordList);
    }
}
