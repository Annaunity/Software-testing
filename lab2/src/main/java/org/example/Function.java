package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Function {
    private final Sin sin;
    private final Cos cos;
    private final Cot cot;
    private final Csc csc;
    private final Log lo;

    public Function(Sin sin, Cos cos, Cot cot, Csc csc, Log lo) {
        this.sin = sin;
        this.cos = cos;
        this.cot = cot;
        this.csc = csc;
        this.lo = lo;
    }

    public double solve(double value, double epsilon) {
        if (value == 0) {
            return Double.NEGATIVE_INFINITY;
        }

        if (value <= 0) {
            return Math.pow(cot.solve(value, epsilon) * sin.solve(value, epsilon) * csc.solve(value, epsilon), 3) + sin.solve(value, epsilon);
        }

        return (Math.pow(lo.solve(value, epsilon, 3), 3)
                - lo.solve(value, epsilon, 3)
                + lo.solve(value, epsilon, 5))
                * lo.solve(value, epsilon, 2)
                * lo.solve(value, epsilon, 10);
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
