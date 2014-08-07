package za.co.bsg.assignment.anagram;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by rmistry on 2014/07/18.
 */
public interface Dictionary {
    public boolean isWordInDictionary(String word);

    public int getSizeOfDictionary();

    public void loadDictionary(List<String> wordList);

    public void setDictionaryStringSorter(DictionaryStringSorter dictionaryStringSorter);

    public void setStringHashGenerator(StringHashGenerator stringHashGenerator);

    public void setApostropheHandler(ApostropheHandler apostropheHandler);

    public Iterator getIterator();

    public Set<DictionaryWord> getDictionaryWords();
}
