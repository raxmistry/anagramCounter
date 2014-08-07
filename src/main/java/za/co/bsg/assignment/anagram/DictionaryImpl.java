package za.co.bsg.assignment.anagram;

import java.util.*;

/**
 * Created by rmistry on 2014/07/18.
 * Dictionary implementation allows one to add words to the Dictionary or check if a word exists in the dictionary
 */
class DictionaryImpl implements za.co.bsg.assignment.anagram.Dictionary {

    // Set is used to store the original dictionary word as well as the hashcode of the sorted string
    private Set<DictionaryWord> dictionaryWords = Collections.synchronizedSet(new TreeSet<DictionaryWord>());

    private DictionaryStringSorter sorter;
    private ApostropheHandler apostropheHandler;
    private StringHashGenerator hashGenerator;

    /*
     * Returns boolean if a word is in a dictionary
     */
    @Override
    public boolean isWordInDictionary(String word) {
        return dictionaryWords.contains(createDictionaryWord(word));
    }


    /**
     * Loads a Dictionary object based on a List<String> of words
     *
     * @param wordList
     */
    @Override
    public void loadDictionary(List<String> wordList) {
        if (wordList != null) {
            for (String word : wordList) {
                addWord(word);
            }
        }
    }

    // Add a word to the dictionary
    private void addWord(String word) {
        dictionaryWords.add(createDictionaryWord(word));
    }

    /**
     * Helper method to consistently create a dictionary word
     * Handles apostrophes in the word using the ApostropheHandler object
     * Generated a hashCode based on the sorted string
     *
     * @param word
     * @return
     */
    private DictionaryWord createDictionaryWord(String word) {
        //Assumption that the apostrophe is not required for an Anagram. Therefore it is removed before the hashcode is generated.
        String wordWithoutApostrophe = apostropheHandler.handleApostrophe(word);
        Integer hash = hashGenerator.getHashCode(sorter.getSortedString(wordWithoutApostrophe));
        return new DictionaryWordImpl(word, hash);
    }

    /**
     * @return - returns the number of words in the dictionary
     */
    @Override
    public int getSizeOfDictionary() {
        return dictionaryWords.size();
    }

    /**
     * The DictionaryStringSorter object handles how the string should be sorted before a hash is generated from the string
     *
     * @param dictionaryStringSorter
     */
    @Override
    public void setDictionaryStringSorter(DictionaryStringSorter dictionaryStringSorter) {
        this.sorter = dictionaryStringSorter;
    }


    /**
     * StringHashGenerator is used to generate a hash from a string so that identical strings can be matched
     *
     * @param stringHashGenerator
     */
    @Override
    public void setStringHashGenerator(StringHashGenerator stringHashGenerator) {
        this.hashGenerator = stringHashGenerator;
    }


    /**
     * Determines how apostrophes are handled in the dictionary word
     *
     * @param apostropheHandler
     */
    @Override
    public void setApostropheHandler(ApostropheHandler apostropheHandler) {
        this.apostropheHandler = apostropheHandler;
    }

    /**
     * Return an Iterator for the Dictionary
     *
     * @return Iterator
     */
    @Override
    public Iterator getIterator() {
        return dictionaryWords.iterator();
    }

    /**
     * return a Set of DictionaryWords
     *
     * @return
     */
    @Override
    public Set<DictionaryWord> getDictionaryWords() {
        return dictionaryWords;
    }

}
