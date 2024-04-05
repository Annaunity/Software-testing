package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Csc {
    private final Sin s;

    public Csc(Sin s) {
        this.s = s;
    }

    public double solve(double value, double epsilon) {
        var x = Sin.moveValueToZeroNPiPi(value);
        if (Double.isNaN(x) || x == 0.0 || Math.abs(x) == Math.PI) {
            return Double.NaN;
        }

        return getCsc(value, epsilon);
    }

    private double getCsc(double value, double epsilon) {
        return 1 / s.solve(value, epsilon);
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
