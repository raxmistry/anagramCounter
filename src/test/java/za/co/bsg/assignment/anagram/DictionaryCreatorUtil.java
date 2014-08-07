package za.co.bsg.assignment.anagram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for test cases
 * Created by rmistry on 2014/07/18.
 */


public class DictionaryCreatorUtil {

    private static DictionaryStringSorter sorter = new DictionaryStringSorterImpl();
    private static StringHashGenerator hashCodeGenerator = new StringHashGeneratorImpl();
    private static ApostropheHandler apostropheHandler = new ApostropheRemoverHandlerImpl();

    public static Dictionary createDictionary(String filename) {
        DictionaryFileLoader fileLoader = new DictionaryFileLoaderImpl(filename);
        List<String> wordList = new ArrayList<String>();
        try {
            wordList = fileLoader.loadDictionary();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        Dictionary dictionary = new DictionaryImpl();
        dictionary.setDictionaryStringSorter(sorter);
        dictionary.setStringHashGenerator(hashCodeGenerator);
        dictionary.setApostropheHandler(apostropheHandler);
        dictionary.loadDictionary(wordList);
        return dictionary;
    }
}