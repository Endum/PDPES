import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;

    @BeforeEach
    public void setup(){
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testEmpty(){
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testNotEmpty(){
        this.circularList.add(5);
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    public void testAdd(){
        this.circularList.add(5);
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.next(), 5));
    }

    @Test
    public void testSize(){
        this.circularList.add(5);
        assertEquals(1, this.circularList.size());
    }

    @Test
    public void testEmptyNext(){
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    public void testNextNext(){
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.next();
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.next(), 10));
    }

    @Test
    public void testCircularity(){
        this.circularList.add(5);
        this.circularList.next();
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.next(), 5));
    }

    @Test
    public void testReset(){
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.next();
        this.circularList.reset();
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.next(), 5));
    }

    @Test
    public void testPrevious(){
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.next();
        this.circularList.previous();
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.next(), 5));
    }

    @Test
    public void testPreviousPrevious(){
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.previous();
        assertTrue(CircularListTestUtils.checkOptionalInteger(this.circularList.previous(), 10));
    }

}
