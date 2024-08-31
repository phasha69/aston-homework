
import collections.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(10);
        arrayList2.add(1);

        Integer[] x = {1, 2, 31, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        ArrayList<Integer> arrayList3 = new ArrayList<>(x);
        arrayList3.add(333);
        arrayList3.add(333);
        arrayList3.add(333);
        arrayList3.add(333);
        arrayList3.add(333);
        arrayList3.add(333);
        arrayList3.add(0);
        arrayList3.add(333);

        ArrayList<Integer> arrayList4 = new ArrayList<>(arrayList3);
        arrayList4.add(555);


        System.out.println(arrayList1 + "   -   " + arrayList1.length());

        System.out.println(arrayList2 + "   -   " + arrayList2.length());

        System.out.println(arrayList3 + "   -   " + arrayList3.length());

        System.out.println(arrayList4 + "   -   " + arrayList4.length());

        arrayList1.add(444,0);
        arrayList2.add(444,arrayList2.length());
        arrayList3.add(444,4);
        arrayList3.remove(Integer.valueOf(444));
        arrayList3.remove(Integer.valueOf(444));
        arrayList3.clear();
        arrayList3.remove(Integer.valueOf(444));
        arrayList3.add(444,arrayList3.length());


        System.out.println(arrayList1 + "   1-   " + arrayList1.length());

        System.out.println(arrayList2 + "   2-   " + arrayList2.length());

        System.out.println(arrayList3 + "   3-   " + arrayList3.length());

        System.out.println(arrayList4 + "   4-   " + arrayList4.length());

    }
}
