package br.edu.ifrn.datastruct.trees;

public class BoundaryViolationException extends Exception {

    public BoundaryViolationException() {
        super("Boundary Violation.");
    }

    public BoundaryViolationException(String message) {
        super(message);
    }
}
