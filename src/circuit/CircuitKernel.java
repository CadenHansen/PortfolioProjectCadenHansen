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
     *
     * @return
     */
    double getStarterVoltage();

    /**
     * Reports whether current object in circuit is a resistor.
     *
     * @param x
     *            location within circuit being checked.
     *
     * @return true or false if object is a resistor.
     * @ensures {@Code has the ability to be a resistor}
     */
    boolean identifyResistor(int x);

    /**
     *
     * @param x
     * @return
     */
    int getObject(int x);

    /**
     * Increments total circuit length.
     *
     * @updates this
     * @ensures this = #this + wire
     */
    void addWire();

    /**
     *
     * @param x
     * @return
     */
    void setObject(int x, int y);

    int length();

}
