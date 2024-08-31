package collectinos;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {
    private T[] array;
    private int length;

    public ArrayList() {
        this.array = (T[]) new Object[10];
        length = 0;
    }

    public ArrayList(T[] array) {
        this(array.length);
        this.array = (T[]) new Object[length];
        System.arraycopy(array, 0, this.array, 0, length);
    }

    public ArrayList(int length) {
        if (length < 0) throw new IllegalArgumentException("length less than zero");
        this.array = (T[]) new Object[length];
        this.length = length;
    }

    public ArrayList(ArrayList<T> list) {
        this(list.array.clone());
    }

    public int length() {
        return length;
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "[]";
        }
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
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            return array[currentIndex++];
        }
    }
}
