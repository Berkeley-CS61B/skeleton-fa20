
/**
 *  Tests calcDistance
 */
public class TestCalcDistance {

    /**
     *  Tests calcDistance.
     */
    public static void main(String[] args) {
        checkCalcDistance();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Double.isNaN(actual) || Double.isInfinite(actual)) {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Checks the Body class to make sure calcDistance works.
     */
    private static void checkCalcDistance() {
        System.out.println("Checking calcDistance...");

        Body b1 = new Body(1.0, 0.0, -999, -999, 7e5, "samh.gif");
        Body b2 = new Body(3.0, 3.0, -999, -999, 8e5, "aegir.gif");
        Body b3 = new Body(5.0, -3.0, -999, -999, 9e6, "rocinante.gif");

        checkEquals(b1.calcDistance(b2), Math.sqrt(4.0 + 9.0), "calcDistance()", 0.01);
        checkEquals(b1.calcDistance(b3), Math.sqrt(16.0 + 9.0), "calcDistance()", 0.01);
    }
}
