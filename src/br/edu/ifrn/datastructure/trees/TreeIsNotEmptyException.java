package br.edu.ifrn.datastructure.trees;

public class TreeIsNotEmptyException extends Exception {

    public TreeIsNotEmptyException() {
        super("The root is not empty.");
    }

    public TreeIsNotEmptyException(String message) {
        super(message);
    }
}
