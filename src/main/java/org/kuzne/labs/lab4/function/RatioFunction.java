package org.kuzne.labs.lab4.function;

public class RatioFunction implements Function {

    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double boundStart;
    private final double boundEnd;

    public RatioFunction(double a, double b, double c, double d, double boundStart, double boundEnd) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.boundStart = boundStart;
        this.boundEnd = boundEnd;
    }

    @Override
    public double calculate(double x) {
        if (!(x >= boundStart && x <= boundEnd)) {
            throw new IllegalArgumentException(String.format("Argument is out of bound [%f:%f]", boundStart, boundEnd));
        }
        return Math.round(((a * x + b) / (c * x + d))*100.0)/100.0;
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
