package br.edu.ifrn.datastructure.trees;

public class InvalidNodeException extends Exception {

    public InvalidNodeException() {
        super("Invalid Node.");
    }

    public InvalidNodeException(String message) {
        super(message);
    }
}
