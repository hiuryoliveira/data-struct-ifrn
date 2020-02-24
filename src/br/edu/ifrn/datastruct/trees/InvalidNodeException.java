package br.edu.ifrn.datastruct.trees;

public class InvalidNodeException extends Exception {

    public InvalidNodeException() {
        super("Invalid Node.");
    }

    public InvalidNodeException(String message) {
        super(message);
    }
}
