package sort;

import collections.ArrayList;

public class QuickSort {

    private QuickSort() {
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        sort(list, 0, list.length() - 1);
    }


    private static <T extends Comparable<T>> void sort(ArrayList<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            sort(list, low, pivotIndex - 1);
            sort(list, pivotIndex + 1, high);
        }
    }


    private static <T extends Comparable<T>> int partition(ArrayList<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(ArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(list.get(j), i);
        list.set(temp, j);
    }
}
