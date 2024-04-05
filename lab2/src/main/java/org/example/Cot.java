package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Cot {
    private final Sin s;
    private final Cos c;

    public Cot(Sin s, Cos c) {
        this.s = s;
        this.c = c;
    }

    public double solve(double value, double epsilon) {
        var x = Sin.moveValueToZeroNPiPi(value);
        if (Double.isNaN(x) || x == 0.0 || Math.abs(x) == Math.PI) {
            return Double.NaN;
        }

        return getCot(value, epsilon);
    }

    private double getCot(double value, double epsilon) {
        return c.solve(value, epsilon) / s.solve(value, epsilon);
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
