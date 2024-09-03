package collections;

public class HashMap<K, V> {

     private Node<K,V>[] buckets;
     public HashMap(){
         this.buckets = new Node[16];
     }


    public void put(K key, V value) {

    }

    private int getBucketIndex(K key){
return 0;
    }


    private static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
