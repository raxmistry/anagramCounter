package za.co.bsg.assignment.anagram;

/**
 * A wrapper for a dictionary word that stores the word and the hash of the word
 * Created by rmistry on 2014/07/20.
 */
public interface DictionaryWord extends Comparable<DictionaryWord> {
    public String getWord();

    public Integer getHash();
}
