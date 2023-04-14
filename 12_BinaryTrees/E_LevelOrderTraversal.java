import java.util.LinkedList;
import java.util.Queue;

/*
 * levelOrder traversal of the tree
 * Time Complexity: O(n) as it has to travel all nodes in the tree
 * Use a queue to store the element, to begin with insert the root node
 * Keep repeating this step: Remove element from the queue and insert its left and right child, until there are no more elements in the queue.
 * To identify a new line for every level, insert root and null at the beginning.
 * If we are popping a null it means we are moving to the next level and insert back the null at the end of the queue if the queue is not empty.
 */

 public class E_LevelOrderTraversal {

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

    //Printing levelOrder traversal of the tree
    public static void levelOrder(Node root){

        if(root == null){
            return;
        }

        // To begin with add root node and null to identify next level
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        //Start removing elements from queue one by one
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            //If element is null print next level line
            if(currentNode == null){
                System.out.println();
                //If queue is not empty insert back the null
                if(queue.isEmpty()){
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                //If element is not null and has value print it
                System.out.print(currentNode.data + " ");
                //insert the removed elements left child
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                //insert the removed elements right child
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        //Build the tree
        Node root = BinaryTree.buildTree(nodes);
        //Print the root node of the tree
        //System.out.println(root.data);
        //Print levelOrder traversal of the tree
        levelOrder(root);

    }
}
