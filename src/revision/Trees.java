package revision;

import java.util.LinkedList;
import java.util.Queue;

class Node {
     int val;
     Node left;
     Node right;

     public Node(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }
public class Trees {

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null){
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);

    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.val + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if (currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countNodes(Node root) {
        int count = 0;
        if(root == null){
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        count = leftCount + rightCount + 1;
        return count;
    }

    public static int sumOfNodes(Node root){
        int sum = 0;
        if(root == null){
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

         sum = leftSum + rightSum + root.val;

         return sum;
    }

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight,rightHeight) + 1;

    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);

        int dia3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(Math.max(leftDia,rightDia),dia3);
    }

    public boolean isIdentical(Node root, Node subRoot){
        if(subRoot == null && root == null){
            return true;
        }
        if(subRoot == null || root == null){
            return false;
        }
        if(root.val == subRoot.val){
            return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
        }

        return false;
    }

    public boolean isSubTree(Node root, Node subRoot){
        if(subRoot == null){
            return true;
        }
        if (root == null){
            return false;
        }

        if(isIdentical(root,subRoot)){
            return true;
        }

        return isSubTree(root.left,subRoot) || isSubTree(root.right , subRoot);

    }

    public boolean isSymmetric(Node root){
        return isMirror(root,root);
    }

    public boolean isMirror(Node left, Node right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }
        return isMirror(left.left,right.right) && isMirror(left.right, right.left);
    }

}
