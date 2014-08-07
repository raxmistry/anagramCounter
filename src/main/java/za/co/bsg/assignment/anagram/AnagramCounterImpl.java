package za.co.bsg.assignment.anagram;

/**
 * Implementation of AnagramCounter keeps a count of the number of instances of an object
 * Created by rmistry on 2014/07/20.
 */
class AnagramCounterImpl implements AnagramCounter {
    private Integer count = 0;

    AnagramCounterImpl(Integer count) {
        this.count = count;
    }

    @Override
    public void incrementCounter() {
        synchronized (count) {
            count++;
        }
    }

    @Override
    public Integer getCount() {
        return new Integer(count);
    }
}
