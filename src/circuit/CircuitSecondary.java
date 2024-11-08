package circuit;

/**
 * Seconday methods.
 */
public abstract class CircuitSecondary implements Circuit {

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
    @Override
    public double voltageDivide(Circuit x, Circuit y) {

        double resistance1 = x.getTotalResistance();
        double resistance2 = x.getTotalResistance();

        return this.getStarterVoltage()
                * (resistance1 / (resistance1 + resistance2));

    }

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
    @Override
    public double getVoltage(int x, int y) {

        double voltage = this.getStarterVoltage();
        double current = this.getTotalCurrent();
        int resistorsChecked = 1;

        for (int i = x; x < y; i++) {

            if (resistorsChecked > 1) {
                current = voltage / this.getObject(i);
            }

            if (this.identifyResistor(i)) {
                double voltageDrop = this.getObject(i) * current;
                voltage -= voltageDrop;
                resistorsChecked++;
            }
        }

        return voltage;
    }

    /**
     * Removes object at position x.
     *
     * @param x
     *            location of removed object
     *
     * @replaces object with wire
     * @ensures this = #this
     */
    @Override
    public void addResistor(int x, int y) {

        this.setObject(x, y);

    }

    /**
     * Removes object at position x.
     *
     * @param x
     *            location of removed object
     *
     * @replaces object with wire
     * @ensures this = #this
     */
    @Override
    public void removeObject(int x) {

        this.setObject(x, 1);
    }

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
    @Override
    public double emulateComparator(Circuit x, Circuit y, double voltage1,
            double voltage2) {

        double voltage = 0;

        if (x.getStarterVoltage() > y.getStarterVoltage()) {
            voltage = voltage1;
        } else {
            voltage = voltage2;
        }

        return voltage;

    }

    /**
     * Checks if this and x are equal to eachother.
     *
     * @param x
     *            Circuit this is being compared to
     *
     * @ensures this = this
     * @return true/false depending on if equal
     */
    @Override
    public boolean equals(Circuit x) {

        boolean equal = true;

        for (int i = 0; i < this.length(); i++) {

            if (this.getObject(i) != x.getObject(i)) {
                equal = false;
            }

        }

        return equal;

    }

    /**
     * Creates a string representation of this.
     *
     *
     * @ensures this = this
     * @return this as a string
     */
    @Override
    public String toString() {

        String objectAsString = "";

        for (int i = 0; i < this.length(); i++) {

            objectAsString += this.getObject(i);

        }

        return objectAsString;

    }

}
