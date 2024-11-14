package circuit;

import components.standard.Standard;

/**
 * Circuit kernel component with primary methods.
 */
public interface CircuitKernel extends Standard<Circuit> {

    /**
     * Reports total {@Code this} current.
     *
     * @return the current value
     * @ensures {@Code this can be used to obtain current}
     */
    double getTotalCurrent();

    /**
     * Reports added {@Code this} resistance.
     *
     * @return total resistance in series.
     * @ensures {@Code this can be used to find potenital resistance}
     */
    double getTotalResistance();

    /**
     * Reports primary voltage source in circuit.
     *
     * @return beginning voltage
     * @ensures {@Code this can be used to find starting voltage}
     */
    double getStarterVoltage();

    /**
     * Reports whether current object in circuit is a resistor.
     *
     * @param pos
     *            location within circuit being checked.
     *
     * @return true or false if object is a resistor.
     * @ensures {@Code has the ability to be a resistor}
     */
    boolean identifyResistor(int pos);

    /**
     *
     * @param pos
     *            location of object
     * @return objectValue
     */
    int getObject(int pos);

    /**
     * Increments total circuit length.
     *
     * @updates this
     * @ensures this = #this + wire
     */
    void addWire();

    /**
     *
     * @param pos
     *            location of object
     * @param value
     *            value being set at location
     *
     */
    void setObject(int pos, int value);

    /**
     * Gets total length.
     *
     * @return length of circuit
     */
    int length();

}
