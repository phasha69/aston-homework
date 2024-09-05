package collections;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Реализация динамического списка на основе массива (аналог java.util.ArrayList).
 *
 * @param <T> тип элементов в этом списке
 */
public class ArrayList<T> implements Iterable<T> {
    private T[] array;
    private int length;

    /**
     * Конструктор по умолчанию. Инициализирует массив с размером по умолчанию 10.
     */
    public ArrayList() {
        int INITIAL_CAPACITY = 10;
        this.array = (T[]) new Object[INITIAL_CAPACITY];
        this.length = 0;
    }

    /**
     * Конструктор, создающий ArrayList на основе существующего массива.
     *
     * @param array массив, из которого копируются элементы
     */
    public ArrayList(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.length = array.length;
    }

    /**
     * Конструктор, создающий ArrayList с заданной начальной ёмкостью.
     *
     * @param initialCapacity начальный размер внутреннего массива
     * @throws IllegalArgumentException если начальная ёмкость отрицательная
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Initial capacity cannot be negative");
        this.array = (T[]) new Object[initialCapacity];
        this.length = 0;
    }

    /**
     * Конструктор копирования. Создаёт новый ArrayList на основе другого.
     *
     * @param list ArrayList для копирования
     */
    public ArrayList(ArrayList<T> list) {
        this(Arrays.copyOf(list.array, list.length));
    }

    /**
     * Увеличивает ёмкость внутреннего массива, если она меньше минимальной необходимой.
     *
     * @param minCapacity минимальная необходимая ёмкость
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(array.length * 3 / 2 + 1, minCapacity);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param item элемент для добавления
     * @throws IllegalArgumentException если элемент равен null
     */
    public void add(T item) {
        ensureCapacity(length + 1);
        array[length++] = item;
    }

    /**
     * Вставляет элемент в список по заданному индексу.
     *
     * @param item  элемент для вставки
     * @param index позиция для вставки элемента
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка
     * @throws IllegalArgumentException  если элемент равен null
     */
    public void add(T item, int index) {
        validIndex(index);
        ensureCapacity(length + 1);
        if (index < length) {
            System.arraycopy(array, index, array, index + 1, length - index);
        }
        array[index] = item;
        length++;
    }

    /**
     * Возвращает элемент по заданному индексу.
     *
     * @param index индекс элемента для получения
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка
     */
    public T get(int index) {
        validIndex(index);
        return array[index];
    }

    /**
     * Заменяет элемент по заданному индексу на новый.
     *
     * @param item  новый элемент
     * @param index индекс для замены
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка
     * @throws IllegalArgumentException  если элемент равен null
     */
    public void set(T item, int index) {
        validIndex(index);
        array[index] = item;
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    public void clear() {
        Arrays.fill(array, null);
        this.length = 0;
    }

    /**
     * Проверяет, содержит ли список заданный элемент.
     *
     * @param item элемент для проверки
     * @return true, если элемент содержится в списке, иначе false
     * @throws IllegalArgumentException если элемент равен null
     */
    public boolean contains(T item) {
        return getIndex(item) >= 0;
    }

    /**
     * Возвращает индекс заданного элемента в списке.
     *
     * @param item элемент для поиска
     * @return индекс элемента или -1, если элемент не найден
     * @throws IllegalArgumentException если элемент равен null
     */
    public int getIndex(T item) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(item)) return i;
        }
        return -1;
    }

    /**
     * Удаляет заданный элемент из списка.
     *
     * @param item элемент для удаления
     */
    public void remove(T item) {
        int index = getIndex(item);
        if (index >= 0) {
            remove(index);
        }
    }

    /**
     * Удаляет элемент по заданному индексу.
     *
     * @param index индекс элемента для удаления
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка
     */
    public void remove(int index) {
        validIndex(index);
        System.arraycopy(array, index + 1, array, index, length - index - 1);
        array[--length] = null;
    }


    /**
     * Проверяет, находится ли индекс в допустимых пределах.
     *
     * @param index индекс для проверки
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     */
    private void validIndex(int index) {
        if (index < 0 || index >= length + 1)
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return текущая длина списка
     */
    public int length() {
        return length;
    }

    /**
     * Возвращает строковое представление списка.
     *
     * @return строковое представление списка
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, length));
    }

    /**
     * Возвращает итератор для обхода элементов списка.
     *
     * @return итератор по элементам списка
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Внутренний класс-итератор для списка ArrayList.
     */
    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        /**
         * Проверяет, есть ли ещё элементы для обхода.
         *
         * @return true, если есть ещё элементы, иначе false
         */
        @Override
        public boolean hasNext() {
            return currentIndex < length;
        }

        /**
         * Возвращает следующий элемент в списке.
         *
         * @return следующий элемент
         * @throws IllegalStateException если больше нет элементов
         */
        @Override
        public T next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            return array[currentIndex++];
        }
    }
}
