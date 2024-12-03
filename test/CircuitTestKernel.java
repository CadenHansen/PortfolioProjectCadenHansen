import static org.junit.Assert.assertEquals;

import org.junit.Test;

import circuit.ArrayCircuit;

/**
 * Tests for Circuit Kernel Methods
 */
public class CircuitTestKernel {

    /**
     * Tests of getTotalCurrent()
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

        assertEquals(true, n.equals(nCopy));
        assertEquals(true, Math.abs((5 / 60) - current) > 0.01);

    }

    @Test
    public void testTotalCurrentLowestPossibleResistance() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(5);
        n.addResistor(5, 50);
        nCopy.addWire(5);
        nCopy.addResistor(5, 50);

        double current = n.getTotalCurrent();

        assertEquals(true, n.equals(nCopy));
        assertEquals(true, Math.abs((5 / 50) - current) > 0.01);

    }

    /**
     * Tests of getStarterVoltage
     */

    @Test
    public void testGetStarterVoltageDefault() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit(5);

        assertEquals(true, n.equals(nCopy));
        assertEquals(5, n.getStarterVoltage());

    }

    @Test
    public void testGetStartVoltageModified() {

        ArrayCircuit n = new ArrayCircuit(12);
        ArrayCircuit nCopy = new ArrayCircuit(12);

        assertEquals(true, n.equals(nCopy));
        assertEquals(12, n.getStarterVoltage());

    }

    /**
     * Tests of identifyResistor
     */

    @Test
    public void testIdentifyResistorTrue() {

        ArrayCircuit n = new ArrayCircuit(12);
        n.addWire(3);
        n.setObject(2, 75);

        assertEquals(true, n.identifyResistor(2));

    }

    @Test
    public void testIdentifyResistorFalse() {

        ArrayCircuit n = new ArrayCircuit(12);
        n.addWire(3);

        assertEquals(false, n.identifyResistor(2));

    }

    /**
     * Tests of getObject
     */

    @Test
    public void testGetObjectNotResistor() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(4);
        nCopy.addWire(4);

        assertEquals(true, n.equals(nCopy));
        assertEquals(1, n.getObject(3));

    }

    @Test
    public void testGetObjectResistor() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(4);
        nCopy.addWire(4);
        n.addResistor(3, 10000);
        nCopy.addResistor(3, 10000);

        assertEquals(true, n.equals(nCopy));
        assertEquals(10000, n.getObject(3));

    }

    /**
     * Tests of addWire
     */

    @Test
    public void testAddWireLength5() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(5);
        nCopy.addWire(5);

        assertEquals(true, n.equals(nCopy));
        assertEquals(6, n.length());

    }

    @Test
    public void testAddWireLength10() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(10);
        nCopy.addWire(10);

        assertEquals(true, n.equals(nCopy));
        assertEquals(11, n.length());

    }

    /**
     * Tests of setObject
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

        assertEquals(true, n.equals(nCopy));
        assertEquals(true, n.identifyResistor(3));
        assertEquals(80, n.getObject(3));

    }

    @Test
    public void testSetObjectNonResistor() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(10);
        nCopy.addWire(10);
        n.addResistor(3, 70);
        n.setObject(3, 1);

        assertEquals(true, n.equals(nCopy));
        assertEquals(false, n.identifyResistor(3));
        assertEquals(1, n.getObject(3));

    }

    /**
     * Tests of length
     */

    @Test
    public void testLength5() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(5);
        nCopy.addWire(5);

        assertEquals(true, n.equals(nCopy));
        assertEquals(6, n.length());

    }

    @Test
    public void testLength10() {

        ArrayCircuit n = new ArrayCircuit();
        ArrayCircuit nCopy = new ArrayCircuit();
        n.addWire(10);
        nCopy.addWire(10);

        assertEquals(true, n.equals(nCopy));
        assertEquals(11, n.length());

    }
}
