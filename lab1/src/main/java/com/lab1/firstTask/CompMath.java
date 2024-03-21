package com.lab1.firstTask;

public class CompMath {
    private static final double PI = 3.14159265359;

    public static double cos(double value) {
        if (Double.isNaN(value)) {
            return Double.NaN;
        }

        value = Math.abs(value);
        if (value > PI || value < 0.0) {
            long t = (long) (value / PI);
            value = value - PI * t ;
            value += (t % 2 == 0 ? 0 : PI);

        }

        double cos = 0;
        double epsilon = 0.001;
        double x = Math.abs(value);
        double prev;

        long twoKFact = 1;
        int k = 0;

        while (true) {
            prev = cos;
            cos += Math.pow(-1, k % 2) * Math.pow(x, 2 * k) / (twoKFact);


            twoKFact *= (2L * k + 1) * (2L * k + 2);
            k++;

            if (Math.abs(cos - prev) < epsilon) {
                break;
            }
        }

        return cos;
    }

}
