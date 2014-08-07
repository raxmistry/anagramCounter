package za.co.bsg.assignment.anagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reads a dictionary file and populates a List<String>
 * Created by rmistry on 2014/07/18.
 */
class DictionaryFileLoaderImpl implements DictionaryFileLoader {

    private final String filename;
    Logger logger = Logger.getLogger(DictionaryFileLoaderImpl.class.getName());

    public DictionaryFileLoaderImpl(String dictionaryFilename) {
        this.filename = dictionaryFilename;
    }

    public List<String> loadDictionary() throws IOException {
        if (filename == null) {
            return new ArrayList<String>();
        }
        return streamFile(filename);
    }

    /**
     * Stream the file in line by line and populate a String List
     *
     * @param filename
     * @return
     * @throws IOException
     */
    private List<String> streamFile(String filename) throws IOException {

        //Dictionary dictionary = new DictionaryImpl();
        List<String> dictionaryList = new ArrayList<String>();

        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            logger.log(Level.FINE, line);
            dictionaryList.add(line);
        }
        bufferedReader.close();
        fileReader.close();

        return dictionaryList;
    }
}
