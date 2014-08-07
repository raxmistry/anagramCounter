package za.co.bsg.assignment.anagram;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by rmistry on 2014/07/18.
 */
public class AnagramSimplePrinterImplTest {

    private static final String BRITISH_ENGLISH = "src/test/resources/british-english";
    private AnagramPrinter anagramPrinter;
    private Anagram anagram;
    private Dictionary dictionary;
    private ApostropheHandler apostropheHandler;

    @Before
    public void before() {
        anagramPrinter = new AnagramSimplePrinterImpl();
    }


    @Test
    public void testPrint() throws Exception {
        anagramPrinter.load(BRITISH_ENGLISH);
        anagramPrinter.print();
    }


    @Test(expected = NullPointerException.class)
    public void testNullFile() {
        String nullFile = null;
        anagramPrinter.load(nullFile);
        anagramPrinter.print();
    }
}
