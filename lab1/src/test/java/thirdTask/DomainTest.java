package thirdTask;

import com.lab1.thirdTask.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DomainTest {
    static Location room;
    static Location betelgeuse;

    static Item bottle;
    static Item underwear;
    static Item mattress;
    static Item cornflakes;

    static Fish fish;
    static Human ford;
    static Human arthur;

    @BeforeAll
    public static void initialize() {
        fish = new Fish("small fish", null, "yellow");
        mattress = new Item("skvornshelsky mattresses");
        underwear = new Item("dentrassi underwear");
        cornflakes = new Item("a bag of cornflakes");

        bottle = new Item("glass bottle", fish);
        ford = new Human("Ford", new Dream("stick a fish in ear"));
        arthur = new Human("Arthur", new Dream("see the cornflakes"));

        betelgeuse = new Location("Betelgeuse star", null, null);

        room = new Location("Just room",
                Arrays.asList(ford, arthur),
                Arrays.asList(mattress, underwear, cornflakes));

        ford.setItemOnHand(bottle);
    }

    @Test
    @DisplayName("check items")
    public void checkItems() {
        Assertions.assertEquals("skvornshelsky mattresses", mattress.getName());
        Assertions.assertNull(mattress.getCreatureInItem());

        Assertions.assertEquals( "dentrassi underwear", underwear.getName());
        Assertions.assertNull(underwear.getCreatureInItem());

        Assertions.assertEquals( "a bag of cornflakes", cornflakes.getName());
        Assertions.assertNull(cornflakes.getCreatureInItem());

        Assertions.assertEquals( "glass bottle", bottle.getName());
        Assertions.assertEquals(bottle.getCreatureInItem(), fish);
    }

    @Test
    @DisplayName("check location")
    public void checkLocation() {
        Assertions.assertEquals( "Betelgeuse star", betelgeuse.getName());
        Assertions.assertEquals(new ArrayList<>(), betelgeuse.getCreatureList());
        Assertions.assertEquals( new ArrayList<>(), betelgeuse.getItemsList());

        Assertions.assertEquals( "Just room", room.getName());
        Assertions.assertNotNull(room.getCreatureList());
        Assertions.assertEquals( Arrays.asList(mattress, underwear, cornflakes), room.getItemsList());

        betelgeuse.addCreature(fish);
        betelgeuse.addItem(underwear);

        Assertions.assertEquals( 1, betelgeuse.getCreatureList().size());
        Assertions.assertEquals( 1, betelgeuse.getItemsList().size());
    }

    @Test
    @DisplayName("check blinking")
    public void checkBlinking() {
        ford.blink();
        ford.blink();
        ford.blink();

        arthur.blink();
        arthur.blink();
        arthur.blink();

        Assertions.assertEquals(ford.getBlinkCounter(), arthur.getBlinkCounter());
        arthur.blink();
        Assertions.assertNotEquals(ford.getBlinkCounter(), arthur.getBlinkCounter());
    }

    @Test
    @DisplayName("check dreams")
    public void checkDreams() {
        System.out.println(ford.getDream().getDescription());
        Assertions.assertEquals(ford.getDream(), new Dream("stick a fish in ear"));
        ford.dreamComeTrue();
        Assertions.assertNotEquals(ford.getDream(), new Dream("stick a fish in ear"));
        Assertions.assertEquals(ford.getDream(), new Dream(Creature.NO_DREAM_TEXT));
    }

    @Test
    @DisplayName("check fish color")
    public void checkFishColor() {
        Assertions.assertEquals( "yellow", fish.getColor());
        fish.changeColor("red");
        Assertions.assertEquals( "red", fish.getColor());
    }

    @Test
    @DisplayName("check backpack and hand")
    public void checkBackPackAndHand() {
        Assertions.assertEquals(ford.getItemOnHand(), bottle);
        Assertions.assertEquals( 4, ford.getBackpack().getCapacity());
        Assertions.assertNull(ford.getBackpack().getFromBackpack(1));

        ford.addItemToBackpack(underwear);
        Assertions.assertEquals( 3, ford.getBackpack().getCapacity());
        Assertions.assertEquals(ford.getBackpack().getFromBackpack(1), underwear);


        ford.addItemToBackpack(bottle);
        Assertions.assertEquals( 3, ford.getBackpack().getCapacity());
        Assertions.assertEquals(ford.getBackpack().getFromBackpack(1), bottle);
        Assertions.assertNull(ford.getBackpack().getFromBackpack(2));
        Assertions.assertNull(ford.getItemOnHand());
    }


    @Test
    @DisplayName("check exception")
    public void checkException() {
        arthur.addItemToBackpack(underwear);
        Assertions.assertEquals( 3, arthur.getBackpack().getCapacity());
        arthur.addItemToBackpack(bottle);
        Assertions.assertEquals( 2, arthur.getBackpack().getCapacity());
        arthur.addItemToBackpack(bottle);
        Assertions.assertEquals(1, arthur.getBackpack().getCapacity());
        arthur.addItemToBackpack(bottle);
        Assertions.assertEquals( 0, arthur.getBackpack().getCapacity());

        var exception = Assertions.assertThrowsExactly(BackpackIsFullException.class, () -> {arthur.addItemToBackpack(bottle);});
        Assertions.assertTrue(exception.getMessage().contains("backpack is full"));
    }

}
