package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rmistry on 2014/07/20.
 */
public class AnagramCounterImplTest {

    @Test
    public void testIncrementCount() {

        Integer count = 0;
        AnagramCounter anagramCounter = new AnagramCounterImpl(count);

        anagramCounter.incrementCounter();

        Assert.assertEquals(++count, anagramCounter.getCount());
    }
}
