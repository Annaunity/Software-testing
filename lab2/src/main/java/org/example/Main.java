package org.example;

public class Main {
    public static void main(String[] args) {
        var sin = new Sin();
        var cos = new Cos(sin);
        var cot = new Cot(sin, cos);
        var csc = new Csc(sin);
        var ln = new Ln();
        var log = new Log(ln);
        var fun = new Function(sin, cos, cot, csc, log);
        var e = 0.0001;

        System.out.println(fun.solve(0.1, e));
        System.out.println(log.solve(0.1, e, 2));
        System.out.println(log.solve(0.1, e, 3));
        System.out.println(log.solve(0.1, e, 5));
        System.out.println(log.solve(0.1, e, 10));

    }
}