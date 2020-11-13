package br.edu.ifrn.datastructure.trees;

import java.util.Iterator;

public interface Tree<E> {

    /**
     * Retorna a quantidade de nós da árvore.
     *
     * @return int size.
     */
    int size();

    /**
     * Retorna se a árvore está vazia.
     *
     * @return boolean empty.
     */
    boolean isEmpty();

    /**
     * Retorna um iterador sobre os elementos armazenados na árvore.
     *
     * @return Iterator nodes.
     */
    Iterator<E> iterator();

    /**
     * Retorna os nós de maneira iterável.
     *
     * @return Node nodes.
     */
    Iterable<Node> nodes();

    /**
     * Substitui o elemento de um determinado nó.
     *
     * @param v
     * @param e
     * @return Node node.
     */
    E replace(Node v, E e);

    /**
     * Retorna o nó raiz de uma árvore.
     *
     * @return Node node.
     * @throws EmptyTreeException
     */
    Node root() throws EmptyTreeException;

    /**
     * Retorna o pai de um dado nó.
     *
     * @param v
     * @return Node node.
     * @throws InvalidNodeException
     * @throws BoundaryViolationException
     */
    Node parent(Node v) throws InvalidNodeException, BoundaryViolationException;

    /**
     * Retorna uma coleção iterpavel dos filhos de um determinado nó.
     *
     * @param v
     * @return Iterable nodes.
     * @throws InvalidNodeException
     */
    Iterator<Node> children(Node v) throws InvalidNodeException, BoundaryViolationException;

    /**
     * Retorna se um dado nó é interno.
     *
     * @param v
     * @return boolean internal
     * @throws InvalidNodeException
     */
    boolean isInternal(Node v) throws InvalidNodeException;

    /**
     * Retorna se um dado nó é externo.
     *
     * @param v
     * @return boolean external.
     * @throws InvalidNodeException
     */
    boolean isExternal(Node v) throws InvalidNodeException;

    /**
     * Retorna se um dado nó é raiz da árvore.
     *
     * @param v
     * @return boolean root.
     * @throws InvalidNodeException
     */
    boolean isRoot(Node v) throws InvalidNodeException, EmptyTreeException;
}
