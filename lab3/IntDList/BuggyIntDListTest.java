import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Vivant Sakore on 1/29/2020
 */

public class BuggyIntDListTest {

    private BuggyIntDList l, m;

    /**
     * Test mergeIntDList
     */
    @Test
    public void testMergeIntDList() {
        l = new BuggyIntDList(1, 15, 23, 37, 90, 101, 105, 107, 120, 135, 140);
        m = new BuggyIntDList(3, 10, 27, 45, 83, 88, 94, 111, 115, 138);
        l.mergeIntDList(m);
        assertEquals("Size after merge should be 21", 21, l.size());
        assertEquals(".getFront() should be 1", 1, l.getFront());
        assertEquals(".getBack() should be 140", 140, l.getBack());
        assertEquals("First item should be 1", 1, l.get(0));
        assertEquals("Second item should be 3", 3, l.get(1));
        assertEquals("Third item should be 10", 10, l.get(2));
        assertEquals("Fourth item should be 15", 15, l.get(3));
        assertEquals("Fifth item should be 23", 23, l.get(4));
        assertEquals("Sixth item should be 23", 27, l.get(5));
        assertEquals("Seventh item should be 37", 37, l.get(6));
        assertEquals("Eighth item should be 45", 45, l.get(7));
        assertEquals("Ninth item should be 83", 83, l.get(8));
        assertEquals("Tenth item should be 88", 88, l.get(9));
        assertEquals("Eleventh item should be 90", 90, l.get(10));
        assertEquals("Twelfth item should be 94", 94, l.get(11));
        assertEquals("Thirteenth item should be 101", 101, l.get(12));
        assertEquals("Fourteenth item should be 105", 105, l.get(13));
        assertEquals("Fifteenth item should be 107", 107, l.get(14));
        assertEquals("Sixteenth item should be 111", 111, l.get(15));
        assertEquals("Seventeenth item should be 115", 115, l.get(16));
        assertEquals("Eighteenth item should be 120", 120, l.get(17));
        assertEquals("Nineteenth item should be 135", 135, l.get(18));
        assertEquals("Twentieth item should be 138", 138, l.get(19));
        assertEquals("Twenty first item should be 140", 140, l.get(20));

        l = new BuggyIntDList(1, 3, 5);
        m = new BuggyIntDList(1, 3, 5);
        l.mergeIntDList(m);
        assertEquals("Size after merge should be 6", 6, l.size());
        assertEquals(".getFront() should be 1", 1, l.getFront());
        assertEquals(".getBack() should be 5", 5, l.getBack());
        assertEquals("First item should be 1", 1, l.get(0));
        assertEquals("Second item should be 1", 1, l.get(1));
        assertEquals("Third item should be 3", 3, l.get(2));
        assertEquals("Fourth item should be 3", 3, l.get(3));
        assertEquals("Fifth item should be 5", 5, l.get(4));
        assertEquals("Sixth item should be 5", 5, l.get(5));

        l = new BuggyIntDList(5);
        m = new BuggyIntDList();
        l.mergeIntDList(m);
        assertEquals("Size after merge should be 1", 1, l.size());
        assertEquals(".getFront() should be 1", 5, l.getFront());
        assertEquals(".getBack() should be 1", 5, l.getBack());
        assertEquals("First item should be 1", 5, l.get(0));
        assertEquals("Last item should be 1", 5, l.get(-1));

    }

    /**
     * Test reverse
     */
    @Test
    public void testReverse() {
        l = new BuggyIntDList();
        l.reverse();
        assertEquals("Size after reversal should be 0", 0, l.size());
        assertNull(".getFront() after reversal should be null", l.front);
        assertNull(".getBack() after reversal should be null", l.back);

        l = new BuggyIntDList(5);
        l.reverse();
        assertEquals("Size after reversal should be 1", 1, l.size());
        assertEquals(".getFront() after reversal should be 5", 5, l.getFront());
        assertEquals(".getBack() after reversal should be 5", 5, l.getBack());
        assertEquals("First item after reversal should be 5", 5, l.get(0));
        assertEquals("Last item after reversal should be 5", 5, l.get(-1));

        l = new BuggyIntDList(12, 23, 34, 45, 56);
        l.reverse();
        assertEquals("Size after reversal should be 5", 5, l.size());
        assertEquals(".getFront() after reversal should be 56", 56, l.getFront());
        assertEquals(".getBack() after reversal should be 12", 12, l.getBack());
        assertEquals("First item after reversal should be 56", 56, l.get(0));
        assertEquals("Second item after reversal should be 45", 45, l.get(1));
        assertEquals("Third item after reversal should be 34", 34, l.get(2));
        assertEquals("Fourth item after reversal should be 23", 23, l.get(3));
        assertEquals("Fifth item after reversal should be 12", 12, l.get(4));
    }
}
