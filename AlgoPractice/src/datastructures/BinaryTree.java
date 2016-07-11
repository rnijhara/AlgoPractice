package datastructures;

import java.util.LinkedList;

/*
 Algorithm Inorder(tree)
 1. Traverse the left subtree, i.e., call Inorder(left-subtree)
 2. Visit the root.
 3. Traverse the right subtree, i.e., call Inorder(right-subtree)

 Uses of Inorder
 In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. 
 To get nodes of BST in non-increasing order, 
 a variation of Inorder traversal where Inorder itraversal s reversed, can be used.

 Algorithm Preorder(tree)
 1. Visit the root.
 2. Traverse the left subtree, i.e., call Preorder(left-subtree)
 3. Traverse the right subtree, i.e., call Preorder(right-subtree)

 Uses of Preorder
 Preorder traversal is used to create a copy of the tree. 
 Preorder traversal is also used to get prefix expression on of an expression tree.

 Algorithm Postorder(tree)
 1. Traverse the left subtree, i.e., call Postorder(left-subtree)
 2. Traverse the right subtree, i.e., call Postorder(right-subtree)
 3. Visit the root.

 Uses of Postorder
 Postorder traversal is used to delete the tree.
 */
class BinaryTree {

    class Node {

        int key;
        Node left, right;

        Node(int x) {
            key = x;
            left = right = null;
        }
    }

    Node root;

    BinaryTree() {
        root = null;
    }

    public void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " ");
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.key + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }
    
    public void levelorder(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) 
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    
    int getLeafCount(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return getLeafCount(node.left) + getLeafCount(node.right);
        }
    }
    
    void mirror(Node node) {
        if (node == null) {
            return;
        } else {
            /* do the subtrees */
            mirror(node.left);
            mirror(node.right);
 
            /* swap the objects/values in this node */
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
    
    boolean identicalTrees(Node a, Node b) {
         
        /*1. both empty */
        if (a == null && b == null) {
            return true;
        }
 
        /* 2. both non-empty -> compare them */
        if (a != null && b != null) {
            return (a.key == b.key
                    && identicalTrees(a.left, b.left)
                    && identicalTrees(a.right, b.right));
        }
 
        /* 3. one empty, one not -> false */
        return false;
    }
    
    int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
             
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
 
            /* use the larger one */
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        

        System.out.println("Preorder traversal of binary tree is ");
        tree.preorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.inorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postorder(tree.root);
        
        System.out.println("\nLevelorder traversal of binary tree is ");
        tree.levelorder(tree.root);
    }
}
