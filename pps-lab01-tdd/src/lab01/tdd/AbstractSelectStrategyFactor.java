package lab01.tdd;

public abstract class AbstractSelectStrategyFactor {
    public abstract AbstractSelectStrategy evenStrategy();
    public abstract AbstractSelectStrategy multipleStrategy(int divisor);
    public abstract AbstractSelectStrategy equalStrategy(int element);
}
