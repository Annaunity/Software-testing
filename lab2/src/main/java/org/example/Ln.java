package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Ln {
    public double solve(double value, double epsilon) {
        if (Double.isNaN(value) || value < (double) 0) {
            return Double.NaN;
        } else if (value == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (value == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }

        return getLn(value, epsilon);
    }

    private double getLn(double value, double epsilon) {
        double constant = ((value - 1) * (value - 1)) / ((value + 1) * (value + 1));
        double ln = 0.0;
        double current = (value - 1) / (value + 1);
        var k = 1L;

        while (true) {
            ln += current;
            current = (2 * k - 1) * current * constant / (2 * k + 1);
            k++;

            if (Math.abs(current) < epsilon / value / 10000 || k > 1000) {
                break;
            }
        }

        return ln * 2;
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
