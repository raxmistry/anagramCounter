package za.co.bsg.assignment.anagram;

import java.util.Map;

/**
 * Anagram Interface
 * Created by rmistry on 2014/07/18.
 */
public interface Anagram {
    public Dictionary getDictionary();

    //Sets a populated Dictionary object on the Anagram
    public void setDictionary(Dictionary dictionary);

    // Once the dictionary has been set on the Anagram, this method calculates the anagrams
    public void countAnagrams();

    public Map<AnagramWordHash, AnagramCounter> getAnagramMap();
}
