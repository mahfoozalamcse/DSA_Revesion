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

    // insert in BST recursive
    public static Node insertBST(Node root, int x){

        if (root == null) {
           return new Node(x);
        }
        else if (root.key < x) {
            root.right = insertBST(root.right, x);
        } else if(root.key > x){
            root.left = insertBST(root.left, x);
        }
       return root;
    }

    // insert node iterative
    public static Node insertBSTIterative(Node root, int x){
       Node temp = new Node(x);
       Node parent = null;
       Node curr = root;

       while (curr != null) {
         parent = curr;
         if (curr.key > x) {
            curr = curr.left;
         }else if (curr.key < x) {
            curr = curr.right;
         } else {
            return root;
         }
       }

       if (parent == null) {
          return temp;
       }
       if (parent.key > x) {
          parent.left = temp;
       }else{
          parent.right = temp;
       }
      return root;
    }

    // print inorder traversal
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }    
    }

    public static void main(String[] args) {
        Node root=new Node(10);
    	root.left=new Node(5);
    	root.right=new Node(15);
    	root.right.left=new Node(12);
    	root.right.right=new Node(18);
    	int x=20;

    	root=insertBST(root,x);
	    inorder(root);

        System.out.println();
        System.out.println(iterativeSearchBST(root, x));
    }
}
