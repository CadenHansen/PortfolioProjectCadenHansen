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
    double voltageDivide(Circuit x, Circuit y);

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
     * @param x
     *            ohms of resistor
     *
     * @param y
     *            location on circuit.
     *
     * @updates this
     * @requires x > 10
     * @ensures this = #this
     */
    void addResistor(int x, int y);

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
    double emulateComparator(Circuit x, Circuit y, double voltage1,
            double voltage2);

    /**
     * Checks if this and x are equal to eachother.
     *
     * @param x
     *            Circuit this is being compared to
     *
     * @ensures this = this
     * @return true/false depending on if equal
     */
    boolean equals(Circuit x);

    /**
     * Creates a string representation of this.
     *
     *
     * @ensures this = this
     * @return this as a string
     */
    @Override
    String toString();

}
