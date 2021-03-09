package br.edu.ifrn.datastructure;

import br.edu.ifrn.datastructure.trees.*;

public class Main {

    public static void main(String[] args) throws EmptyTreeException, NodeHasChildrenExecption, TreeIsNotEmptyException, InvalidNodeException, BoundaryViolationException {
        BSTree t = new BSTree();

        t.insert(2);
        t.insert(5);
        t.insert(8);
        t.insert(10);
        t.insert(15);
        t.insert(22);
        
        System.out.println("Primeira versão da árvore binária de pesquisa:");
        t.drawTree(t);
    }
}
