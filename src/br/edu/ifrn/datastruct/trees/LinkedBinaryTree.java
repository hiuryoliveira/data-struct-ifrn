package br.edu.ifrn.datastruct.trees;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedBinaryTree<E> implements BinaryTree<E> {

    protected Node root;
    private int size;

    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * Método auxiliar.
     * Verifica de nó é válido ou não.
     *
     * @param v
     * @return boolean.
     */
    public Node checkNode(Node v) throws InvalidNodeException {
        if (v.getElement() == null) {
            throw new InvalidNodeException("Invalid node.");
        }
        return v;
    }

    /**
     * @param node
     * @throws InvalidNodeException
     */
    protected void preOrder(Node node) throws InvalidNodeException {
        if (node != null) {
            System.out.println(node.getElement());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * @param node
     * @throws InvalidNodeException
     */
    protected void posOrder(Node node) throws InvalidNodeException {
        if (node != null) {
            posOrder(node.getLeft());
            posOrder(node.getRight());
            System.out.println(node.getElement());
        }
    }

    /**
     * @param node
     * @throws InvalidNodeException
     */
    protected void inOrder(Node node) throws InvalidNodeException {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getElement());
            inOrder(node.getRight());
        }
    }

    /**
     * Retorna a profundidade do nó em questão da árvore.
     *
     * @param t
     * @param v
     * @return
     * @throws EmptyTreeException
     * @throws InvalidNodeException
     * @throws BoundaryViolationException
     */
    protected int depth(Tree<E> t, Node v) throws EmptyTreeException, InvalidNodeException, BoundaryViolationException {
        if (t.isRoot(v))
            return 0;
        return 1 + depth(t, t.parent(v));
    }

    /**
     * @param t
     * @param v
     * @return
     */
    protected int height(Tree<E> t, Node v) throws InvalidNodeException, BoundaryViolationException {
        if (t.isExternal(v))
            return 0;
        int h = 0;
        for (Iterator<Node> it = t.children(v); it.hasNext(); ) {
            Node w = it.next();
            h = Math.max(h, height(t, w));
        }
        return h + 1;
    }

    /**
     * Cria e retorna um nó novo, r, que armazena o elemento e torna r a raiz da árvore.
     *
     * @param r
     * @throws TreeIsNotEmptyException
     */
    protected Node addRoot(Object r) throws TreeIsNotEmptyException {
        if (!isEmpty()) {
            throw new TreeIsNotEmptyException("Tree is not empty.");
        }
        size = 1;
        root = new Node(null, r, null, null);
        return root;
    }

    /**
     * Cria e retorna um novo nó, w, que armazena o elemento e, acrescenta w como o filho da esquerda de v e retorna w;
     * um erro ocorre se v já tem um filho a esquerda.
     *
     * @param node
     * @param object
     * @return Node node.
     * @throws NodeHasChildrenExecption
     */
    protected Node insertLeft(Node node, Object object) throws NodeHasChildrenExecption, InvalidNodeException {
        checkNode(node);
        Node w = new Node(node, object, null, null);
        if (hasLeft(node)) {
            throw new NodeHasChildrenExecption("They already have a left child.");
        }
        node.setLeft(w);
        size++;
        return w;
    }

    /**
     * Cria e retorna um novo nó, w, que armazena o elemento e, acrescenta w como o filho da direita de v e retorna w;
     * um erro ocorre se v já tem um filho a direita.
     *
     * @param node
     * @param object
     * @return Node node.
     * @throws NodeHasChildrenExecption
     */
    protected Node insertRight(Node node, Object object) throws NodeHasChildrenExecption, InvalidNodeException {
        checkNode(node);
        Node w = new Node(node, object, null, null);
        if (hasRight(node)) {
            throw new NodeHasChildrenExecption("They already have a right child.");
        }
        node.setRight(w);
        size++;
        return w;
    }

    /**
     * Remove o nó v, substituindo-o por eu filho, se houver algum, e retorna o elemento armazenado em v; um erro ocorre se v tem dois filhos.
     *
     * @param node
     * @return Object object.
     * @throws NodeHasChildrenExecption
     */
    protected Object remove(Node node) throws NodeHasChildrenExecption, InvalidNodeException {
        Node vv = checkNode(node);
        Node leftNode = vv.getLeft();
        Node rightNode = vv.getRight();

        if (leftNode != null || rightNode != null) {
            throw new NodeHasChildrenExecption("They have a right and left child.");
        }
        Node ww;
        if (leftNode != null) {
            ww = leftNode;
        } else if (rightNode != null) {
            ww = rightNode;
        } else {
            ww = null;
        }

        if (vv == root) {
            if (ww != null)
                ww.setParent(null);
            root = vv;
        } else {
            Node uu = vv.getParent();
            if (vv == vv.getLeft())
                uu.setLeft(ww);
            else
                uu.setRight(ww);
            if (ww != null)
                ww.setParent(uu);
        }

        size--;
        return node.getElement();
    }

    /**
     * Conecta t1 e t2 respectivamente, como as subárvores da esquerda e da direita do nó externo v;
     * uma condição de erro se verifica se v não é externo.
     *
     * @param node
     * @param t1
     * @param t2
     * @throws BoundaryViolationException
     */
    protected void attach(Node node, BinaryTree<E> t1, BinaryTree<E> t2) throws BoundaryViolationException, InvalidNodeException, EmptyTreeException {
        Node vv = checkNode(node);
        if (isInternal(node)) {
            throw new InvalidNodeException("Cannot attach from internal node.");
        }

        if (!t1.isEmpty()) {
            Node r1 = checkNode(t1.root());
            vv.setLeft(r1);
            r1.setParent(vv);
        }

        if (!t2.isEmpty()) {
            Node r2 = checkNode(t2.root());
            vv.setRight(r2);
            r2.setParent(vv);
        }
    }

    @Override
    public Node left(Node v) throws InvalidNodeException, BoundaryViolationException {
        Node vv = checkNode(v);
        Node leftNode = vv.getLeft();
        if (leftNode == null) {
            throw new BoundaryViolationException("No children left.");
        }
        return leftNode;
    }

    @Override
    public Node right(Node v) throws InvalidNodeException, BoundaryViolationException {
        Node vv = checkNode(v);
        Node rightNode = vv.getRight();
        if (rightNode == null) {
            throw new BoundaryViolationException("No children right.");
        }
        return rightNode;
    }

    @Override
    public boolean hasLeft(Node v) throws InvalidNodeException {
        Node vv = checkNode(v);
        Node leftNode = vv.getLeft();
        return (leftNode != null);
    }

    @Override
    public boolean hasRight(Node v) throws InvalidNodeException {
        Node vv = checkNode(v);
        Node rightNode = vv.getRight();
        return (rightNode != null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Node> nodes() {
        return null;
    }

    @Override
    public E replace(Node v, E e) {
        return null;
    }

    @Override
    public Node root() throws EmptyTreeException {
        if (root == null) {
            throw new EmptyTreeException("The tree is empty.");
        }
        return root;
    }

    @Override
    public Node parent(Node v) throws InvalidNodeException, BoundaryViolationException {
        checkNode(v);
        Node parent = v.getParent();
        if (parent == null) {
            throw new BoundaryViolationException("No parent.");
        }
        return parent;
    }

    @Override
    public Iterator<Node> children(Node v) throws InvalidNodeException, BoundaryViolationException {
        ArrayList<Node> children = new ArrayList<Node>();
        if (hasLeft(v))
            children.add(left(v));
        if (hasRight(v))
            children.add(right(v));
        return children.iterator();
    }

    @Override
    public boolean isInternal(Node v) throws InvalidNodeException {
        return (hasLeft(v) || hasRight(v));
    }

    @Override
    public boolean isExternal(Node v) throws InvalidNodeException {
        return (!hasLeft(v) && !hasRight(v));
    }

    @Override
    public boolean isRoot(Node v) throws InvalidNodeException, EmptyTreeException {
        checkNode(v);
        return (v == root());
    }
}
