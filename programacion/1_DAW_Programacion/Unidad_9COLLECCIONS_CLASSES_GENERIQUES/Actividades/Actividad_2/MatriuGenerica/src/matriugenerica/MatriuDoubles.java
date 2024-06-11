
package matriugenerica;


import java.util.Random;
public class MatriuDoubles extends MatriuGenerica<Double> {
     public MatriuDoubles(int tamany) {
        super(tamany);
    }

    @Override
    public Double suma(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double multiplicacio(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double zero() {
        return 0.0;
    }

    @Override
    public Double aleatori() {
        Random random = new Random();
        return Math.round(random.nextDouble(10) * 10.0) / 10.0;
    }
}
