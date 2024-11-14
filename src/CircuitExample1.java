import circuit.Circuit1;

public class CircuitExample1 {

    /**
     *
     * @param args
     * @return
     */
    public static void main(String[] args) {

        Circuit1 example = new Circuit1();

        example.addWire(10);

        System.out.print(example.toString());

    }

}
