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
        this.array = Arrays.copyOf(array, array.length);
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
        validData(item);
        ensureCapacity(length + 1);
        array[length++] = item;
    }

    public void add(T item, int index) {
        validData(index, item);
        ensureCapacity(length + 1);
        if (index < length) {
            System.arraycopy(array, index, array, index + 1, length - index);
        }
        array[index] = item;
        length++;
    }

    public T get(int index) {
        validData(index);
        return array[index];
    }

    public void set(T item, int index) {
        validData(index, item);
        array[index] = item;
    }

    public void clear() {
        Arrays.fill(array, null);
        this.length = 0;
    }

    public boolean contains(T item) {
        return getIndex(item) >= 0;
    }

    public int getIndex(T item) {
        validData(item);
        for (int i = 0; i < length; i++) {
            if (array[i].equals(item)) return i;
        }
        return -1;
    }

    public void remove(T item) {
        int index = getIndex(item);
        if (index >= 0) {
            remove(index);
        }
    }

    public void remove(int index) {
        validData(index);
        System.arraycopy(array, index + 1, array, index, length - index - 1);
        array[--length] = null;
    }

    private void validData(int index, T item) {
        validData(index);
        validData(item);
    }

    private void validData(int index) {
        if (index < 0 || index >= length + 1)
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
    }

    private void validData(T item) {
        if (item == null) throw new IllegalArgumentException("Added null");
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
            return currentIndex < length;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            return array[currentIndex++];
        }
    }
}
