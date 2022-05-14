package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private final List<Integer> circularList;
    private int currentIndexOfList;

    public CircularListImpl(){
        this.circularList = new ArrayList<>();
        this.currentIndexOfList = 0;
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.getCurrentElementAndShift(1);

    }

    @Override
    public Optional<Integer> previous() {
        return this.getCurrentElementAndShift(- 1);
    }

    private Optional<Integer> getCurrentElementAndShift(int shiftBias){
        if(this.circularList.isEmpty()){
            return Optional.empty();
        }
        Optional<Integer> currentElement = Optional.of(this.circularList.get(this.currentIndexOfList));
        this.currentIndexOfList =
                (this.currentIndexOfList + shiftBias + this.circularList.size()) % this.circularList.size();
        return currentElement;
    }

    @Override
    public void reset() {
        this.currentIndexOfList = 0;
    }

    @Override
    public Optional<Integer> next(AbstractSelectStrategy strategy) {
        int savedIndex = this.currentIndexOfList;
        do{
            Optional<Integer> currentElement = this.getCurrentElementAndShift(1);
            if(currentElement.isEmpty() || strategy.apply(currentElement.get())) {
                return currentElement;
            }
        } while(savedIndex != this.currentIndexOfList);
        return Optional.empty();
    }
}
