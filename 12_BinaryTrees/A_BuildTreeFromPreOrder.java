/*
 * Build a tree from a preorder list
 * Time Complexity: O(n) as it has to travel all nodes in the tree
 */

public class A_BuildTreeFromPreOrder {

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

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTree.buildTree(nodes);
        System.out.println(root.data);
    }
}
