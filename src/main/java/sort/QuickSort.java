package sort;

import collections.ArrayList;

import java.util.Comparator;

public class QuickSort {

    private QuickSort() {
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        sort(list, 0, list.length() - 1);
    }


    private static <T extends Comparable<T>> void sort(ArrayList<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high); // центр
            sort(list, low, pivotIndex - 1); // левый край
            sort(list, pivotIndex + 1, high); // правый край
        }
    }


    private static <T extends Comparable<T>> int partition(ArrayList<T> list, int low, int high) {
        T pivot = list.get(high); // опора
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

    public static <T> void sort(ArrayList<T> list, Comparator<T> comparator) {
        sort(list, 0, list.length() -1, comparator);
    }

    private static <T> void sort(ArrayList<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator); // центр
            sort(list, low, pivotIndex - 1,comparator); // левый край
            sort(list, pivotIndex + 1, high,comparator); // правый край
        }
    }

    private static <T> int partition(ArrayList<T> list, int low, int high, Comparator<T> comparator) {
        T pivot = list.get(high); // опора
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
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
