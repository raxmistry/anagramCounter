package za.co.bsg.assignment.anagram;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Anagram Implementation that assumes a Dictionary object has been set on the
 * Created by rmistry on 2014/07/18.
 */
class AnagramImpl implements Anagram {

    private static final Logger logger = Logger.getLogger(AnagramImpl.class.getName());
    private Map<AnagramWordHash, AnagramCounter> anagramMap = Collections.synchronizedMap(new HashMap<AnagramWordHash, AnagramCounter>());
    private Dictionary dictionary;

    /**
     * Populates the anagram map once the dictionary has been populated
     *
     * @param dictionary - expects a non-null Dictionary object
     */
    private void populateAnagramMap(Dictionary dictionary) {
        if (dictionary != null) {

            Iterator iterator = dictionary.getIterator();

            //Iterate over each element in the map and count the instances of anagrams
            for (DictionaryWord dictionaryWord : dictionary.getDictionaryWords()) {
                String word = dictionaryWord.getWord();
                Integer hashCode = dictionaryWord.getHash();

                Integer count = 0;
                // Check if there is a map with the same hashcode in the anagram map

                AnagramWordHash anagramWordHash = new AnagramWordHashImpl(hashCode);

                if (anagramMap.containsKey(anagramWordHash)) {
                    // If so, get the current count
                    count = anagramMap.get(anagramWordHash).getCount();

                }
                //Increment the count
                count++;

                // The anagramMap count will always be one more than the number of anagrams
                logger.log(Level.FINEST, "Adding anagram : " + anagramWordHash.getHash() + " " + count);
                AnagramCounter newCounter = new AnagramCounterImpl(count);
                anagramMap.put(anagramWordHash, newCounter);
            }
        }
    }

    @Override
    public Dictionary getDictionary() {
        return dictionary;
    }

    @Override
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * This method populates and calculates the number of anagrams from the Dictionary
     */
    @Override
    public void countAnagrams() {
        populateAnagramMap(dictionary);
    }

    /**
     * Returns a map containing unique hash and the count of instances of that hash that exist in the Dictionary
     *
     * @return Map<AnagramWordHash, AnagramCounter>
     */
    @Override
    public Map<AnagramWordHash, AnagramCounter> getAnagramMap() {
        return anagramMap;
    }
}
