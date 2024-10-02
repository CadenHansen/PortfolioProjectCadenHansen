import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 *
 * @author Caden Hansen
 */
public final class Circuit {

    /**
     * Instance variables (fields)
     */

    /**
     * arrayList to represent Circuit.
     */
    private ArrayList<Integer> circuit;

    /**
     * arrayList of arrayLists to allow for parallel circuits.
     *
     * not fully fleshed out rn, all the methods will likely need to be changed
     * in someway to account for potential parallelCircuits but I think the
     * utility would allow for more depth inside of the component. The ability
     * to add comparators and other such circuit parts.
     *
     */
    private ArrayList<ArrayList<Integer>> parallelCircuit;

    /*
     * location 0 voltage value.
     */
    private int voltage;

    /**
     * Default constructor.
     */
    private Circuit() {
        //default voltage
        this.voltage = 5;
        this.circuit.add(0, this.voltage);

    }

    /**
     *
     * @param circuitList
     * @param voltageValue
     * @param parallelArray
     *
     *            Full argument constructor.
     */
    private Circuit(ArrayList<Integer> circuitList, int voltageValue,
            ArrayList<ArrayList<Integer>> parallelArray) {
        this.circuit = circuitList;
        this.voltage = voltageValue;
        this.parallelCircuit = parallelArray;
        this.circuit.add(0, this.voltage);
    }

    /**
     *
     * @param quantity
     *            number of wires to add to the list
     */
    public void addWire(int quantity) {

        //starts with 1 because 0 value is always power source
        for (int i = 1; i < quantity; i++) {
            this.circuit.add(1);
        }

    }

    /**
     * gets current of total circuit for use with calculations.
     *
     * @return overall current of the circuit
     */
    public double getTotalCurrent() {

        double current = 0;
        double overallResistance = 0;

        for (int i = 1; i < this.circuit.size(); i++) {
            if (this.circuit.get(i) > 10) {
                overallResistance += this.circuit.get(i);
            }
        }

        current = this.voltage / overallResistance;

        return current;
    }

    /**
     *
     * @param resistance
     * @param location
     */
    public void addResistor(int resistance, int location) {
        assert resistance > 10 : "Resistance value cannot be lower than 10";

        //adding resistor to circuit
        this.circuit.add(location, resistance);

    }

    /**
     *
     * @param startPos
     *            starting location on the circuit to get voltage from.
     * @param endPos
     *            ending location on the circuit to get voltage from.
     * @return voltage from pos1 to pos2.
     */
    public double getVoltageOverCircuit(int startPos, int endPos) {
        assert startPos > 0 : "Cannot start at voltage location";

        double voltageValue = this.voltage;
        double voltageDrop = 0;
        int resistorsChecked = 0;
        //for our initial current we need the total current
        double current = this.getTotalCurrent();
        for (int i = startPos; i < endPos; i++) {

            if (resistorsChecked > 0) {
                //prevents bug relating to current and incorrect voltage
                current = voltageValue / this.circuit.get(i);
            }

            //larger than 10 implies value is a resistor
            if (this.circuit.get(i) > 10) {
                voltageDrop = this.circuit.get(i) * current;
                voltageValue -= voltageDrop;
                resistorsChecked++;
            }

        }
        return (int) voltageValue;
    }

    /**
     *
     * @param circuit1
     *            the first of two divided circuits
     * @param circuit2
     *            the second of two divided circuits
     * @return input voltage across a voltage divider.
     */
    public double voltageDivide(int circuit1, int circuit2) {

        //im not sure if this is how you would implement this, but this is an
        //example of the ability to use parallel circuits.

        double voltageOut = 0;
        double resistanceA = 0;
        double resistanceB = 0;
        ArrayList<Integer> frontCircuit = this.parallelCircuit.get(circuit1);
        ArrayList<Integer> backCircuit = this.parallelCircuit.get(circuit2);

        //there will likely be a method for this process but I am writing it here.
        for (int i = 1; i < frontCircuit.size(); i++) {
            if (frontCircuit.get(i) > 10) {
                resistanceA += frontCircuit.get(i);
            }

        }
        for (int i = 1; i < backCircuit.size(); i++) {
            if (backCircuit.get(i) > 10) {
                resistanceB += backCircuit.get(i);
            }

        }

        voltageOut = this.voltage * (resistanceA / (resistanceA + resistanceB));

        return voltageOut;
    }

    /**
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Integer> forTestingCircuit = new ArrayList();
        ArrayList<Integer> forOtherCircuit = new ArrayList();
        ArrayList<ArrayList<Integer>> forTestingParallels = new ArrayList();
        forTestingParallels.add(forTestingCircuit);
        forTestingParallels.add(forOtherCircuit);

        Circuit testCircuit = new Circuit(forTestingCircuit, 10,
                forTestingParallels);
        Circuit otherCircuit = new Circuit(forOtherCircuit, 10,
                forTestingParallels);
        testCircuit.addWire(10);
        testCircuit.addResistor(40, 3);
        testCircuit.addResistor(50, 8);
        otherCircuit.addWire(10);
        otherCircuit.addResistor(50, 3);
        otherCircuit.addResistor(50, 8);
        DecimalFormat numberFormat = new DecimalFormat("#0.00");
        System.out.println("Current over circuit: "
                + numberFormat.format(testCircuit.getTotalCurrent()));

        double voltageOverCircuit = testCircuit.getVoltageOverCircuit(1,
                testCircuit.circuit.size() - 1);
        System.out.println("Voltage Remaining after circuit: "
                + numberFormat.format(voltageOverCircuit));
        //example of how position plays into method
        System.out.println("Voltage after passthrough first resistor: "
                + numberFormat.format(testCircuit.getVoltageOverCircuit(1, 5)));

        double voltageIntoComparator = testCircuit.voltageDivide(0, 1);
        System.out.println("VoltageIn over a voltage divider: "
                + numberFormat.format(voltageIntoComparator));
        //prints out circuit values so you can see circuit
        for (int i = 0; i < testCircuit.circuit.size(); i++) {

            System.out.print(forTestingCircuit.get(i) + " ");

        }
        System.out.println();
        for (int i = 0; i < otherCircuit.circuit.size(); i++) {

            System.out.print(forOtherCircuit.get(i) + " ");

        }

    }
}