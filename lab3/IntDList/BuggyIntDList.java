/**
 * @author Vivant Sakore on 1/29/2020
 */
public class BuggyIntDList extends IntDList {

    /**
     * @param values creates a BuggyIntDList with ints values.
     */
    public BuggyIntDList(Integer... values) {
        super(values);
    }


    /**
     * Merge IntDList `l` into the calling IntDList
     * Assume that the two IntDLists being merged are sorted individually before merge.
     * The resulting IntDList must also be sorted in ascending order.
     *
     * @param l Sorted IntDList to merge
     */
    public void mergeIntDList(IntDList l) {
        front = sortedMerge(this.front, l.front);
    }

    /**
     * Recursively merge nodes after value comparison
     *
     * @param d1 Node 1
     * @param d2 Node 2
     * @return Nodes arranged in ascending sorted order
     */
    private DNode sortedMerge(DNode d1, DNode d2) {

        // FIXME: Below code has multiple problems. Debug the code to implement correct functionality.

        // ------ WRITE ADDITIONAL CODE HERE AND ONLY HERE (IF NEEDED) ------

        // ------------------------------------------------------------------

        if (d1.val <= d2.val) {
            d1.next = sortedMerge(d1, d2.next);   // FIXME: Replace this line (if needed). HINT: Step Into(F7) using debugger and try to figure out what it does.
            d1.next.prev = d1;
            d1.prev = null;
            return d1;
        } else {
            d2.next = sortedMerge(d1.next, d2);   // FIXME: Replace this line (if needed). HINT: Step Into(F7) using debugger and try to figure out what it does.
            d2.next.prev = d2;
            d2.prev = null;
            return d2;
        }
    }


    /**
     * Reverses IntDList in-place (destructive). Does not create a new IntDList.
     */
    public void reverse() {

        // FIXME: Below code has multiple problems. Debug the code to implement correct functionality.

        DNode temp = null;
        DNode p = front;

        // HINT: What does this while loop do? Use Debugger and Java Visualizer to figure out.
        while (p != null) {
            temp = p.prev;
            p.prev = p.next;
            p.next = temp;
            p = p.next;        // FIXME: Replace this line (if needed). HINT: Use debugger and Java Visualizer to figure out what it does.
        }

        // HINT: What does this if block do? Use Debugger and Java Visualizer to figure out.
        if (temp != null) {
            // ------ WRITE ADDITIONAL CODE HERE AND ONLY HERE (IF NEEDED) -----

            // -----------------------------------------------------------------
            front = temp.next;    // FIXME: Replace this line (if needed). HINT: Use debugger and Java Visualizer to figure out what it does.
        }
    }
}
