package circuit;

import java.util.ArrayList;

/**
 * {@code Circuit} represented as a {@code ArrayList} with implementations of
 * primary methods.
 *
 * @convention <pre>
 * [first value within $this.rep > 0] and
 * [this.object int >= 50 means object is resistor] and
 * [starting voltage is 5 unless specified in full args constructor]
 * </pre>
 *
 * @correspondence <pre>
 * [values are input as 1s when generating circuit]
 * </pre>
 *
 * @author Caden Hansen
 *
 */
public class Circuit1 extends CircuitSecondary {

    /**
     * Representation of {@code this}.
     */
    private ArrayList<Integer> rep;

    /**
     * Representation of initial voltage.
     */
    private int voltage;

    /**
     *
     */
    private void createNewRep() {

        this.rep = new ArrayList<Integer>();
        this.voltage = 5;
        this.rep.add(5);

    }

    /**
     * Default constructor.
     */
    public Circuit1() {

        this.createNewRep();

    }

    /**
     *
     * @param voltage
     *            voltage
     *
     *            Full argument constructor.
     *
     */
    public Circuit1(int voltage) {

        this.createNewRep();
        this.voltage = voltage;

    }

    @Override
    public final Circuit newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }

    }

    @Override
    public final void transferFrom(Circuit source) {

        Circuit1 localValue = (Circuit1) source;
        this.rep = localValue.rep;
        localValue.createNewRep();

    }

    @Override
    public final void clear() {

        this.createNewRep();

    }

    @Override
    public double getTotalCurrent() {

        return this.voltage / this.getTotalResistance();

    }

    @Override
    public double getTotalResistance() {

        double totalResistance = 0;

        for (int i = 0; i < this.length(); i++) {

            if (this.identifyResistor(i)) {

                totalResistance += this.getObject(i);

            }

        }

        return totalResistance;

    }

    @Override
    public double getStarterVoltage() {

        return this.voltage;

    }

    @Override
    public boolean identifyResistor(int pos) {

        return this.getObject(pos) >= 50;

    }

    @Override
    public int getObject(int pos) {

        return this.rep.get(pos);

    }

    @Override
    public void addWire(int quantity) {

        for (int i = 0; i < quantity; i++) {
            this.rep.add(1);
        }

    }

    @Override
    public void setObject(int pos, int value) {
        assert value < this.length();

        this.rep.set(pos, value);

    }

    @Override
    public int length() {

        return this.rep.size();

    }

}