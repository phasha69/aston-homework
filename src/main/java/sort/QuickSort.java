package sort;

import collections.ArrayList;

import java.util.Comparator;

/**
 * Класс для реализации алгоритма быстрой сортировки (QuickSort).
 * <p>
 * Этот класс содержит методы для сортировки коллекций с использованием
 * алгоритма быстрой сортировки как на основе интерфейса {@link Comparable}, так и с
 * использованием {@link Comparator}.
 */
public class QuickSort {

    /**
     * Приватный конструктор для предотвращения создания экземпляров этого класса.
     * Этот класс является утилитарным и предназначен только для статического использования.
     */
    private QuickSort() {
    }

    /**
     * Сортирует список, используя алгоритм быстрой сортировки и интерфейс {@link Comparable}.
     *
     * @param list список, который нужно отсортировать
     * @param <T> тип элементов списка, который должен реализовывать интерфейс {@link Comparable}
     */
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        sort(list, 0, list.length() - 1);
    }

    /**
     * Рекурсивный метод, который выполняет быструю сортировку на основе {@link Comparable}.
     *
     * @param list список, который нужно отсортировать
     * @param low начальный индекс подмассива, который нужно отсортировать
     * @param high конечный индекс подмассива, который нужно отсортировать
     * @param <T> тип элементов списка, который должен реализовывать интерфейс {@link Comparable}
     */
    private static <T extends Comparable<T>> void sort(ArrayList<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            sort(list, low, pivotIndex - 1);
            sort(list, pivotIndex + 1, high);
        }
    }

    /**
     * Метод, который выполняет разбиение списка на части на основе {@link Comparable}.
     *
     * @param list список, который нужно разделить
     * @param low начальный индекс подмассива
     * @param high конечный индекс подмассива
     * @param <T> тип элементов списка, который должен реализовывать интерфейс {@link Comparable}
     * @return индекс опорного элемента после разбиения
     */
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

    /**
     * Сортирует список, используя алгоритм быстрой сортировки и переданный компаратор {@link Comparator}.
     *
     * @param list список, который нужно отсортировать
     * @param comparator компаратор для сравнения элементов списка
     * @param <T> тип элементов списка
     */
    public static <T> void sort(ArrayList<T> list, Comparator<T> comparator) {
        sort(list, 0, list.length() - 1, comparator);
    }

    /**
     * Рекурсивный метод, который выполняет быструю сортировку на основе переданного компаратора {@link Comparator}.
     *
     * @param list список, который нужно отсортировать
     * @param low начальный индекс подмассива, который нужно отсортировать
     * @param high конечный индекс подмассива, который нужно отсортировать
     * @param comparator компаратор для сравнения элементов списка
     * @param <T> тип элементов списка
     */
    private static <T> void sort(ArrayList<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            sort(list, low, pivotIndex - 1, comparator);
            sort(list, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Метод, который выполняет разбиение списка на части на основе переданного компаратора {@link Comparator}.
     *
     * @param list список, который нужно разделить
     * @param low начальный индекс подмассива
     * @param high конечный индекс подмассива
     * @param comparator компаратор для сравнения элементов списка
     * @param <T> тип элементов списка
     * @return индекс опорного элемента после разбиения
     */
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

    /**
     * Метод для обмена двух элементов в списке.
     *
     * @param list список, в котором нужно обменять элементы
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     * @param <T> тип элементов списка
     */
    private static <T> void swap(ArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(list.get(j), i);
        list.set(temp, j);
    }
}
