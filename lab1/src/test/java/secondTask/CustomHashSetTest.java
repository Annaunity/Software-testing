package secondTask;

import com.lab1.secondTask.CustomHashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class CustomHashSetTest {
    private static CustomHashSet<Integer> set =new CustomHashSet<Integer>();

    @BeforeEach
    public void fillSet(){
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
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
    }

    @Test
    @DisplayName("remove test")
    public void removeTest(){
        set.remove(1);
        Assertions.assertFalse(set.contains(1));
        set.add(1);
        Assertions.assertTrue(set.contains(1));

    }

    @Test
    @DisplayName("display test")

    public void displayTest(){
        set.remove(4);
        set.remove(5);
        String expected[] = {"1 2 3 ", "1 3 2 ", "2 1 3 ", "2 3 1 ", "3 2 1 ", "3 1 2 "};
        List<String> expectedList = Arrays.asList(expected);
        Assertions.assertTrue(expectedList.contains(set.display()));
    }


}
