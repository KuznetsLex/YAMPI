package org.kuzne.labs.lab4.function;

public class SineFunction implements Function {

    private final double a;
    private final double b;
    private final double boundStart;
    private final double boundEnd;

    public SineFunction(double a, double b, double boundStart, double boundEnd) {
        this.a = a;
        this.b = b;
        this.boundStart = boundStart;
        this.boundEnd = boundEnd;
    }

    @Override
    public double calculate(double x) {
        if (!(x >= boundStart && x <= boundEnd)) {
            throw new IllegalArgumentException(String.format("Argument is out of bound [%f:%f]", boundStart, boundEnd));
        }
        return Math.round((a * Math.sin(b * x))*100.0)/100.0;
    }

    @Override
    public double getBoundStart() {
        return boundStart;
    }

    @Override
    public double getBoundEnd() {
        return boundEnd;
    }
}
