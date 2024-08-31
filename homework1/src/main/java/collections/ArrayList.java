package collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {
    private T[] array;
    private int length;

    public ArrayList() {
        this.array = (T[]) new Object[10];
        this.length = 0;
    }

    public ArrayList(T[] array) {
        this.array = (T[]) new Object[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.length = array.length;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Initial capacity cannot be negative");
        this.array = (T[]) new Object[initialCapacity];
        this.length = 0;
    }

    public ArrayList(ArrayList<T> list) {
        this(Arrays.copyOf(list.array, list.length));
    }

    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("Added null");
        if (length == array.length) {
            // Увеличиваем размер массива на 50%
            T[] newArray = (T[]) new Object[(int) (length * 1.5)];
            System.arraycopy(array, 0, newArray, 0, length);
            array = newArray;
        }
        array[length++] = item;
    }

    public int length() {
        return length;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, length));
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < length && array[currentIndex + 1] != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            return array[currentIndex++];
        }
    }
}
