import collections.ArrayList;
import org.junit.jupiter.api.Test;
import sort.QuickSort;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    private final Integer[] integers = {1, 3, 4, 12, 23, 4, 1, 2, 5, -5, 234, -46, 0};

    @Test
    public void testSortWithoutComparator() {
        ArrayList<Integer> list = new ArrayList<>(integers);
        QuickSort.sort(list);
        assertEquals("[-46, -5, 0, 1, 1, 2, 3, 4, 4, 5, 12, 23, 234]", list.toString());
    }

    @Test
    public void testSortWithComparator() {
        ArrayList<Integer> list = new ArrayList<>(integers);
        QuickSort.sort(list, (o1, o2) -> Integer.compare(o2, o1));
        System.out.println(list);
        assertEquals("[234, 23, 12, 5, 4, 4, 3, 2, 1, 1, 0, -5, -46]", list.toString());
    }
}
