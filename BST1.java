public class BST1 {
    public static class Node{
        
        int key;
        Node left, right;

        Node(int data){
            key = data;
            left = right = null;
        }
    }

    // recursive search binary search tree time O(h) space O(h)
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

    // iterative search time O(h) space is O(1)

    public static boolean iterativeSearchBST(Node root, int x){
        while (root != null) {
            
        if (root.key == x) {
            return true;
        }
        else if (root.key < x) {
            root = root.right;
        } else {
            root = root.left;
        }
    }
      return false;
    }

    

    public static void main(String[] args) {
        
    }
}