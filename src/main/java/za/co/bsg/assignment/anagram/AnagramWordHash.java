package za.co.bsg.assignment.anagram;

/**
 * Wrapper for the Dictionary word hash
 * Created by rmistry on 2014/07/20.
 */
public interface AnagramWordHash extends Comparable<AnagramWordHash> {
    public Integer getHash();
}
