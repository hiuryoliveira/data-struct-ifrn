package br.edu.ifrn.datastruct.trees;

public class BSTree extends LinkedBinaryTree {

    private int[][] m;
    private int count = 0;

    public BSTree() {
        new LinkedBinaryTree();
    }

    public void inOrder() throws InvalidNodeException {
        inOrder(root);
    }

    public void posOrder() throws InvalidNodeException {
        posOrder(root);
    }

    public void preOrder() throws InvalidNodeException {
        preOrder(root);
    }

    public Node min() {
        Node current = root;
        Node before = null;
        while (current != null) {
            before = current;
            current = current.getLeft();
        }
        return before;
    }

    public Node max() {
        Node current = root;
        Node before = null;
        while (current != null) {
            before = current;
            current = current.getRight();
        }
        return before;
    }

    /**
     * Insere uma nova folha na árvore de modo que a árvore continue sendo de busca.
     *
     * @param key
     */
    public Node insert(Object key) throws TreeIsNotEmptyException, NodeHasChildrenExecption, InvalidNodeException, EmptyTreeException {
        if (root == null) {
            return addRoot(key);
        } else {
            Node current = root();
            Node before;

            while (true) {
                before = current;
                if (((Integer) key).intValue() <= ((Integer) current.getElement()).intValue()) {
                    current = current.getLeft();
                    if (current == null) {
                        return insertLeft(before, key);
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        return insertRight(before, key);
                    }
                }
            }
        }
    }

    /**
     * Buscando chave dentro de uma árvore binária.
     *
     * @param key
     * @return
     * @throws EmptyTreeException
     */
    public Node get(Object key) throws EmptyTreeException, InvalidNodeException {
        return search(root(), key);
    }

    /**
     * Removendo elemento dentro da árvore binária de pesquisa.
     *
     * @param key
     */
    public void remove(Object key) throws EmptyTreeException, InvalidNodeException, NodeHasChildrenExecption {
        Node removed = get(key);
        remove(removed);
    }

    /**
     * Buscar chave dentro da árvore.
     *
     * @param v
     * @param key
     * @return
     */
    private Node search(Node v, Object key) throws InvalidNodeException {
        if (((Integer) v.getElement()).intValue() < ((Integer) key).intValue()) {
            if (hasLeft(v)) return search(v.getLeft(), key);
        } else {
            if (hasRight(v)) return search(v.getRight(), key);
        }
        return v;
    }


    /**
     * Exibindo a árvore de maneira de que possamos ver os elementos dentro da árvore.
     */
    public void drawTree(BSTree t) throws EmptyTreeException, BoundaryViolationException, InvalidNodeException {
        System.out.println("-----------------");
        System.out.println("Imprimindo árvore");

        // Tamanho da matriz.
        int size = t.size();
        int h = t.height(t, t.root()) + 1;
        m = new int[h][size];

        // Adicionando método.
        inOrderDrawTree(t, t.root());

        // Percorrer matriz.
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < size; j++) {
                if (m[i][j] != 0) {
                    System.out.print(m[i][j] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.print("\n");
        }

        System.out.println("-----------------");
    }

    public void inOrderDrawTree(BSTree t, Node node) throws BoundaryViolationException, InvalidNodeException, EmptyTreeException {
        if (node != null) {
            inOrderDrawTree(t, node.getLeft());
            // m[t.height(t, node)][t.depth(t, node)] = (int) node.getElement();
            m[t.depth(t, node)][count++] = (int) node.getElement();
            inOrderDrawTree(t, node.getRight());
        }
    }
}
