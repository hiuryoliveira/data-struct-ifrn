package br.edu.ifrn.datastructure.trees;

public class Node {

    private Node parent;
    private Object element;
    private Node left;
    private Node right;

    public Node(Node parent, Object element, Node left, Node right) {
        this.parent = parent;
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isEmpty() {
        return this.getElement() == null;
    }
}
