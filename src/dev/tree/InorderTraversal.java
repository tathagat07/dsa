package dev.tree;

import java.util.ArrayList;
import java.util.Stack;

class treeNode {
    int data;
    treeNode left, right;

    treeNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class InorderTraversal {

    static ArrayList<Integer> inorder(treeNode root) {
        ArrayList<Integer> v = new ArrayList<>();
        Stack<treeNode> s = new Stack<>();
        treeNode curr = root;

        while (curr != null || !s.isEmpty()) {

            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            v.add(curr.data);
            curr = curr.right;
        }
        return v;
    }

    static void printList(ArrayList<Integer> v) {
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Constructed binary tree is
        //          10
        //        /   \
        //      6      14
        //    /  \     / \
        //  4     8   12   16

        treeNode root = new treeNode(10);
        root.left = new treeNode(6);
        root.right = new treeNode(14);
        root.left.left = new treeNode(4);
        root.left.right =  new treeNode(8);
        root.right.left = new treeNode(12);
        root.right.right = new treeNode(16);

        ArrayList<Integer> result = inorder(root);
        printList(result);
    }
}