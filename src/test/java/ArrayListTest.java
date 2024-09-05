import collections.ArrayList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayListTest {

    @Test
    public void TestConstructorWithoutParameter() {
        ArrayList<Object> list = new ArrayList<>(0);
        assertEquals(0, list.length(), "Длина нового списка должна быть 0");
        assertEquals("[]", list.toString(), "Пустой список должен представляться как '[]'");
    }

    @Test
    public void testConstructorWithInitialCapacity() {
        ArrayList<Object> list = new ArrayList<>(100);
        assertEquals(0, list.length(), "Длина нового списка должна быть 0");
        assertEquals("[]", list.toString(), "Пустой список должен представляться как '[]'");
    }

    @Test
    public void testConstructorWithNegativeInitialCapacity() {
        Exception exception = assertThrows(RuntimeException.class, () -> new ArrayList<>(-1));
        {
            assertEquals("Initial capacity cannot be negative", exception.getMessage());
        }
    }

    @Test
    public void testConstructorWithArray() {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ArrayList<Integer> integers = new ArrayList<>(ints);
        assertEquals(10, integers.length(), "Длина списка должна быть 10");
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]", integers.toString());
    }

    @Test
    public void testConstructorWithArrayList() {
        Object[] objects = {new Object(), new Object(), 1, "123"};
        ArrayList<Object> arrayList1 = new ArrayList<>(objects);
        ArrayList<Object> arrayList2 = new ArrayList<>(arrayList1);
        assertEquals(arrayList1.length(), arrayList2.length(), "Длины двух списков должны совпадать");
        assertEquals(arrayList1.toString(), arrayList2.toString(), "Списки должны быть идентичны");
    }

    @Test
    public void testListIterator() {
        Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> integers = new ArrayList<>(ints);
        Iterator<Integer> iterator = integers.iterator();
        assertTrue(iterator.hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(i++, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAdd() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1000, list.length(), "Длина списка должна быть 1000 после добавления 1000 элементов");
    }

//    @Test
//    public void testAddNull() {
//        ArrayList<Object> objects = new ArrayList<>();
//        Exception exception = assertThrows(RuntimeException.class, () -> objects.add(null));
//        assertEquals("Added null", exception.getMessage());
//
//    }

    @Test
    public void testAddWithIndexMid() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        String actual = "String Object";
        int index = objects.length() / 2;
        objects.add(actual, index);
        assertEquals(objects.get(index), actual, "Элемент должен быть добавлен в середину списка");
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
        assertEquals(objects.get(index), actual, "Элемент должен быть добавлен в начало списка");
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
        assertEquals(objects.get(index), actual, "Элемент должен быть добавлен в конец списка");
    }

    @Test
    public void testAddWithIndexIsNegative() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        String actual = "String Object";
        int index = -1;
        Exception exception = assertThrows(RuntimeException.class, () -> objects.add(actual, index));
        assertEquals("Index: " + index + ", Length: " + objects.length(), exception.getMessage());

    }

    @Test
    public void testAddWithIndexIsGreaterLength() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new Object());
        }
        String actual = "String Object";
        int index = objects.length() + 1;  // Индекс, превышающий длину списка

        Exception exception = assertThrows(RuntimeException.class, () -> objects.add(actual, index));

        // Проверка того, что сообщение об ошибке соответствует ожидаемому формату
        assertEquals("Index: " + index + ", Length: " + objects.length(), exception.getMessage());
    }

    @Test
    public void testGet() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        Object actual = objects.get(3);
        assertEquals(3, actual, "Элемент по индексу 3 должен быть равен 3");
    }

    @Test
    public void testGetWithIndexIsNegative() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        int index = -1;
        Exception exception = assertThrows(RuntimeException.class, () -> objects.get(index));
        assertEquals("Index: " + index + ", Length: " + objects.length(), exception.getMessage());
    }

    @Test
    public void testGetWithIndexIsEqualsLength() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        int index = objects.length();
        Exception exception = assertThrows(RuntimeException.class, () -> objects.get(index));
        assertEquals("Index " + index + " out of bounds for length " + objects.length(), exception.getMessage());
    }

    @Test
    public void testGetWithIndexIsGreaterLength() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        int index = objects.length() + 1;
        Exception exception = assertThrows(RuntimeException.class, () -> objects.get(index));
        assertEquals("Index: " + index + ", Length: " + objects.length(), exception.getMessage());
    }

    @Test
    public void testSetMidElement() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        int index = objects.length() / 2;
        String actual = "new String";
        objects.set(actual, index);
        assertEquals(objects.get(index), actual, "Элемент в середине списка должен быть изменён");
    }

    @Test
    public void testSetFirstElement() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        int index = 0;
        String actual = "new String";
        objects.set(actual, index);
        assertEquals(objects.get(index), actual, "Элемент в начале списка должен быть изменён");
    }

    @Test
    public void testSetLastElement() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        int index = objects.length() - 1;
        String actual = "new String";
        objects.set(actual, index);
        assertEquals(objects.get(index), actual, "Элемент в в конце списка должен быть изменён");
    }

