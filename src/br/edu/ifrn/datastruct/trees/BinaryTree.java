package br.edu.ifrn.datastruct.trees;

public interface BinaryTree<E> extends Tree<E> {

    /**
     * Retorna o filho da esquerda.
     *
     * @param v
     * @return Node node.
     * @throws InvalidNodeException
     * @throws BoundaryViolationException
     */
    Node left(Node v) throws InvalidNodeException, BoundaryViolationException;

    /**
     * Retorna o filho da direita.
     *
     * @param v
     * @return Node node.
     * @throws InvalidNodeException
     * @throws BoundaryViolationException
     */
    Node right(Node v) throws InvalidNodeException, BoundaryViolationException;

    /**
     * Retorna se o nó tem filho da esquerda.
     *
     * @param v
     * @return boolean
     * @throws InvalidNodeException
     */
    boolean hasLeft(Node v) throws InvalidNodeException;

    /**
     * Retorna se o nó tem filho da direita.
     *
     * @param v
     * @return boolean
     * @throws InvalidNodeException
     */
    boolean hasRight(Node v) throws InvalidNodeException;
}
