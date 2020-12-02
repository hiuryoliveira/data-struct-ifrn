package br.edu.ifrn.datastructure.trees;

public class AVLTree extends BSTree {

    /**
     *
     * @param element
     * @param node
     */
    private void insert(Object element, Node node) {
        if (node.isEmpty()) {
            node.setElement(element);
            node.setLeft(new Node(node, null, null, null));
            node.setRight(new Node(node, null, null, null));
            node.getLeft().setParent(node);
            node.getRight().setParent(node);
        } else {
            if (node.getElement().compareTo(element) < 0) {
                insert(element, node.getRight());
            } else if (node.getElement().compareTo(element) > 0) {
                insert(element, node.getLeft());
            }
        }
    }


    /**
     *
     * @param node
     */
    protected void rebalanceUp(Node node) {
        if (node == null || node.isEmpty()) return;
        rebalance(node);
        if (node.getParent() != null) {
            rebalanceUp(node.getParent());
        }
    }

    /**
     * Calcular o fator de balanceamento da árvore.
     * @param node
     * @return
     */
    protected int calculateBalance(Node node) {
        if (node == null || node.isEmpty()) return 0;
        return height(node.getRight()) - height(node.getLeft());
    }

    /**
     * Rebalenceamento da árvore.
     * @param node
     */
    protected void rebalance(Node node) throws EmptyTreeException {
        int balanceOfNode = calculateBalance(node);

        if (balanceOfNode < -1) {
            if (calculateBalance(node.getLeft()) > 0) {
                leftRotation(node.getLeft());
            }
            rightRotation(node);
        } else if (balanceOfNode > 1) {
            if (calculateBalance(node.getRight()) < 0) {
                rightRotation(node.getRight());
            }
            leftRotation(node);
        }
    }

    /**
     * Altura da árvore.
     * @param right
     * @return
     */
    private int height(Node right) {
        return 0;
    }

    /**
     * Rotacionar para a esquerda.
     * @param node
     */
    private void leftRotation(Node node) throws EmptyTreeException {
        Node nodeRight = node.getRight();

        node.setRight(nodeRight.getLeft());

        nodeRight.getLeft().setParent(node);
        nodeRight.setLeft(node);
        nodeRight.setParent(node.getParent());
        node.setParent(nodeRight);

        if (node != this.root()) {
            if (nodeRight.getParent().getLeft() == node) {
                nodeRight.getParent().setLeft(nodeRight);
            } else {
                nodeRight.getParent().setRight(nodeRight);
            }
        } else {
            this.root = (Node) nodeRight;
        }
    }

    /**
     * Rotacionar para a direita.
     * @param node
     */
    private void rightRotation(Node node) throws EmptyTreeException {
        Node nodeLeft = node.getLeft();

        node.setLeft(nodeLeft.getRight());

        nodeLeft.getRight().setParent(node);
        nodeLeft.setRight(node);
        nodeLeft.setParent(node.getParent());
        node.setParent(nodeLeft);

        if (node != this.root()) {
            if (nodeLeft.getParent().getLeft() == node) {
                nodeLeft.getParent().setLeft(nodeLeft);
            } else {
                nodeLeft.getParent().setRight(nodeLeft);
            }
        } else {
            this.root = nodeLeft;
        }
    }
}