//    @Test
//    public void testSetElementToNull() {
//        ArrayList<Object> objects = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            objects.add(i);
//        }
//        int index = 0;
//        Exception exception = assertThrows(RuntimeException.class, () -> objects.set(null, index));
//        assertEquals("Added null", exception.getMessage());
//    }

    @Test
    public void testSetWithIndexIsNegative() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        int index = -1;
        Exception exception = assertThrows(RuntimeException.class, () -> objects.set(null, index));
        assertEquals("Index: " + index + ", Length: " + objects.length(), exception.getMessage());
    }

    @Test
    public void testSetWithIndexIsGreaterLength() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        int index = objects.length() + 1;
        Exception exception = assertThrows(RuntimeException.class, () -> objects.set(null, index));
        assertEquals("Index: " + index + ", Length: " + objects.length(), exception.getMessage());
    }

    @Test
    public void testClear() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        objects.clear();
        assertEquals(0, objects.length(), "Длина нового списка должна быть 0");
        assertEquals("[]", objects.toString(), "Пустой список должен представляться как '[]'");
    }

    @Test
    public void testContainsIsTrue() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        String actual = "String obj";
        objects.add(actual);
        assertTrue(objects.contains(actual), "Объект должен быть найден");
    }

    @Test
    public void testContainsIsFalse() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        String actual = "String obj";
        assertFalse(objects.contains(actual), "Объект не должен быть найден");
    }

//    @Test
//    public void testContainsNull() {
//        ArrayList<Object> objects = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            objects.add(i);
//        }
//        Exception exception = assertThrows(RuntimeException.class, () -> objects.contains(null));
//        assertEquals("Added null", exception.getMessage());
//    }

    @Test
    public void testGetIndexExist() {
        ArrayList<Object> objects = new ArrayList<>();
        String actual = "String obj";
        objects.add(actual);
        assertTrue(objects.getIndex(actual) >= 0, "Индекс не должен быть отрицательным");

    }

    @Test
    public void testGetIndexNotExist() {
        ArrayList<Object> objects = new ArrayList<>();
        String actual = "String obj";
        assertFalse(objects.getIndex(actual) >= 0, "Индекс должен быть отрицательным");
    }

//    @Test
//    public void testGetIndexElementIsNull() {
//        ArrayList<Object> objects = new ArrayList<>();
//        Exception exception = assertThrows(RuntimeException.class, () -> objects.getIndex(null));
//        assertEquals("Added null", exception.getMessage());
//    }

    @Test
    public void testRemoveByElement() {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ArrayList<Integer> integers = new ArrayList<>(ints);
        Integer element = 6;
        integers.remove(element);
        assertEquals(9, integers.length(), "Длина списка должна быть 9");
        assertEquals("[1, 2, 3, 4, 5, 7, 8, 9, 0]", integers.toString());
    }

    @Test
    public void testRemoveByIndex() {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ArrayList<Integer> integers = new ArrayList<>(ints);
        int element = 6;
        integers.remove(element);
        assertEquals(9, integers.length(), "Длина списка должна быть 9");
        assertEquals("[1, 2, 3, 4, 5, 6, 8, 9, 0]", integers.toString());
    }

//    @Test
//    public void testRemoveNull() {
//        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        ArrayList<Integer> integers = new ArrayList<>(ints);
//        Exception exception = assertThrows(RuntimeException.class, () -> integers.remove(null));
//        assertEquals("Added null", exception.getMessage());
//    }

}
