import collections.ArrayList;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayListTest {

    private final Random rnd = new Random();


    @Test
    public void TestConstructorWithoutParameter() {
        ArrayList<Object> list = new ArrayList<>(0);
        assertEquals(0, list.length());
        assertEquals("[]", list.toString());
    }

    @Test
    public void testConstructorWithInitialCapacity() {
        ArrayList<Object> list = new ArrayList<>(100);
        assertEquals(0, list.length());
        assertEquals("[]", list.toString());
    }

    @Test
    public void testConstructorWithNegativeInitialCapacity() {
        try {
            ArrayList<Object> list = new ArrayList<>(-1);
        } catch (RuntimeException e) {
            assertEquals("Initial capacity cannot be negative", e.getMessage());
        }
    }

    @Test
    public void testConstructorWithArray() {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ArrayList<Integer> integers = new ArrayList<>(ints);
        assertEquals(10, integers.length());
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]", integers.toString());
    }

    @Test
    public void testConstructorWithArrayList() {
        Object[] objects = {new Object(), new Object(), 1, "123"};
        ArrayList<Object> arrayList1 = new ArrayList<>(objects);
        ArrayList<Object> arrayList2 = new ArrayList<>(arrayList1);
        assertEquals(arrayList1.length(), arrayList2.length());
        assertEquals(arrayList1.toString(), arrayList2.toString());
    }

    @Test
    public void testAdd() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1000, list.length());
    }

    @Test
    public void testAddNull() {
        ArrayList<Object> objects = new ArrayList<>();
        try {
            objects.add(null);
        } catch (RuntimeException e) {
            assertEquals("Added null", e.getMessage());
        }
    }

    @Test
    public void testAddWithIndexMid() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        String actual = "String Object";
        int index = objects.length() / 2;
        objects.add(actual, index);
        assertEquals(objects.get(index), actual);

        try {
            index = -1;
            objects.add(actual, index);
            assertEquals(objects.get(index), actual);
        } catch (RuntimeException e) {
            assertEquals("Index: " + index + ", Length: " + objects.length(), e.getMessage());
        }

        try {
            index = objects.length() + 1;
            objects.add(actual, index);
            assertEquals(objects.get(index), actual);
        } catch (RuntimeException e) {
            assertEquals("Index: " + index + ", Length: " + objects.length(), e.getMessage());
        }

    }

    @Test
    public void testAddWithIndexZero() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        String actual = "String Object";
        int index = 0;
        objects.add(actual, index);
        assertEquals(objects.get(index), actual);
    }

    @Test
    public void testAddWithIndexLength() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        String actual = "String Object";
        int index = objects.length();
        objects.add(actual, index);
        assertEquals(objects.get(index), actual);
    }

    @Test
    public void testAddWithIndexIsNegative() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        String actual = "String Object";
        int index = -1;
        try {
            objects.add(actual, index);
        } catch (RuntimeException e) {
            assertEquals("Index: " + index + ", Length: " + objects.length(), e.getMessage());
        }

    }

    @Test
    public void testAddWithIndexIsGreaterLength() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        String actual = "String Object";
        int index = objects.length()+1;
        try {
            objects.add(actual, index);
        } catch (RuntimeException e) {
            assertEquals("Index: " + index + ", Length: " + objects.length(), e.getMessage());
        }

    }
}
