package za.co.bsg.assignment.anagram;

/**
 * Implementation of the AnagramWordHash interface.
 * Created by rmistry on 2014/07/20.
 */
class AnagramWordHashImpl implements AnagramWordHash {

    private Integer hash;

    public AnagramWordHashImpl(Integer hash) {
        if (hash != null) {
            this.hash = hash;
        }
    }

    /**
     * Compares two AnagramWordHash instances.
     *
     * @param o - AnagramWordHash
     * @return int
     */
    @Override
    public int compareTo(AnagramWordHash o) {
        return this.hash.compareTo(o.getHash());
    }

    @Override
    public Integer getHash() {
        return new Integer(hash);
    }

    /**
     * Two AnagramWordHash instances are equal if the hash on the instances are equal
     *
     * @param wordHash
     * @return
     */
    @Override
    public boolean equals(Object wordHash) {

        if (wordHash instanceof AnagramWordHash) {
            AnagramWordHash newWordHash = (AnagramWordHash) wordHash;
            if (this == wordHash) return true;
            else {
                if (this.getHash().compareTo(newWordHash.getHash()) == 0) return true;
                else return false;
            }
        } else return false;
    }

    /**
     * Overriding the default hashCode implementation so instances of AnagramWordHash can be compared
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hashCode = 31;
        hashCode = this.hash * hashCode;
        hashCode = hashCode << 16;
        return hashCode;
    }
}
