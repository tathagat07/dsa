package dev.tries;

public class Tries {

    static class Node {

        Node[] children = new Node[26];
        boolean eow;

        public Node(){
            for (int i = 0; i<26; i++){
                children[i] = null;
            }
        }


    }

    public static Node root = new Node();

    public static void insert(String word) { //O(n)
        int level = 0;
        int len = word.length();
        int idx = 0;


        Node curr = root;
        for(; level<len; level++) {
            idx = word.charAt(level)-'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for (String word : words) {
            insert(word);
            System.out.println("inserted " + word);
        }

    }


}
