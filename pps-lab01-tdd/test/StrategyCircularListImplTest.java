import lab01.tdd.AbstractSelectStrategyFactor;
import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.SelectStrategyFactorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyCircularListImplTest {

    CircularList circularList;
    AbstractSelectStrategyFactor selectStrategyFactor;

    @BeforeEach
    public void setup(){
        this.circularList = new CircularListImpl();
        this.circularList.add(5);
        this.circularList.add(7);
        this.circularList.add(10);
        this.circularList.add(15);

        this.selectStrategyFactor = new SelectStrategyFactorImpl();
    }

    @Test
    public void nextEven(){
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.next(
                this.selectStrategyFactor.evenStrategy()
        ), 10));
    }

    @Test void nextMultiple(){
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.next(
                this.selectStrategyFactor.multipleStrategy(3)
        ), 15));
    }

    @Test void nextEquals(){
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.next(
                this.selectStrategyFactor.equalStrategy(7)
        ), 7));
    }
}