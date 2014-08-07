package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rmistry on 2014/07/20.
 */
public class ApostropheRemoverHandlerImplTest {
    private static final String WORD_WITH_APOSTROPHE = "monster's";
    private static final String WORD_NO_APOSTROPHE = "monsters";

    private static ApostropheHandler apostropheHandler;

    @Before
    public void before() {
        apostropheHandler = new ApostropheRemoverHandlerImpl();
    }

    @Test
    public void testHandleApostropheWordWithApostrophe() throws Exception {

        String removed = apostropheHandler.handleApostrophe(WORD_WITH_APOSTROPHE);

        Assert.assertEquals(removed, WORD_NO_APOSTROPHE);
    }

    @Test
    public void testHandleApostropheNoApostrophe() {
        String removed = apostropheHandler.handleApostrophe(WORD_NO_APOSTROPHE);

        Assert.assertEquals(removed, WORD_NO_APOSTROPHE);
    }
}
