
import collections.ArrayList;
import sort.QuickSort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int count = 10;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Random().nextInt());
        }
        list.forEach(System.out::println);
        System.out.println();
        QuickSort.sort(list, (o1, o2) -> Integer.compare(o2,o1));
        list.forEach(System.out::println);
    }
}
