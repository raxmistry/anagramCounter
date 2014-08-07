package za.co.bsg.assignment.anagram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple AnagramPrinter Implementation to print the anagrams in the Anagram instance
 * Created by rmistry on 2014/07/18.
 */
public class AnagramSimplePrinterImpl implements AnagramPrinter {

    Logger logger = Logger.getLogger(AnagramSimplePrinterImpl.class.getName());
    private Anagram anagram;
    private ApostropheHandler apostropheHandler;

    private static Dictionary createDictionary(String filename) throws IOException {
        DictionaryFileLoader fileLoader = new DictionaryFileLoaderImpl(filename);
        List<String> wordList = new ArrayList<String>();
        wordList = fileLoader.loadDictionary();
        Dictionary dictionary = new DictionaryImpl();
        dictionary.setDictionaryStringSorter(new DictionaryStringSorterImpl());
        dictionary.setStringHashGenerator(new StringHashGeneratorImpl());
        dictionary.setApostropheHandler(new ApostropheRemoverHandlerImpl());
        dictionary.loadDictionary(wordList);
        return dictionary;
    }

    @Override
    public void setAnagram(Anagram anagram) {
        this.anagram = anagram;
    }

    /**
     * Determines whether apostrophes should be counted in the length
     *
     * @param apostropheHandler
     */
    private void setApostropheHandler(ApostropheHandler apostropheHandler) {
        this.apostropheHandler = apostropheHandler;
    }

    /**
     * Load the given dictionary file into the AnagramPrinter
     *
     * @param filename
     */
    @Override
    public void load(String filename) {
        if (filename == null) {
            logger.log(Level.WARNING, "Filename not provided. Cannot load " + AnagramSimplePrinterImpl.class.getName());
            return;
        }
        anagram = new AnagramImpl();
        apostropheHandler = new ApostropheRemoverHandlerImpl();
        Dictionary dictionary = null;
        try {
            dictionary = createDictionary(filename);
            anagram.setDictionary(dictionary);
            anagram.countAnagrams();
            this.setAnagram(anagram);
        } catch (IOException e) {
            logger.log(Level.WARNING, " Error loading dictionary file: " + filename + " " + e.getStackTrace());
        }

    }

    /**
     * Print the anagrams in the dictionary object to stdout in the format
     * Word
     * Word Length = Instances of anagrams
     */
    @Override
    public void print() {

        Map<AnagramWordHash, AnagramCounter> anagramMap = anagram.getAnagramMap();
        Dictionary dictionary = anagram.getDictionary();

        logger.log(Level.FINE, "Printing anagrams ...");
        for (DictionaryWord dictionaryWord : dictionary.getDictionaryWords()) {

            String word = dictionaryWord.getWord();
            Integer hashCode = dictionaryWord.getHash();

            AnagramWordHash anagramWordHash = new AnagramWordHashImpl(hashCode);

            logger.log(Level.FINEST, "Word: " + word + " | Count = " + anagramMap.get(anagramWordHash).getCount());

            if (anagramMap.containsKey(anagramWordHash) && anagramMap.get(anagramWordHash).getCount() > 1) {

                // Printing out without Logger as per example
                System.out.println(word);
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(apostropheHandler.handleApostrophe(word).length()).append(" = ").append(anagramMap.get(anagramWordHash).getCount());
                System.out.println(stringBuilder.toString());
            }

        }
        logger.log(Level.FINE, "Printing anagrams ... done.");
    }
}
