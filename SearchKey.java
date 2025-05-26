public class SearchKey {
     static class Node{
        int key;
        Node left;
        Node right;

        Node(int k){
            key = k;
        }
    }

    // search
    public static boolean search(Node root, int x){ 
        if(root == null){
            return false;
        }else if(root.key == x){
            return true;
        }else if(root.key > x){
            return search(root.left, x);
        }else{
            return search(root.right, x);
        }
        
    }

    // itrative approch
    boolean searchItr(Node root, int x){
        while(root!=null){
            if(root.key==x)
                return true;
            else if(root.key<x)
                root=root.right;
            else
                root=root.left;
        }
        return false;
    }

    // insert key 
    static Node insert(Node root, int x){
        if(root == null){
            return new Node(x);
        }else if(root.key < x){
            root.right =  insert(root.right, x);
        }else{
            root.left =  insert(root.left, x);
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);
        int x = 1;

        if (search(root, x))
            System.out.println("Found");
        else
            System.out.println("Not Found");

        insert(root, 20);

    
    }
}
