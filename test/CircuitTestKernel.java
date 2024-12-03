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

        assertEquals(nCopy, n);
        assertEquals(true, Math.abs((5 / 60) - current) < 0.001);

    }

    @Test
    public void testTotalCurrentLowestPossibleResistance() {

    }

    /**
     * Tests of getStarterVoltage
     */

    /**
     * Tests of identifyResistor
     */

    /**
     * Tests of getObject
     */

    /**
     * Tests of addWire
     */

    /**
     * Tests of setObject
     */

    /**
     * Tests of length
     */
}
