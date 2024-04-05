package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Cos {
    private final Sin s;

    public Cos(Sin s) {
        this.s = s;
    }

    public double solve(double value, double epsilon) {
        var x = Sin.moveValueToZeroNPiPi(Math.abs(value));
        if (Double.isNaN(x)) {
            return x;
        }
        return getCos(x, epsilon);
    }

    private double getCos(double value, double epsilon) {
        var sin = s.solve(value, epsilon);
        var cos = Math.sqrt(1 - sin * sin);
        if (Math.abs(value) > Math.PI / 2) {
            cos *= -1;
        }
        return cos;
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
