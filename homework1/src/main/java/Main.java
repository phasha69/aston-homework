import collectinos.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList1 = new ArrayList<>();

        ArrayList<Integer> arrayList2 = new ArrayList<>(14);

        Integer[] x = {1, 2, 31, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        ArrayList<Integer> arrayList3 = new ArrayList<>(x);

        ArrayList<Integer> arrayList4 = new ArrayList<>(arrayList3);


        System.out.println(arrayList1 + "   -   " + arrayList1.length());

        System.out.println(arrayList2 + "   -   " + arrayList2.length());

        System.out.println(arrayList3 + "   -   " + arrayList3.length());

        System.out.println(arrayList4 + "   -   " + arrayList4.length());

        arrayList4.forEach(System.out::println);

    }
}
