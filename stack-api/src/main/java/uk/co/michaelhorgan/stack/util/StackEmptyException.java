package uk.co.michaelhorgan.stack.util;


public class StackEmptyException extends RuntimeException {

  private static final long serialVersionUID = 1886315859792028671L;

  public StackEmptyException() {
    super("Stack Empty");
  }
  
}
