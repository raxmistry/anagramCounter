package za.co.bsg.assignment.anagram;

/**
 * Implements ApostropheHandler. Assumes that apostrophes are not needed for anagrams and so removes them.
 * Created by rmistry on 2014/07/20.
 */
class ApostropheRemoverHandlerImpl implements ApostropheHandler {
    @Override
    public String handleApostrophe(String word) {
        return word.replace("'", "");
    }
}
