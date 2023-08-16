package ait.integral.task;

import java.util.function.Function;

public class SumRectangles implements Runnable {
    double a;
    double b;
    Function<Double, Double> func;
    int nParts;
    int nTasks;
    int id;
    double delta;
    double result;

    public SumRectangles(double a, double b, Function<Double, Double> func, int nParts, int nTasks, int id) {
        this.a = a;
        this.b = b;
        this.func = func;
        this.nParts = nParts;
        this.nTasks = nTasks;
        this.id = id;
        delta = (b - a) / nParts;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = id; i < nParts; i += nTasks) {
            double l = a + i * delta;
            double r = l + delta;
            double mid = (l + r) / 2;
            result += func.apply(mid) * delta;
        }
    }
}
