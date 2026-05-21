package dev.tree;

import java.util.ArrayList;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {

            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }



    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }

    }

    public static Node delete(Node root, int key) {

        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        } else {
            // case 1
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {  // case 2
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    public static void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.data >= x && root.data <= y) {

            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);

        } else if (root.data >= y) {
            printInRange(root.left, x, y);
        } else {
            printInRange(root.right, x, y);
        }

    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {

            System.out.print(path.get(i) + " -> ");
        }
        System.out.println();
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }
    public static Node prev = null;
    public static int minDiffInBST(Node root) {

       if(root == null){
           return Integer.MAX_VALUE;
       }

       int ans = Integer.MAX_VALUE;
       if(root.left != null ){
         int leftMin = minDiffInBST(root.left);
         ans = Math.min(leftMin,ans);
       }

       if(prev != null){
           ans = Math.min(ans, (root.data - prev.data));

       }
        prev = root;

       if(root.right != null){
           int rightMin= minDiffInBST(root.right);
           ans = Math.min(rightMin,ans);
       }
       return ans;
    }

    public static void main(String[] args) {

        int values[] = {4,2,6,1,3};

        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
      //  System.out.println(minDiffInBST(root));
        //   delete(root,5);
            printInRange(root,3,12);
        //   inorder(root);
    //    printRoot2Leaf(root, new ArrayList<>());
        //   System.out.println(search(root, 12));
    }
}
