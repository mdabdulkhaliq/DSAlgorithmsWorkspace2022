/*
 * Find the diameter of a tree - Longest path available between 2 nodes
 * Logic: There can be three scenarios
 * 1. Longest path/diameter is in the LS (does not pass through root node)
 * 2. Longest path/diameter is in the RS (does not pass through root node)
 * 3. Longest path/diameter passes through root node - which is height of LS + height of RS + 1
 * Time Complexity: O(n*n) as it has to travel all nodes for diameter and then height for each node
 */

 public class I_DiameterOfTree {

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

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int diameterLS = diameter(root.left);
        int diameterRS = diameter(root.right);
        int diameterThroughRoot = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diameterThroughRoot, Math.max(diameterLS, diameterRS));

    }

    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diameterLeft = left.diameter;
        int diameterRight = right.diameter;
        int diameterThroughRoot = left.height + right.height + 1;

        int myDiameter = Math.max(Math.max(diameterLeft, diameterRight), diameterThroughRoot);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);
        return myInfo;
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTree.buildTree(nodes);
        //System.out.println(root.data);
        int diameter = diameter(root);
        System.out.println(diameter);
        TreeInfo diameter2 = diameter2(root);
        System.out.println(diameter2.diameter);
    }
}
