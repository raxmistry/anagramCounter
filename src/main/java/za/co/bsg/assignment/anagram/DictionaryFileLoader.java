package za.co.bsg.assignment.anagram;

import java.io.IOException;
import java.util.List;

/**
 * Interface to load a Dictionary file into a List<String>
 * Created by rmistry on 2014/07/18.
 */
public interface DictionaryFileLoader {
    List<String> loadDictionary() throws IOException;
}