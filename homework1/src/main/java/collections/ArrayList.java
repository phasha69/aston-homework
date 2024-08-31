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

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 3 / 2 + 1, minCapacity);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("Added null");
        ensureCapacity(length + 1);
        array[length++] = item;
    }

    public void add(T item, int index) {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        if (item == null) throw new IllegalArgumentException("Added null");
        ensureCapacity(length + 1);

        // Сдвигаем элементы вправо, начиная с конца, чтобы освободить место для нового элемента
        System.arraycopy(array, index, array, index +1, length - index);

        array[index] = item;
        length++;
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
