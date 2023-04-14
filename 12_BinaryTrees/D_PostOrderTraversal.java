/*
 * postOrder traversal of the tree
 * Time Complexity: O(n) as it has to travel all nodes in the tree
 */

 public class D_PostOrderTraversal {

    //static class for Node element
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    //static class for Binary Tree
    static class BinaryTree {
        //Need a global counter when navigating through node list recursively.
        static int idx = -1;

        public static Node buildTree(int nodes[]){
            //increment index everytime buildTree is called to fetch the next element
            idx++;
            ///Check if the next element is leaf node
            if(nodes[idx] == -1){
                return null;
            }

            //Build the root element
            Node newNode = new Node(nodes[idx]);
            //Build the left sub-tree of the element
            newNode.left = buildTree(nodes);
            //Build the right sub-tree of the element
            newNode.right = buildTree(nodes);

            //Return the element created having the left and right subtree
            return newNode;
        }
    }

    //Printing postOrder traversal of the tree
    public static void postOrder(Node root){
        //If the node is null return
        if(root == null) {
            System.out.print("-1 ");
            return;
        }
        
        //Print the left sub tree
        postOrder(root.left);
        
        //Print the right sub tree
        postOrder(root.right);

        //Print the value of the root node
        System.out.print(root.data + " "); 
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        //Build the tree
        Node root = BinaryTree.buildTree(nodes);
        //Print the root node of the tree
        System.out.println(root.data);
        //Print preorder traversal of the tree
        postOrder(root);

    }
}
