package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Sin {
    public double solve(double value, double epsilon) {
        var x = moveValueToZeroNPiPi(Math.abs(value));
        if (Double.isNaN(x)) {
            return x;
        }

        var sin = getSin(x, epsilon);
        if (value < 0) {
            sin *= -1;
        }

        return sin;
    }

    private double getSin(double value, double epsilon) {
        var sin = value;
        var k = 1L;
        double prev;

        var kFact = 6L;
        var kPow = Math.pow(value, 3);

        while (true) {
            prev = sin;
            sin += Math.pow(-1, k % 2) * kPow / kFact;

            k++;
            kPow *= value * value;
            kFact *= (2L * k) * (2L * k + 1);

            if (Math.abs(sin - prev) < epsilon / 10) {
                break;
            }
        }

        return sin;
    }
    public static double moveValueToZeroNPiPi(double value) {
        if (Double.POSITIVE_INFINITY == value || Double.NEGATIVE_INFINITY == value || Double.isNaN(value)) {
            return Double.NaN;
        }

        value = Math.abs(value);
        if (value > 2 * Math.PI || value < 0.0) {
            var t = (long) (value / (2 * Math.PI));
            value = value - 2 * Math.PI * t;
        }

        if (value > Math.PI) {
            value -= 2*Math.PI;
        }

        return value;
    }
    public double writeResultToCSV(double x, double eps, CSVPrinter printer) {
        double res = solve(x, eps);
        try {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }
}
