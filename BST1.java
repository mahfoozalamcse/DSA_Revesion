public class BST1 {
    public static class Node{
        
        int key;
        Node left, right;

        Node(int data){
            key = data;
            left = right = null;
        }
    }

    // recursive search binary search tree
    public static boolean recursivesearchBST(Node root, int x){
      if(root == null) return false;
      if(root.key == x){
         return true;
      }
      else if (root.key < x) {
          return recursivesearchBST(root.right, x);
      } else {
          return recursivesearchBST(root.left, x);
      }
    }

    // iterative search 
    

    public static void main(String[] args) {
        
    }
}