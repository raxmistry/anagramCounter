package za.co.bsg.assignment.anagram;

/**
 * Custom HashCode generator.
 * Created by rmistry on 2014/07/18.
 */
class StringHashGeneratorImpl implements StringHashGenerator {
    /**
     * Just returns the default hashCode for now.
     *
     * @param string
     * @return
     */
    @Override
    public Integer getHashCode(String string) {
        return new Integer(string.hashCode());
    }
}
