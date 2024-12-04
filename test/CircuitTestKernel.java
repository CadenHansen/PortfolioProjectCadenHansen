import static org.junit.Assert.assertEquals;

import org.junit.Test;

import circuit.ArrayCircuit;

/**
 * Tests for Circuit Kernel Methods
 */
public class CircuitTestKernel {

    /**
     * Tests of getTotalCurrent().
     */

    /**
     * Test of total current with standard voltage and a 60 ohm resistor.
     */
    @Test
    public void testTotalCurrent5Volts60OhmResistor() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(5);
        n.addResistor(5, 60);
        nCopy.addWire(5);
        nCopy.addResistor(5, 60);

        double current = n.getTotalCurrent();

        assertEquals(n, nCopy);
        assertEquals(true, Math.abs((5 / 60) - current) > 0.01);

    }

    /**
     * Test of get total current with the lowest possible resistor value.
     */
    @Test
    public void testTotalCurrentLowestPossibleResistance() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(5);
        n.addResistor(5, 50);
        nCopy.addWire(5);
        nCopy.addResistor(5, 50);

        double current = n.getTotalCurrent();

        assertEquals(n, nCopy);
        assertEquals(true, Math.abs((5 / 50) - current) > 0.01);

    }

    /**
     * Tests of getStarterVoltage
     */

    /**
     * Test of getStarterVoltage with the default voltage out.
     */
    @Test
    public void testGetStarterVoltageDefault() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit(5);

        assertEquals(n, nCopy);
        assertEquals(5, n.getStarterVoltage());

    }

    /**
     * Test of getStarterVoltage with a non normal starting voltage.
     */
    @Test
    public void testGetStartVoltageModified() {

        ArrayCircuit n = new ArrayCircuit(12);
        ArrayCircuit nCopy = new ArrayCircuit(12);

        assertEquals(n, nCopy);
        assertEquals(12, n.getStarterVoltage());

    }

    /**
     * Tests of identifyResistor
     */

    /**
     * Test identifyResistor when object is a resistor.
     */
    @Test
    public void testIdentifyResistorTrue() {

        ArrayCircuit n = new ArrayCircuit(12);
        n.addWire(3);
        n.setObject(2, 75);

        assertEquals(true, n.identifyResistor(2));

    }

    /**
     * Test identifyResistor when object is not a resistor.
     */
    @Test
    public void testIdentifyResistorFalse() {

        ArrayCircuit n = new ArrayCircuit(12);
        n.addWire(3);

        assertEquals(false, n.identifyResistor(2));

    }

    /**
     * Tests of getObject
     */

    /**
     * test getObject when object is not a resistor.
     */
    @Test
    public void testGetObjectNotResistor() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(4);
        nCopy.addWire(4);

        assertEquals(n, nCopy);
        assertEquals(1, n.getObject(3));

    }

    /**
     * test of getObject when object is a resistor.
     */
    @Test
    public void testGetObjectResistor() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(4);
        nCopy.addWire(4);
        n.addResistor(3, 10000);
        nCopy.addResistor(3, 10000);

        assertEquals(n, nCopy);
        assertEquals(10000, n.getObject(3));

    }

    /**
     * Tests of addWire
     */

    /**
     * Test adding wire to circuit.
     */
    @Test
    public void testAddWireLength5() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(5);
        nCopy.addWire(5);

        assertEquals(n, nCopy);
        assertEquals(6, n.length());

    }

    /**
     * Test of adding a longer wire to Circuit.
     */
    @Test
    public void testAddWireLength10() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(10);
        nCopy.addWire(10);

        assertEquals(n, nCopy);
        assertEquals(11, n.length());

    }

    /**
     * Tests of setObject
     */

    /**
     * Test of setting an object to a resistor.
     */
    @Test
    public void testSetObjectToResistor() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(10);
        nCopy.addWire(10);
        n.addResistor(3, 70);
        nCopy.addResistor(3, 80);
        n.setObject(3, 80);

        assertEquals(n, nCopy);
        assertEquals(true, n.identifyResistor(3));
        assertEquals(80, n.getObject(3));

    }

    /**
     * Test of setting object back to a wire.
     */
    @Test
    public void testSetObjectNonResistor() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(10);
        nCopy.addWire(10);
        n.addResistor(3, 70);
        n.setObject(3, 1);

        assertEquals(n, nCopy);
        assertEquals(false, n.identifyResistor(3));
        assertEquals(1, n.getObject(3));

    }

    /**
     * Tests of length
     */

    /**
     * Test of length when non starting length.
     */
    @Test
    public void testLength5() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(5);
        nCopy.addWire(5);

        assertEquals(n, nCopy);
        assertEquals(6, n.length());

    }

    /**
     * Tests of length when standard length.
     */
    @Test
    public void testLengthDefault() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();

        assertEquals(n, nCopy);
        assertEquals(1, n.length());

    }

    /**
     * Test of transferFrom
     */
    @Test
    public void testTransferFrom() {

        ArrayCircuit w = new ArrayCircuit(12);
        ArrayCircuit x = new ArrayCircuit(12);
        ArrayCircuit y = new ArrayCircuit();
        ArrayCircuit z = new ArrayCircuit();
        y.transferFrom(x);

        assertEquals(x, z);
        assertEquals(y, w);

    }

    /**
     * Test of clear.
     */
    @Test
    public void testClear() {

        ArrayCircuit x = new ArrayCircuit();
        ArrayCircuit y = new ArrayCircuit(6);

        y.clear();

        assertEquals(x, y);

    }
}
