import collections.ArrayList;
import customclasses.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayListTest {

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
        Object[] objects = {new Object(), new Object(), new Person("Person", 18)};
        ArrayList<Object> arrayList1 = new ArrayList<>(objects);
        ArrayList<Object> arrayList2 = new ArrayList<>(arrayList1);
        assertEquals(arrayList1.length(), arrayList2.length());
        assertEquals(arrayList1.toString(), arrayList2.toString());
    }

    @Test
    public void testAdd() {

    }
}
