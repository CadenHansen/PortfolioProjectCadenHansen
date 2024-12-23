import java.text.DecimalFormat;
import java.util.Scanner;

import components.circuit.ArrayCircuit;

/**
 * This class exhibits the standard utility of the circuit class. I put together
 * a few circuits and display what Circuit allows you to do.
 */
public final class CircuitExampleStandardTypes {

        /**
         * Default constructor to prevent instanciation.
         */
        private CircuitExampleStandardTypes() {

        }

        /**
         * @param args
         *
         *                main method.
         */
        public static void main(String[] args) {

                Scanner in = new Scanner(System.in);
                ArrayCircuit x = new ArrayCircuit(6, 10);
                ArrayCircuit y = new ArrayCircuit(12, 10);
                ArrayCircuit users = new ArrayCircuit();
                DecimalFormat df = new DecimalFormat("0.000");

                x.addResistor(5, 80);
                y.addResistor(5, 100);

                System.out.println("Here are some examples of Circuits");
                System.out.println("Circuit x: " + x.toString());
                System.out.println("Circuit y: " + y.toString());
                //Zero because only resistor consumes all of the voltage
                System.out.println("Circuit x voltage after  Resistor: "
                                + (x.getStarterVoltage() - x.getVoltage(5, 7)));
                System.out.println(
                                "When put through a Comparator the output is: "
                                                + x.emulateComparator(x, y, 12,
                                                                8));
                System.out.println("When put through a voltage divider: "
                                + df.format(x.voltageDivide(x, y)));
                System.out.println("Now its your turn to make a Circuit");
                System.out.print(
                                "Please Enter a (Using same voltage as Y demonstrates assertion error): ");
                String volts = in.nextLine();
                int voltValue = Integer.parseInt(volts);
                users = new ArrayCircuit(voltValue);
                System.out.print("Please Enter a wire count: ");
                String wireC = in.nextLine();
                users.addWire(Integer.parseInt(wireC));
                System.out.print(
                                "Please Enter a resister value (greater than 50): ");
                String rA = in.nextLine();
                int resistA = Integer.parseInt(rA);

                System.out.print(
                                "Please Enter a Location for your Resistor (within wire count): ");
                String rLoc = in.nextLine();
                int rALocation = Integer.parseInt(rLoc);
                users.addResistor(rALocation, resistA);
                System.out.print(
                                "Please Enter a second Resistor value (greater than 50): ");
                String rB = in.nextLine();
                int resistB = Integer.parseInt(rB);
                System.out.print(
                                "Please Enter a Location for your Resistor (within wire count, after first resistor): ");
                String rLocB = in.nextLine();
                int rBLocation = Integer.parseInt(rLocB);
                users.addResistor(rBLocation, resistB);
                System.out.println("Your Circuit: " + users.toString());
                System.out.println(
                                "Your Circuit voltage after going through 1 resistor (shows voltage drop): "
                                                + users.getVoltage(0, rALocation
                                                                + 1));
                System.out.println(
                                "When put through a Comparator with circuit y output is: "
                                                + users.emulateComparator(users,
                                                                y, 12, 8));
                System.out.println(
                                "When put through a voltage divider with circuit y: "
                                                + df.format(x.voltageDivide(
                                                                users, y)));

        }

}
