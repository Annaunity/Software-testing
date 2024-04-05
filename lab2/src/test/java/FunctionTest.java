import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.example.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;


public class FunctionTest {
    static double epsilon = 0.01;


    static Sin sinMock;
    static Cos cosMock;
    static Cot cotMock;
    static Csc cscMock;
    static Ln lnMock;
    static Log logMock;

    static Reader sinIn;
    static Reader cosIn;
    static Reader cotIn;
    static Reader cscIn;
    static Reader lnIn;
    static Reader log2In;
    static Reader log3In;
    static Reader log5In;
    static Reader log10In;

    static FileWriter funcOut;
    static CSVPrinter funcPrinter;

    @BeforeAll
    static void init() {
        sinMock = Mockito.mock(Sin.class);
        cosMock = Mockito.mock(Cos.class);
        cotMock = Mockito.mock(Cot.class);
        cscMock = Mockito.mock(Csc.class);
        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);


        try {
            funcOut = new FileWriter("/Users/aleksandra/IdeaProjects/testing2/src/test/resources/out/func.csv");
            funcPrinter = CSVFormat.DEFAULT.print(funcOut);

            sinIn = new FileReader("src/test/resources/in/sin.csv");
            cosIn = new FileReader("src/test/resources/in/cos.csv");
            cotIn = new FileReader("src/test/resources/in/cot.csv");
            cscIn = new FileReader("src/test/resources/in/csc.csv");

            lnIn = new FileReader("src/test/resources/in/ln.csv");
            log2In = new FileReader("src/test/resources/in/log2.csv");
            log3In = new FileReader("src/test/resources/in/log3.csv");
            log5In = new FileReader("src/test/resources/in/log5.csv");
            log10In = new FileReader("src/test/resources/in/log10.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record : records) {
                Mockito.when(sinMock.solve(Double.parseDouble(record.get(0)), epsilon)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cosIn);
            for (CSVRecord record : records) {
                Mockito.when(cosMock.solve(Double.parseDouble(record.get(0)), epsilon)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cotIn);
            for (CSVRecord record : records) {
                Mockito.when(cotMock.solve(Double.parseDouble(record.get(0)), epsilon)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cscIn);
            for (CSVRecord record : records) {
                Mockito.when(cscMock.solve(Double.parseDouble(record.get(0)), epsilon)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.solve(Double.parseDouble(record.get(0)), epsilon)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.solve(Double.parseDouble(record.get(0)), epsilon, 2)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.solve(Double.parseDouble(record.get(0)), epsilon, 3)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.solve(Double.parseDouble(record.get(0)), epsilon, 5)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log10In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.solve(Double.parseDouble(record.get(0)), epsilon, 10)).thenReturn(Double.valueOf(record.get(1)));
            }

        } catch (IOException e) {
            System.err.println("Error when reading or creating csv files " + e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test with mocks")
    void testWithMocks(double value, double expected) {
        Function function = new Function(sinMock, cosMock, cotMock, cscMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin and mocks")
    void testWithSin(double value, double expected) {
        Function function = new Function(new Sin(), cosMock, cotMock, cscMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos and mocks")
    void testWithSinCos(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(sinMock), cotMock, cscMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos, sin and mocks")
    void testWithSinCosSin(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), cotMock, cscMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos, sin cot and mocks")
    void testWithSinCosSinCot(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), new Cot(sinMock, cosMock), cscMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos, sin cot, sin and mocks")
    void testWithSinCosSinCotSin(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), new Cot(new Sin(), cosMock), cscMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos, sin cot, sin, cos, sin and mocks")
    void testWithSinCosSinCotSinCosSin(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), new Cot(new Sin(), new Cos(new Sin())), cscMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos, sin cot, sin, cos, sin csc and mocks")
    void testWithSinCosSinCotSinCosSinCsc(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), new Cot(new Sin(), new Cos(new Sin())), new Csc(sinMock), logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos, sin cot, sin, cos, sin csc, sin and mocks")
    void testWithSinCosSinCotSinCosSinCscSin(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), new Cot(new Sin(), new Cos(new Sin())), new Csc(new Sin()), logMock);
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos, sin cot, sin, cos, sin csc, sin log and mocks")
    void testWithSinCosSinCotSinCosSinCscSinLog(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), new Cot(new Sin(), new Cos(new Sin())), new Csc(new Sin()), new Log(lnMock));
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    @DisplayName("test sin cos, sin cot, sin, cos, sin csc, sin log and mocks")
    void testWithSinCosSinCotSinCosSinCscSinLogLn(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), new Cot(new Sin(), new Cos(new Sin())), new Csc(new Sin()), new Log(new Ln()));
        Assertions.assertEquals(expected, function.solve(value, epsilon), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "in/func.csv")
    void testSystemWithMocks(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(new Sin()), new Cot(new Sin(), new Cos(new Sin())), new Csc(new Sin()), new Log(new Ln()));
        Assertions.assertEquals(expected, function.writeResultToCSV(value, epsilon, funcPrinter), epsilon);
    }

    @AfterAll
    static void closeCsv() {
        try {
            funcOut.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}


