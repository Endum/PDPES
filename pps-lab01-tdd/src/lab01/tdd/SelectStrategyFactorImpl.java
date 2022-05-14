package lab01.tdd;

public class SelectStrategyFactorImpl extends AbstractSelectStrategyFactor{
    @Override
    public AbstractSelectStrategy evenStrategy() {
        return new SelectEvenStrategy();
    }

    @Override
    public AbstractSelectStrategy multipleStrategy(int divisor) {
        return new SelectMultipleStrategy(divisor);
    }

    @Override
    public AbstractSelectStrategy equalStrategy(int element) {
        return new SelectEqualStrategy(element);
    }
}
