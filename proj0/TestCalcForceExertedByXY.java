/**
 *  Tests calcForceExertedByXY
 */
public class TestCalcForceExertedByXY {

    /**
     *  Tests calcForceExertedByXY.
     */
    public static void main(String[] args) {
        checkCalcForceExertedByXY();
    }


    /** Checks whether two doubles are approximately equal.
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  eps         Tolerance for the double comparison.
     */
    private static boolean approxEqual(double actual, double expected, double eps) {
        if (Double.isNaN(actual) || Double.isInfinite(actual)) {
            return false;
        }
        return Math.abs(expected - actual) <= eps * Math.max(expected, actual);
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
        if (approxEqual(actual, expected, eps)) {
            System.out.println("PASS: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
            if (approxEqual(actual, expected, eps)) {
                System.out.println(
                        "      Hint: Your answer is exactly opposite of the correct answer."
                );
            }
        }
    }

    /**
     *  Checks the Body class to make sure calcForceExertedByXY works.
     */
    private static void checkCalcForceExertedByXY() {
        System.out.println("Checking calcForceExertedByX and calcForceExertedByY...");

        Body b1 = new Body(1.0, 0.0, -999, -999, 7e5, "samh.gif");
        Body b2 = new Body(3.0, 3.0, -999, -999, 8e5, "aegir.gif");
        Body b3 = new Body(5.0, -3.0, -999, -999, 9e6, "rocinante.gif");

        checkEquals(b1.calcForceExertedByX(b2), 1.5937816714926738, "calcForceExertedByX()", 0.01);
        checkEquals(b1.calcForceExertedByX(b3), 13.44672, "calcForceExertedByX()", 0.01);
        checkEquals(b1.calcForceExertedByY(b2), 2.3906725072390107, "calcForceExertedByY()", 0.01);
        checkEquals(b1.calcForceExertedByY(b3), -10.08504, "calcForceExertedByY()", 0.01);

        System.out.println("Checking that the force exerted by a body on itself is 0.");
        checkEquals(b1.calcForceExertedByX(b1), 0.0, "calcForceExertedByX()", 0.01);        
        checkEquals(b1.calcForceExertedByX(b1), 0.0, "calcForceExertedByY()", 0.01);        

        System.out.println("Checking that the X force exerted by a body on another body with the same x-coordinate is 0.");
        Body b4 = new Body(1.0, 1.0, -999, -999, 1e10, "planetx.gif");
        checkEquals(b1.calcForceExertedByX(b4), 0, "calcForceExertedByX()", 0.01);
    }
}
