package za.co.bsg.assignment.anagram;

/**
 * Created by rmistry on 2014/07/20.
 */
public class DictionaryWordImpl implements DictionaryWord {
    private String word;
    private Integer hashCode;
    private StringHashGenerator stringHashGenerator;
    private DictionaryStringSorter dictionaryStringSorter;


    DictionaryWordImpl(String word, Integer hashCode) {
        this.word = word;
        this.hashCode = hashCode;
    }

    @Override
    public String getWord() {
        return new String(word);
    }

    @Override
    public Integer getHash() {
        return new Integer(hashCode);
    }

    @Override
    public int compareTo(DictionaryWord anotherWord) {
        return this.word.compareTo(anotherWord.getWord());
    }
}
