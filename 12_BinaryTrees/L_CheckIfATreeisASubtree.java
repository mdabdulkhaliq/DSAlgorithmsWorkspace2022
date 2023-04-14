/*
 * Check if A tree is a sub tree of another using. Will use identical logic inside.
 * Check if two trees are identical
 * Logic: 
 * Approach 1
 * Base condition will be that if both root nodes are null they are identical, will cover for empty roots and also for leaf nodes.
 * If either of the root node is empty, then its not identical.
 * So, when both roots are not empty, compare the value of roots and repeat the process for LS and RS
 * Approach 2: preOrder, inOrder and postOrder of both trees must be same for identical trees.
 */

 public class L_CheckIfATreeisASubtree {

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

    public static boolean checkIfTreesAreIdentical(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        
        if(root1 != null && root2 !=null){
            return (
                root1.data == root2.data &&
                checkIfTreesAreIdentical(root1.left, root2.left) &&
                checkIfTreesAreIdentical(root1.right, root2.right)
            );
        }

        //Case when either of root1 and root2 is null
        return false;
    }

    public static boolean isSubTree(Node mainTree, Node subTree){
        //null subtree is always part of a main subtree
        if(subTree == null)
            return true;
        
        //if the control is here, it means, only maintree is null and subtree is not
        if(mainTree ==  null)
            return false;
        
        if(checkIfTreesAreIdentical(mainTree, subTree))
            return true;

        return (isSubTree(mainTree.left, subTree) || isSubTree(mainTree.right, subTree));
    }

    public static void main(String[] args) {
        int nodes1[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root1 = BinaryTree.buildTree(nodes1);
        
        int nodes2[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree.idx = -1;
        Node root2 = BinaryTree.buildTree(nodes2);

        //boolean isIdentical = checkIfTreesAreIdentical(root1, root2);
        //System.out.println(isIdentical);

        boolean isSubTree = isSubTree(root1, root2);
        System.out.println(isSubTree);
        
    }
}
