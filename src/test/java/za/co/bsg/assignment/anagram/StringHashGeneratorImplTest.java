package za.co.bsg.assignment.anagram;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rmistry on 2014/07/18.
 */
public class StringHashGeneratorImplTest {

    public static final String TEST_STRING = "TestString";

    @Test
    public void getHashCodeTest() {
        StringHashGenerator stringHashGenerator = new StringHashGeneratorImpl();

        Integer hashCode = stringHashGenerator.getHashCode(TEST_STRING);
        Assert.assertEquals(hashCode.intValue(), TEST_STRING.hashCode());

    }
}
