
import collections.ArrayList;
import customclasses.Person;

public class Main {
    public static void main(String[] args) {
        int count = 10;
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(Person.createRandomPerson());
        }
        persons.forEach(System.out::println);

        persons.remove(persons.get(0));
        System.out.println();
        persons.forEach(System.out::println);
    }
}
