package customclasses;

import java.util.Objects;
import java.util.Random;

public class Person implements Comparable<Person> {
     final String name;
     final int age;

    private static final String[] NAMES = {"Adamson", "Black", "Chapman", "Davidson", "Farrell", "Garrison", "Goldman", "James", "Lewin", "Taylor"};
    private static final Random RND= new Random();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=\t '" + name + "'\t" +
                ", \tage=" + age +
                '}';
    }
    public static Person createRandomPerson(){

        return new Person(NAMES[RND.nextInt(NAMES.length)], RND.nextInt(18,80));
    }
}
