package dev.tree;

import java.util.*;

public class BinaryTrees {


    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        static class TreeInfo {
            int ht;
            int dia;

            public TreeInfo(int ht, int dia) {

                this.ht = ht;
                this.dia = dia;
            }
        }

        static class QueueEntry {
            Node node;
            int hd;

            QueueEntry(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        static class BinaryTree {
            static int index = -1;

            public static Node buildTree(int nodes[]) {
                index++;

                if (index >= nodes.length || nodes[index] == -1) {
                    return null;
                }

                Node newNode = new Node(nodes[index]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);

                return newNode;
            }

            public static void preOrder(Node root) {
                if (root == null) {
                    // System.out.print(-1 + " ");
                    return;
                }

                System.out.print(root.data + " ");
                preOrder(root.left);
                preOrder(root.right);
            }

            public static void inOrder(Node root) {
                if (root == null) {
                    //    System.out.print(-1 + " ");
                    return;
                }

                inOrder(root.left);
                System.out.print(root.data + " ");
                inOrder(root.right);
            }

            public static void postOrder(Node root) {
                if (root == null) {
                    return;
                }

                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.data + " ");

            }

            public static void levelOrder(Node root) {
                if (root == null) {
                    return;
                }

                Queue<Node> q = new LinkedList<>();

                q.add(root);
                q.add(null);

                while (!q.isEmpty()) {
                    Node currNode = q.remove();
                    if (currNode == null) {
                        System.out.println();
                        if (q.isEmpty()) {
                            break;
                        } else {
                            q.add(null);
                        }

                    } else {
                        System.out.print(currNode.data + " ");
                        if (currNode.left != null) {
                            q.add(currNode.left);
                        }
                        if (currNode.right != null) {
                            q.add(currNode.right);
                        }
                    }

                }
            }

            public static int countNodes(Node root) {

                int count = 0;
                if (root == null) {
                    return 0;
                }
                int leftCount = countNodes(root.left);
                int rightCount = countNodes(root.right);
                count = leftCount + rightCount + 1;

                return count;

            }

            public static int sumOfNodes(Node root) {
                if (root == null) {
                    return 0;
                }

                int leftSum = sumOfNodes(root.left);
                int rightSum = sumOfNodes(root.right);

                return leftSum + rightSum + root.data;
            }

            public static int heightOfTree(Node root) {
                if (root == null) {
                    return 0;
                }
                int leftHeight = heightOfTree(root.left);
                int rightHeight = heightOfTree(root.right);

                return Math.max(leftHeight, rightHeight) + 1;

            }

            public static int diameter(Node root) {
                if (root == null) {
                    return 0;
                }
                int leftDia = diameter(root.left);
                int rightDia = diameter(root.right);
                int dia3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
                return Math.max(Math.max(leftDia, rightDia), dia3);
            }

            public static TreeInfo diameter2(Node root) {

                if (root == null) {
                    return new TreeInfo(0, 0);
                }
                TreeInfo left = diameter2(root.left);
                TreeInfo right = diameter2(root.right);

                int myHt = Math.max(left.ht, right.ht) + 1;

                int diam1 = left.dia;
                int dia2 = right.dia;

                int dia3 = left.ht + right.ht + 1;

                int mydia = Math.max(Math.max(diam1, dia2), dia3);

                TreeInfo myInfo = new TreeInfo(myHt, mydia);
                return myInfo;

            }

            public boolean isIdentical(Node root, Node subRoot) {
                if (subRoot == null && root == null) {
                    return true;
                }
                if (subRoot == null || root == null) {
                    return false;
                }
                if (root.data == subRoot.data) {
                    return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
                }
                return false;

            }

            public boolean isSubTree(Node root, Node subRoot) {

                if (subRoot == null) {
                    return true;
                }
                if (root == null) {
                    return false;
                }
                if (isIdentical(root, subRoot)) {
                    return true;
                }
                return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
            }

            public boolean isSymmetric(Node root) {
                return isMirror(root, root);
            }

            private boolean isMirror(Node left, Node right) {
                if (left == null && right == null) {
                    return true;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.data != right.data) return false;
                return isMirror(left.left, right.right) && isMirror(left.right, right.left);
            }

            public ArrayList<Integer> bottomView(Node root) {
                // code here
                if (root == null) {
                    return new ArrayList<>();
                }
                ArrayList<Integer> ans = new ArrayList<>();
                int hd = 0;

                Map<Integer, Integer> bottomViewMap = new TreeMap<>();

                Queue<QueueEntry> q = new LinkedList<>();
                q.add(new QueueEntry(root, 0));

                while (!q.isEmpty()) {
                    QueueEntry currEntry = q.poll();
                    Node currNode = currEntry.node;
                    int currentHd = currEntry.hd;

                    bottomViewMap.put(currentHd, currNode.data);

                    if (currNode.left != null) {
                        q.add(new QueueEntry(currNode.left, currentHd - 1));
                    }

                    if (currNode.right != null) {
                        q.add(new QueueEntry(currNode.right, currentHd + 1));
                    }


                }

                for (int value : bottomViewMap.values()) {
                    ans.add(value);
                }
                return ans;
            }

            public ArrayList<Integer> topView(Node root) {
                // code here
                if (root == null) {
                    return new ArrayList<>();
                }
                ArrayList<Integer> ans = new ArrayList<>();
                int hd = 0;

                Map<Integer, Integer> bottomViewMap = new TreeMap<>();

                Queue<QueueEntry> q = new LinkedList<>();
                q.add(new QueueEntry(root, 0));

                while (!q.isEmpty()) {
                    QueueEntry currEntry = q.poll();
                    Node currNode = currEntry.node;
                    int currentHd = currEntry.hd;

                    if (bottomViewMap.containsKey(currentHd)) {
                        bottomViewMap.put(currentHd, currNode.data);
                    } else {
                        bottomViewMap.put(currentHd, currNode.data);
                    }

                    if (currNode.left != null) {
                        q.add(new QueueEntry(currNode.left, currentHd - 1));
                    }

                    if (currNode.right != null) {
                        q.add(new QueueEntry(currNode.right, currentHd + 1));
                    }

                }

                for (int value : bottomViewMap.values()) {
                    ans.add(value);
                }
                return ans;
            }
        }


    }

    public static void main(String[] args) {

        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int nodes[] = {1, 2, 3, 4, 5, -1, 6};
        //   int subNodes[] = {2, 4, -1, -1, 5, -1, -1};
        Node.BinaryTree tree = new Node.BinaryTree();
        Node.BinaryTree.index = -1;
        Node root = tree.buildTree(nodes);

        tree.levelOrder(root);
        //       System.out.println();
        //       System.out.println("=====================================================");

//        Node.BinaryTree.index = -1;
//        Node subRoot = tree.buildTree(subNodes);
//        tree.levelOrder(subRoot);
//        boolean isSubRoot = tree.isSubTree(root, subRoot);


//       System.out.println(tree.diameter(root));
        //     System.out.println(tree.diameter(subRoot));
        //      System.out.println(isSubRoot);
//        System.out.println(tree.diameter2(root).dia);

    }

}
