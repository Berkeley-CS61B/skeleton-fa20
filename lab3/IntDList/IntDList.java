import java.util.Formatter;

/**
 * Scheme-like pairs that can be used to form a list of integers.
 *
 * @author P. N. Hilfinger; updated by Vivant Sakore (1/29/2020)
 */
public class IntDList {

    /**
     * First and last nodes of list.
     */
    protected DNode front, back;

    /**
     * An empty list.
     */
    public IntDList() {
        front = back = null;
    }

    /**
     * @param values the ints to be placed in the IntDList.
     */
    public IntDList(Integer... values) {
        front = back = null;
        for (int val : values) {
            insertBack(val);
        }
    }

    /**
     * @return The first value in this list.
     * Throws a NullPointerException if the list is empty.
     */
    public int getFront() {
        return front.val;
    }

    /**
     * @return The last value in this list.
     * Throws a NullPointerException if the list is empty.
     */
    public int getBack() {
        return back.val;
    }

    /**
     * @return The number of elements in this list.
     */
    public int size() {
        int n;
        n = 0;
        for (DNode p = front; p != null; p = p.next) {
            n += 1;
        }
        return n;
    }

    /**
     * @param i index of element to return
     * @return The integer value at index i
     */
    public int get(int i) {
        DNode p;
        if (i >= 0) {
            p = front;
            while (i > 0) {
                i -= 1;
                p = p.next;
            }
        } else {
            p = back;
            while (i < -1) {
                i += 1;
                p = p.prev;
            }
        }
        return p.val;
    }


    /**
     * @param d value to be inserted in the front
     */
    public void insertFront(int d) {
        front = new DNode(null, d, front);
        if (back == null) {
            back = front;
        } else {
            front.next.prev = front;
        }
    }

    /**
     * @param d value to be inserted in the back
     */
    public void insertBack(int d) {
        back = new DNode(back, d, null);
        if (front == null) {
            front = back;
        } else {
            back.prev.next = back;
        }
    }

    /**
     * @param d     value to be inserted
     * @param index index at which the value should be inserted
     */
    public void insertAtIndex(int d, int index) {
        DNode p;

        if (index >= 0) {
            p = front;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }

            if (null != p) {
                p = new DNode(p.prev, d, p);
            } else {
                p = new DNode(back, d, null);
            }

            if (null != p.prev) {
                p.prev.next = p;
            } else {
                front = p;
            }

            if (null != p.next) {
                p.next.prev = p;
            } else {
                back = p;
            }
        } else {
            p = back;
            for (int i = -1; i > index; i--) {
                p = p.prev;
            }

            if (null != p) {
                p = new DNode(p, d, p.next);
            } else {
                p = new DNode(null, d, front);
            }

            if (null != p.prev) {
                p.prev.next = p;
            } else {
                front = p;
            }

            if (null != p.next) {
                p.next.prev = p;
            } else {
                back = p;
            }
        }
    }

    /**
     * Removes the first item in the IntDList and returns it.
     *
     * @return the item that was deleted
     */
    public int deleteFront() {
        int v = front.val;
        front = front.next;
        if (front == null) {
            back = null;
        } else {
            front.prev = null;
        }
        return v;
    }

    /**
     * Removes the last item in the IntDList and returns it.
     *
     * @return the item that was deleted
     */
    public int deleteBack() {
        int v = back.val;
        back = back.prev;
        if (back == null) {
            front = null;
        } else {
            back.next = null;
        }
        return v;
    }

    /**
     * @param index index of element to be deleted
     * @return the item that was deleted
     */
    public int deleteAtIndex(int index) {
        DNode p;
        int v = 0;

        if (index >= 0) {
            p = front;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            v = p.val;

            if (null != p.prev) {
                p.prev.next = p.next;
            } else {
                front = p.next;
            }

            if (null != p.next) {
                p.next.prev = p.prev;
            } else {
                back = p.prev;
            }
        } else {
            p = back;
            for (int i = -1; i > index; i--) {
                p = p.prev;
            }
            v = p.val;

            if (null != p.prev) {
                p.prev.next = p.next;
            } else {
                front = p.next;
            }

            if (null != p.next) {
                p.next.prev = p.prev;
            } else {
                back = p.prev;
            }
        }

        return v;
    }

    /**
     * @return a string representation of the IntDList in the form
     * [] (empty list) or [1, 2], etc.
     */
    public String toString() {
        Formatter out = new Formatter();
        out.format("[");
        for (DNode p = front; p != null; p = p.next) {
            if (p != front) {
                out.format(", ");
            }
            out.format("%d", p.val);
        }
        out.format("]");
        return out.toString();
    }

    /**
     * DNode is a "static nested class", because we're only using it inside
     * IntDList, so there's no need to put it outside (and "pollute the
     * namespace" with it.
     */
    static class DNode {

        /**
         * Previous DNode.
         */
        protected DNode prev;

        /**
         * Next DNode.
         */
        protected DNode next;

        /**
         * Value contained in DNode.
         */
        protected int val;

        /**
         * @param v the int to be placed in DNode.
         */
        protected DNode(int v) {
            this(null, v, null);
        }

        /**
         * @param p previous DNode.
         * @param v  value to be stored in DNode.
         * @param n next DNode.
         */
        protected DNode(DNode p, int v, DNode n) {
            this.prev = p;
            this.val = v;
            this.next = n;
        }
    }
}
