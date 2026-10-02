// Fig. 21.17: Tree.java
// TreeNode and Tree class declaration for a binary search tree.
package java_code.ch21;

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {

    // package access members
    TreeNode<T> leftNode;
    T data; // node value;
    TreeNode<T> rightNode;

    // constructor initializes data and makes this a leaf node
    public TreeNode(T nodeData) {

        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }

    // locate and insertion point and insert new node; ignore duplicate values
    public void insert(T insertValue) {

        // insert in leftsubtree
        if (insertValue.compareTo(data) < 0) {

            // insert a new tree
            if (leftNode == null)
                leftNode = new TreeNode<T>(insertValue);
            else // continue traversing the left subtree
                leftNode.insert(insertValue);
        }
        // insert in the right subtree
        else if (insertValue.compareTo(data) >= 0) {

            // insert a new tree
            if (rightNode == null)
                rightNode = new TreeNode<T>(insertValue);
            else // continue traversing the right subtree
                rightNode.insert(insertValue);
        }
    }
}// end class TreeNode

public class Tree<T extends Comparable<T>> {

    private TreeNode<T> root;
    int depth;
    private TreeNode<T> parentNode; // to get the parent node of an element to be deleted

    // constructor initialies an empty Tree of integers
    public Tree() {

        root = null;
        depth = 0;
        parentNode = null;
    }

    // insert a new node in the binary search tree
    public void insertNode(T insertValue) {

        if (root == null)
            root = new TreeNode<T>(insertValue); // create root node
        else
            root.insert(insertValue); // call the insert method
    }

    // begin preorder traversal
    public void preorderTraversal() {

        preorderHelper(root, "root");
    }

    // recursive method to perform preorder traversal
    private void preorderHelper(TreeNode<T> node, String direction) {

        if (node == null)
            return;

        System.out.printf("%s ", node.data);
        preorderHelper(node.leftNode, "left"); // traverse left subtree
        preorderHelper(node.rightNode, "right"); // traverse right subtree
    }

    // begin inorder traversal
    public void inorderTraversal() {

        inorderHelper(root);
    }

    // recursive method to perform inorder traversal
    public void inorderHelper(TreeNode<T> node) {

        if (node == null)
            return;

        inorderHelper(node.leftNode); // traverse the left subtree
        System.out.printf("%s ", node.data);
        inorderHelper(node.rightNode); // traver the right subtree
    }

    // begin postorder traversal
    public void postorderTraversal() {

        postorderHelper(root);
    }

    // recursive method to perform postorder traversal
    public void postorderHelper(TreeNode<T> node) {

        if (node == null)
            return;

        postorderHelper(node.leftNode); // traverse the left subtree
        postorderHelper(node.rightNode); // traverse the right subtree
        System.out.printf("%s ", node.data); // output node data
    }

    // level order traversal
    public void levelorderTraversal() {
        levelorderHelper(root);
    }

    // level order traversal helper method
    public void levelorderHelper(TreeNode<T> node) {

        // queue to hold our values for guided printing
        Queue<TreeNode<T>> queue = new Queue<>();
        TreeNode<T> nextNode;

        queue.enqueue(node);

        while (!queue.isEmpty()) {

            nextNode = queue.dequeue(); // getting the next node in the queue
            System.out.printf("%s  ", nextNode.data);

            // if (queue.isEmpty())
            // System.out.println();

            if (nextNode.leftNode != null) {
                queue.enqueue(nextNode.leftNode);

            }

            if (nextNode.rightNode != null) {
                queue.enqueue(nextNode.rightNode);
            }

        }
    }

    // method getDepth to return the depth of the binary tree
    public int getDepth() {

        getDepthHelper(root, 0);

        return depth;
    }

    // recursive method to get the depth of our tree
    public void getDepthHelper(TreeNode<T> node, int tempDepth) {

        if (node == null) {

            if (tempDepth >= depth)
                depth = tempDepth;

            return;
        }

        getDepthHelper(node.leftNode, tempDepth + 1); // traverse left subtree
        getDepthHelper(node.rightNode, tempDepth + 1); // traverse right subtree
    }

