import java.util.*;

public class RedBlackTree {
    private Node root;
    
	public static void main(String[] args) {
		RedBlackTree myTree = new RedBlackTree();
		
		myTree.add(5);
    	myTree.add(7);
		myTree.add(10);
		myTree.add(3);
		myTree.add(6);
		myTree.printTree();
		System.out.println("");
	}
    
    private enum Color {
        RED, BLACK
    }
    
    public boolean add (int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }
        else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
    
    private boolean addNode (Node node, int value) {
        if (node.value == value) {
            return false;
        } 
        else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;                   
                } 
                else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
             } 
             else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                }
                else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
             }
        }
    }
    
    private void colorSwap (Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }
    
    private Node leftSwap (Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }
    
    private Node rightSwap (Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }
    
    private Node rebalance (Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED && 
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                        needRebalance = true;
                        result = rightSwap(result);
                    }
                    
            if (result.leftChild != null && result.leftChild.color == Color.RED && 
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                        needRebalance = true;
                        result = leftSwap(result);
                    }
                    
            if (result.leftChild != null && result.leftChild.color == Color.RED && 
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                        needRebalance = true;
                        colorSwap(result);
                    }
        }
        while (needRebalance);
        return result;
    }
    
    public void printTree () {
        printTree(root);
    }

    private void printTree (Node node){
        if (node != null) {
            //printTree(node.leftChild);
            System.out.println(node);
            //printTree(node.rightChild);
        }
    }
        
    private class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;
        
        @Override
        public String toString() {
            return "Node {\n" +
                    "\t value=" + value + "\n" +
                    "\t color=" + color + "\n" +
                    "\t leftChild=" + leftChild + "\n" +
                    "\t rightChild=" + rightChild + "\n" +
                    "}\n";
        }
        
    }
}