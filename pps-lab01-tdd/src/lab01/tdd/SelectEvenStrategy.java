package lab01.tdd;

public class SelectEvenStrategy extends AbstractSelectStrategy {
    @Override
    public boolean apply(int element) {
        return element % 2 == 0;
    }
}
