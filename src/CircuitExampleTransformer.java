import java.text.DecimalFormat;
import java.util.Scanner;

import circuit.ArrayCircuit;

/**
 * This exmample use case shows how a circuit object can be modified to
 * implement two transformer types. Those being the transformer that takes power
 * from a factory and "steps it up" in order to travel long distances over power
 * lines, and the transformer that steps it down for house and business use.
 */
public final class CircuitExampleTransformer {

    /**
     * No Args Constructor to prevent instanciation.
     */
    private CircuitExampleTransformer() {

    }

    /**
     *
     * @param x
     *            Circuit for stepUp
     *
     * @return voltage after a Step-Up
     */
    public static int stepUp(ArrayCircuit x) {

        //these values are standard for Step-Up transformers
        int primaryLoopCoil = 50;
        int secondayLoopCoil = 417000;

        //Power is maintained over a step-up so its a simple ratio conversion
        int voltageChange = (secondayLoopCoil / primaryLoopCoil)
                * x.getStarterVoltage();

        x.setObject(0, voltageChange);

        return voltageChange;

    }

    /**
     *
     * @param x
     *            Circuit for stepDown
     * @return voltage after stepDown
     */
    public static int stepDown(ArrayCircuit x, int initialVoltage) {

        //these values are standard for Step-Down transformers
        double primaryLoopCoil = 200;
        double secondayLoopCoil = 25;

        //Power is maintained so its a simple ratio conversion
        double voltageChange = (secondayLoopCoil / primaryLoopCoil)
                * initialVoltage;

        x.setObject(0, (int) voltageChange);

        return (int) voltageChange;

    }

    /**
     *
     * Main Method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.print("Please Enter a starting voltage: ");
        String volts = in.nextLine();
        int sVolt = Integer.parseInt(volts);

        ArrayCircuit powerLine = new ArrayCircuit(sVolt);

        powerLine.addWire(20);
        powerLine.addResistor(1, 10000);

        System.out.println("Circuit Before a Step-Up: ");
        System.out.println("Voltage = " + powerLine.getStarterVoltage());
        System.out
                .println("Current = " + df.format(powerLine.getTotalCurrent()));

        int newVoltage = stepUp(powerLine);

        System.out.println("\nCircuit After a Step-Up: ");
        System.out.println("Voltage = " + newVoltage);
        /**
         * The current is going to be very low, this is because power lines
         * minimize lost power by having a low current
         */
        System.out
                .println("Current = " + df.format(powerLine.getTotalCurrent()));

        int finalVoltage = stepDown(powerLine, sVolt);

        System.out.println("\nCircuit After a Step-Down: ");
        System.out.println("Voltage = " + finalVoltage);
        //current returns back to where it was
        System.out.println("Current = " + powerLine.getTotalCurrent());

        in.close();
    }
}
