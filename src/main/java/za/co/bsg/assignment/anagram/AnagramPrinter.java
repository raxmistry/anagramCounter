package za.co.bsg.assignment.anagram;

/**
 * Created by rmistry on 2014/07/18.
 */
public interface AnagramPrinter {
    public void setAnagram(Anagram anagram);

    public void load(String filename);

    public void print();
}
