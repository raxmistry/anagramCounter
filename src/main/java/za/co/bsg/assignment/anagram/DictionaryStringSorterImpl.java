package za.co.bsg.assignment.anagram;

import java.util.Arrays;

/**
 * Sort the characters in a string in alphabetical order
 * Created by rmistry on 2014/07/18.
 */
class DictionaryStringSorterImpl implements DictionaryStringSorter {
    @Override
    public String getSortedString(String word) {
        if (word == null) {
            return null;
        }
        //Convert the word to a character array and sort the array
        char[] characters = word.toCharArray();
        Arrays.sort(characters);

        //return a new string with characters in sorted order
        return new String(characters);
    }
}
