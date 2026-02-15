package dev.generics;

public class Pair<K,V extends Number> {
    private K key;
    private V value;

    public void put(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Pair<String,Integer> pair = new Pair<>();
        pair.put("hello",123);
        System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
        pair.put("world",456);

        System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
    }
}


