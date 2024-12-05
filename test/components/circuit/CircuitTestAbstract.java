package components.circuit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing Class for each method of the Circuit Object
 */
public class CircuitTestAbstract {

    /**
     * Tests of voltage divide.
     */

    /**
     * Testing voltage divide when both circuits are equal.
     */
    @Test
    public void testVoltageDivideEqual() {

        ArrayCircuit x = new ArrayCircuit(5, 10);
        ArrayCircuit y = new ArrayCircuit(5, 10);
        x.addResistor(5, 80);
        y.addResistor(5, 80);

        double voltsOut = x.voltageDivide(x, y);

        assertEquals(true, Math.abs(voltsOut - (x.getStarterVoltage()
                * (x.getTotalResistance() + y.getTotalResistance()))) > 0.0001);

    }

    /**
     * Testing voltage divide when both circuits are not equal.
     */
    @Test
    public void testVoltageDivideNonEqual() {

        ArrayCircuit x = new ArrayCircuit(5, 10);
        ArrayCircuit y = new ArrayCircuit(12, 10);
        x.addResistor(5, 80);
        y.addResistor(5, 120);

        double voltsOut = x.voltageDivide(x, y);

        assertEquals(true, Math.abs(voltsOut - (x.getStarterVoltage()
                * (x.getTotalResistance() + y.getTotalResistance()))) > 0.0001);

    }

    /**
     * Tests of getVoltage.
     */

    /**
     * Test with empty Circuit.
     */
    @Test
    public void testGetVoltageStart() {

        ArrayCircuit x = new ArrayCircuit(8, 10);
        ArrayCircuit y = new ArrayCircuit(5, 10);
        assertEquals(8, (int) x.getVoltage(0, x.length() - 1));
        assertEquals(5, (int) y.getVoltage(0, y.length() - 1));

    }

    /**
     * Test when theres a resistor to lower voltage.
     */
    @Test
    public void testGetVoltageMiddle() {

        ArrayCircuit x = new ArrayCircuit(8, 10);
        ArrayCircuit y = new ArrayCircuit(5, 10);
        x.addResistor(5, 80);
        y.addResistor(5, 90);

        double yDrop = y.getStarterVoltage()
                - (y.getObject(5) * y.getTotalCurrent());
        double xDrop = x.getStarterVoltage()
                - (x.getObject(5) * x.getTotalCurrent());

        assertEquals(true, Math.abs(yDrop - x.getVoltage(5, 5)) > 0.0001);
        assertEquals(true, Math.abs(xDrop - x.getVoltage(5, 5)) > 0.0001);

    }

    /**
     * Tests of add Resistor.
     */

    /**
     * Test of add Resistor when empty.
     */
    @Test
    public void testAddResistorEmpty() {

        ArrayCircuit x = new ArrayCircuit(12, 2);
        x.addResistor(1, 500);
        ArrayCircuit y = new ArrayCircuit(12, 2);
        y.addResistor(1, 500);

        assertEquals(x, y);
        assertEquals(500, x.getObject(1));

    }

    /**
     * Test of add Resistor when empty.
     */
    @Test
    public void testAddResistorNonempty() {

        ArrayCircuit x = new ArrayCircuit(12, 5);
        x.addResistor(1, 500);
        x.addResistor(3, 250);
        ArrayCircuit y = new ArrayCircuit(12, 5);
        y.addResistor(1, 500);
        y.addResistor(3, 250);

        assertEquals(x, y);
        assertEquals(250, x.getObject(3));

    }

    /**
     * Test of removeObject.
     */
    @Test
    public void testRemoveObject() {

        ArrayCircuit x = new ArrayCircuit(12, 5);
        x.addResistor(1, 500);
        ArrayCircuit y = new ArrayCircuit(12, 5);
        x.removeObject(1);

        assertEquals(x, y);

    }

    /**
     * Tests of emulate comparator.
     */

    /**
     * Test expected Assertion.
     */
    @Test(expected = AssertionError.class)
    public void testComparatorAssertionError() {

        ArrayCircuit x = new ArrayCircuit(5, 10);
        ArrayCircuit y = new ArrayCircuit(5, 10);
        x.addResistor(5, 80);
        y.addResistor(5, 80);

        x.emulateComparator(x, y, 10, 12);

    }

    /**
     * Test comparator with output.
     */
    @Test
    public void testComparatorOutput() {

        ArrayCircuit x = new ArrayCircuit(5, 10);
        ArrayCircuit y = new ArrayCircuit(12, 10);
        x.addResistor(5, 80);
        y.addResistor(5, 80);

        assertEquals(20, (int) x.emulateComparator(x, y, 10, 20));

    }

    /**
     * Tests of equals
     */

    /**
     * Test equals when no arguments.
     */
    @Test
    public void testEqualsNoArguments() {

        ArrayCircuit x = new ArrayCircuit();
        ArrayCircuit y = new ArrayCircuit();

        assertEquals(x, y);

    }

    /**
     * Test equals with arguments.
     */
    @Test
    public void testEqualsWithArgs() {

        ArrayCircuit x = new ArrayCircuit(12, 10);
        ArrayCircuit y = new ArrayCircuit(12, 10);
        x.addResistor(4, 10000);
        y.addResistor(4, 10000);

        assertEquals(x, y);

    }

    /**
     * Test equals when false.
     */
    @Test
    public void testEqualsFalse() {

        ArrayCircuit x = new ArrayCircuit(12, 10);
        ArrayCircuit y = new ArrayCircuit(12, 10);
        x.addResistor(4, 10000);
        y.addResistor(5, 10000);

        assertEquals(false, x.equals(y));

    }

    /**
     * Tests of toString.
     */

    /**
     * Test toString with arguments.
     */
    @Test
    public void testToStringArgs() {

        ArrayCircuit x = new ArrayCircuit(10, 4);
        x.addResistor(3, 10000);

        assertEquals("10-1-1-10000-1-END", x.toString());

    }

    /**
     * Test of twoString when empty.
     */
    @Test
    public void testToStringEmpty() {

        ArrayCircuit x = new ArrayCircuit();

        assertEquals("5-END", x.toString());

    }

}
