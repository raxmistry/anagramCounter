package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rmistry on 2014/07/18.
 */
public class DictionaryFileLoaderImplTest {

    public static final Logger logger = Logger.getLogger(DictionaryFileLoaderImplTest.class.getName());
    public static final String BRITISH_ENGLISH = "src/test/resources/british-english";
    private DictionaryFileLoader dictionaryFileLoader;


    @Before
    public void before() {
        dictionaryFileLoader = new DictionaryFileLoaderImpl(BRITISH_ENGLISH);
    }

    @Test
    public void readFileTest() {

        List<String> dictionaryList = null;
        try {
            dictionaryList = dictionaryFileLoader.loadDictionary();
        } catch (IOException ioException) {
            logger.log(Level.SEVERE, BRITISH_ENGLISH + " dictionary file cannot be loaded. " + ioException.getMessage());
            Assert.fail(BRITISH_ENGLISH + " dictionary file cannot be loaded");
        }

        Assert.assertNotNull(dictionaryList);
        Assert.assertEquals(dictionaryList.size(), 99156);
    }

    @Test
    public void readNullFileTest() throws IOException {
        String nullString = null;
        dictionaryFileLoader = new DictionaryFileLoaderImpl(nullString);

        try {
            List<String> dictionaryList = dictionaryFileLoader.loadDictionary();
            Assert.assertTrue(dictionaryList.size() == 0);
        } catch (IOException ioException) {
            throw new IOException(ioException);
        }
    }
}
