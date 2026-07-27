package patternbased.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeDemo {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    private static int diameter = 0;
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static int diameterOfBinaryTree(TreeNode root){
        heightOfTree(root);
        return diameter;
    }


    public static int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }

       int left =  heightOfTree(root.left);
       int right =  heightOfTree(root.right);
        // Update diameter
       diameter = Math.max(diameter,left + right);
        // Return height
        return 1 + Math.max(left,right);
    }

    // BFS or level order traversal
    public List<List<Integer>> levelOrder(TreeNode root){
      List<List<Integer>> ans = new ArrayList<>();

      if(root == null){
          return ans;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while(!queue.isEmpty()){
          int size = queue.size();
          List<Integer> level = new ArrayList<>();

          for (int i=0 ; i < size; i++){
              TreeNode node = queue.poll();

              level.add(node.val);
              if(node.left != null){
                  queue.offer(node.left);
              }

              if(node.right != null){
                  queue.offer(node.right);
              }
          }
          ans.add(level);
      }
      return ans;
    }

    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p , TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }
        if(left!= null){
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);

        System.out.println("Preorder:");
        preOrder(root);

        System.out.println();

        System.out.println("Inorder:");
        inOrder(root);

        System.out.println();

        System.out.println("Postorder:");
        postOrder(root);
        System.out.println();
        int height = heightOfTree(root);
        System.out.println("height of tree:" + height);
        System.out.println();
        System.out.println("diameter of tree:" + diameter);
    }
}
