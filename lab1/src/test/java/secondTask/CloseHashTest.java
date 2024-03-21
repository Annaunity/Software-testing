package secondTask;

import com.lab1.secondTask.CloseHash;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Random;

public class CloseHashTest {
    private static CloseHash set;
    private final Random random = new Random();

    @BeforeEach
    public void fillSet(){
        set = new CloseHash(4);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(12);
        set.add(5);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(1);
    }
    @Test
    @DisplayName("simple test")
    public void simpleTest(){
        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertTrue(set.contains(3));
        Assertions.assertTrue(set.contains(4));
        Assertions.assertTrue(set.contains(5));
        Assertions.assertFalse(set.contains(6));
        Assertions.assertTrue(set.contains(12));
        Assertions.assertFalse(set.contains(-1));
    }

    @Test
    @DisplayName("remove test")
    public void removeTest(){
        set.delete(1);
        Assertions.assertTrue(set.contains(1));
        set.delete(1);
        Assertions.assertFalse(set.contains(1));
        set.add(1);
        Assertions.assertTrue(set.contains(1));
    }

    @DisplayName("random test")
    @RepeatedTest(value = 5)
    public void randomTest() {
        var values = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            var value = random.nextInt();
            set.add(value);
            values.add(value);
        }

        for (var v: values) {
            Assertions.assertTrue(set.contains(v));
            Assertions.assertTrue(set.delete(v));
        }
    }
}

