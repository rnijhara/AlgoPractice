package random;

/*
Binary Search Tree, is a node-based binary tree data structure which has the following properties:
1. The left subtree of a node contains only nodes with keys less than the node’s key.
2. The right subtree of a node contains only nodes with keys greater than the node’s key.
3. The left and right subtree each must also be a binary search tree.
4. There must be no duplicate nodes.


Searching a key:
To search a given key in Bianry Search Tree, 
we first compare it with root, if the key is present at root, we return root. 
If key is greater than root’s key, we recur for right subtree of root node. 
Otherwise we recur for left subtree.


Insertion of a key:
A new key is always inserted at leaf. 
We start searching a key from root till we hit a leaf node. 
Once a leaf node is found, the new node is added as a child of the leaf node.

*/
class BinarySearchTree {
    class Node {
        int key;
        Node left, right;
 
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }
    
    public Node insert(Node node, int x) {
        if(node == null) {
            node = new Node(x);
            return node;
        }
        
        if(x < node.key) {
            node.left = insert(node.left, x);
        } else if(x > node.key) {
            node.right = insert(node.right, x);
        }
        return node;
    }
    
    public Node search(Node node, int x) {
        if(node == null || node.key == x) {
            return node;
        }
        
        if(node.key > x) {
            return search(node.left, x);
        } else {
            return search(node.right, x);
        }
    }
    
    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);
        
        tree.inorderRec(tree.root);
    }
}
