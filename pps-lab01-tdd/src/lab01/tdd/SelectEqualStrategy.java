package lab01.tdd;

public class SelectEqualStrategy extends AbstractSelectStrategy{

    private final int equalElement;

    public SelectEqualStrategy(int equalElement){
        this.equalElement = equalElement;
    }

    @Override
    public boolean apply(int element) {
        return this.equalElement == element;
    }
}
