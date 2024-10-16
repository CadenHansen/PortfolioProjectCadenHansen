package circuit;

/**
 * {@Code Circuit} enhanced with secondary methods.
 */
public interface Circuit extends CircuitKernel {

    /**
     * Reports the value of {@Code this} over two circuits.
     *
     * @param x
     *            first Circuit
     * @param y
     *            second Circuit
     *
     * @return the value
     * @ensures {@Code can be used to find a voltage over a voltager divider}
     */
    double voltageDivide(int x, int y);

    /**
     * Reports voltage between x and y.
     *
     * @param x
     *            starting position within Circuit
     * @param y
     *            ending position within Circuit
     * @return value
     * @ensures {@Code can be used to find voltage between points on a circuit}
     */
    double getVoltage(int x, int y);

    /**
     * Increments total circuit length.
     *
     * @updates this
     * @ensures this = #this + wire
     */
    void addWire();

    /**
     * Increments total circuit length.
     *
     * @param x
     *            ohms of resistor
     *
     * @updates this
     * @requires x > 10
     * @ensures this = #this
     */
    void addResistor(int x);

    /**
     * Removes object at position x.
     *
     * @param x
     *            location of removed object
     *
     * @replaces object with wire
     * @ensures this = #this
     */
    void removeObject(int x);

    /**
     * Returns the voltage {@Code this} out through a sample Comparator.
     *
     * @param x
     *            circuit line one into the positive end of the comparator
     * @param y
     *            circuit line two into the negative end of the comparator
     * @param voltage1
     *            voltage out if positive end has higher voltage
     * @param voltage2
     *            voltage out if negative end has higher voltage
     *
     * @return value of voltage out
     * @ensures {@Code can be used to obtain a voltage out}
     */
    double emulateComparator(int x, int y, double voltage1, double voltage2);

}
