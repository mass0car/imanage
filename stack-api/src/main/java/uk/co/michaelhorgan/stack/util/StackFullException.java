package uk.co.michaelhorgan.stack.util;


public class StackFullException extends RuntimeException {

  private static final long serialVersionUID = -6644012306137232682L;
  
  public StackFullException() {
    super("Stack Full");
  }

}