    /*
     * // deleting values from a binary tree public void deleteNode(T value) {
     * 
     * TreeNode<T> node = searchNode(value);
     * 
     * if (node == null) { System.out.println("Element not found in the Tree!");
     * return; }
     * 
     * // case 1: if its a leafNode else if (node.leftNode == null && node.rightNode
     * == null) {
     * 
     * // check the parent node to see if its not null if (parentNode != null) {
     * 
     * if (parentNode.leftNode == node) {
     * 
     * parentNode.leftNode = null; } else {
     * 
     * parentNode.rightNode = null; } }
     * 
     * // if the parent node is null if (parentNode == null) {
     * 
     * root = null; // means we wre deleting root it self } }
     * 
     * // case 2: now time to work on non leafNode, but this time a node with only
     * one // child. else if ((node.leftNode == null && node.rightNode != null) ||
     * (node.leftNode != null && node.rightNode == null)) {
     * 
     * if (node.leftNode != null) {
     * 
     * if (parentNode.leftNode == node) {
     * 
     * parentNode.leftNode = node.leftNode;
     * 
     * } else {
     * 
     * parentNode.rightNode = node.leftNode; }
     * 
     * // node = null;
     * 
     * }
     * 
     * else if (node.rightNode != null) {
     * 
     * if (parentNode.leftNode == node) {
     * 
     * parentNode.leftNode = node.rightNode;
     * 
     * } else {
     * 
     * parentNode.rightNode = node.rightNode; }
     * 
     * // node = null; } }
     * 
     * // case 3: when the node has more two children
     * 
     * }
     */

    public void delete(T value) {
        // find the node to delete, this will also set parentNode
        TreeNode<T> node = searchNode(value);

        if (node == null) {
            System.out.println("Element Not found!");
            return; // value not found
        }

        // case 1: leaf node
        if (node.leftNode == null && node.rightNode == null) {
            if (parentNode == null) {
                root = null;
            } else if (parentNode.leftNode == node) {
                parentNode.leftNode = null;
            } else {
                parentNode.rightNode = null;
            }
        }
        // case 2: one child only
        else if ((node.leftNode == null && node.rightNode != null)
                || (node.leftNode != null && node.rightNode == null)) {

            TreeNode<T> child = (node.leftNode != null) ? node.leftNode : node.rightNode;

            if (parentNode == null) {
                root = child; // deleting root with one child
            } else if (parentNode.leftNode == node) {
                parentNode.leftNode = child;
            } else {
                parentNode.rightNode = child;
            }
        }
        // case 3: two children
        else {
            // find successor - smallest in right subtree
            TreeNode<T> successorParent = node;
            TreeNode<T> successor = node.rightNode;

            while (successor.leftNode != null) {
                successorParent = successor;
                successor = successor.leftNode;
            }

            // copy successor data to node
            node.data = successor.data;

            // delete successor (it has at most one right child)
            if (successorParent.leftNode == successor) {
                successorParent.leftNode = successor.rightNode;
            } else {
                successorParent.rightNode = successor.rightNode;
            }
        }
    }

    // method to search for an element in our tree
    public TreeNode<T> searchNode(T value) {

        parentNode = null;
        TreeNode<T> node = searchNodeHelper(root, value); // search for the value, from the root

        return node; // returning reference to the deleteNode
    }

    // actual search method that traverse the list in search for an element
    public TreeNode<T> searchNodeHelper(TreeNode<T> node, T value) {

        if (node == null)
            return null;

        else if (value.compareTo(node.data) < 0) {

            // constantly updating the parent node

            parentNode = node;
            return searchNodeHelper(node.leftNode, value); // traverse the left node
        }

        else if (value.compareTo(node.data) > 0) {

            // constantly updating the parent node
            parentNode = node;
            return searchNodeHelper(node.rightNode, value); // traverse the right node
        }

        return node; // node of the value found.

    }

    // method to call the helper method
    public void outputTree() {

        outputTreeHelper(root, 0);
    }
    // method to display our tree like an actual tree
    public void outputTreeHelper(TreeNode<T> currentNode, int totalSpaces) {

       

        while (currentNode != null) {

            outputTreeHelper(currentNode.rightNode, totalSpaces + 5);
            for (int i = 0; i < totalSpaces; i++) {

                System.out.print("-");
            }

            
            System.out.printf("%3s", currentNode.data); // outputing the value in the current node

            currentNode = currentNode.leftNode; 
            totalSpaces += 5;

        }
       
        System.out.println(); System.out.print("|");System.out.println();

    }

} // end class Tree