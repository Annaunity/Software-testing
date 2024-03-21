package firstTask;

import com.lab1.firstTask.CompMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CompMathTest {
    private final double epsilon = 0.01;

    @ParameterizedTest
    @ValueSource(doubles = {-1.1, -10.0})
    @DisplayName("check negative values")
    public void checkNegativeValues(double value) {
        Assertions.assertEquals(Math.cos(value), CompMath.cos(value), epsilon);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.1, 10.0})
    @DisplayName("check positive values")
    public void checkPositiveValues(double value) {
        Assertions.assertEquals(Math.cos(value), CompMath.cos(value), epsilon);
    }

    @Test
    @DisplayName("check from -PI to PI")
    public void checkPItoPI(){
        Assertions.assertEquals(Math.cos(Math.PI), CompMath.cos(Math.PI), epsilon);
        Assertions.assertEquals(Math.cos(-Math.PI), CompMath.cos(-Math.PI), epsilon);
        Assertions.assertEquals(Math.cos(0), CompMath.cos(0), epsilon);
        Assertions.assertEquals(Math.cos(Math.PI - 0.001), CompMath.cos(Math.PI-0.001), epsilon);
        Assertions.assertEquals(Math.cos(Math.PI + 0.001), CompMath.cos(Math.PI+0.001), epsilon);
        Assertions.assertEquals(Math.cos(-Math.PI + 0.001), CompMath.cos(-Math.PI+0.001), epsilon);
        Assertions.assertEquals(Math.cos(-Math.PI - 0.001), CompMath.cos(-Math.PI-0.001), epsilon);
        Assertions.assertEquals(Math.cos(0 + 0.001), CompMath.cos(0+0.001), epsilon);
        Assertions.assertEquals(Math.cos(0 - 0.001), CompMath.cos(0-0.001), epsilon);
    }

    @Test
    @DisplayName("check NaN")
    public void checkNaN(){
        Assertions.assertEquals(Math.cos(Double.NaN), CompMath.cos(Double.NaN), epsilon);
    }

    @Test
    @DisplayName("check big values")
    public void checkBigValues(){
        Assertions.assertEquals(-0.39061864302, CompMath.cos(-10389712837.0), epsilon);
        Assertions.assertEquals(0.99450920542, CompMath.cos(-10389712810.0), epsilon);
    }
}

