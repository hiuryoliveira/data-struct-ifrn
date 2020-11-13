package br.edu.ifrn.datastruct;

import br.edu.ifrn.datastruct.trees.*;

public class Main {

    public static void main(String[] args) throws EmptyTreeException, NodeHasChildrenExecption, TreeIsNotEmptyException, InvalidNodeException, BoundaryViolationException {
        // Inicializando a árvore.
        BSTree t = new BSTree();
        t.insert(10);
        System.out.println("Size after first insert: " + t.size());

        // Inicializando.
        t.insert(12);
        t.insert(13);
        t.insert(9);
        System.out.println("Size after four inserts: " + t.size());
        t.insert(8);
        t.insert(7);
        t.insert(14);
        t.insert(11);

        // Exibindo por ordenação.
        System.out.println("Show inOrder:");
        t.inOrder();

        System.out.println("Show posOrder:");
        t.posOrder();

        System.out.println("Show preOrder:");
        t.preOrder();

        System.out.println("Size after seven inserts: " + t.size());

        // Máximo e mínimo.
        System.out.println("Max value: " + t.max().getElement());
        System.out.println("Min value: " + t.min().getElement());

        // Exibindo árvore.
        t.drawTree(t);
    }
}
