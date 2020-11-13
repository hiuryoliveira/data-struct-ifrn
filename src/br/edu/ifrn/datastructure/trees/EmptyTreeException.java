package br.edu.ifrn.datastructure.trees;

public class EmptyTreeException extends Exception {
    
    public EmptyTreeException() {
        super("Empty Tree.");
    }

    public EmptyTreeException(String message) {
        super(message);
    }
}
