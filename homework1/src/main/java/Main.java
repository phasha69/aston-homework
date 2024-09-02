
import collections.ArrayList;
import customclasses.Person;
import sort.QuickSort;

public class Main {
    public static void main(String[] args) {
        int count = 10;
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            persons.add(Person.createRandomPerson());
        }
        persons.forEach(System.out::println);

        System.out.println();

        QuickSort.sort(persons);
        persons.forEach(System.out::println);

    }
}
