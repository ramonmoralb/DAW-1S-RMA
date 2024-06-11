package matriugenerica;

import java.util.Random;

public class MatriuEnters extends MatriuGenerica<Integer> {

    public MatriuEnters(int tamany) {
        super(tamany);
    }

    @Override
    public Integer suma(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer multiplicacio(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer zero() {
        return 0;
    }

    @Override
    public Integer aleatori() {
        Random random = new Random();
        return random.nextInt(10);
    }
}