package lab01.tdd;

public class SelectMultipleStrategy extends AbstractSelectStrategy{

    private final int divisor;

    public SelectMultipleStrategy(int divisor){
        this.divisor = divisor;
    }

    @Override
    public boolean apply(int element) {
        return element % this.divisor == 0;
    }
}
