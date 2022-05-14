package lab01.tdd;

/**
 * Represent a select Strategy to be applied to determine which is the next element to chose in a CircularList
 */
public abstract class AbstractSelectStrategy {

    /**
     * Determines if the element satisfies the strategy
     * @param element the element to be checked
     * @return true if the element satisfies the strategy, false otherwise
     */
    public abstract boolean apply(final int element);
}
