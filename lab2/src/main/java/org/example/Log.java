package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Log {
    private final Ln l;

    public Log(Ln l) {
        this.l = l;
    }

    public double solve(double value, double epsilon, int base) {
        return log_aB(value, base, epsilon);
    }

    public double log_aB(double a, double b, double epsilon) {
        return l.solve(a, epsilon) / l.solve(b, epsilon);
    }

    public double writeResultToCSV(double x, double eps, int base, CSVPrinter printer) {
        double res = solve(x, eps, base);
        try {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }
}
