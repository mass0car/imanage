package uk.co.michaelhorgan.stack.util;

import java.util.Arrays;

public class Stack {
  
  /**
   * This is the default size of the array if no custom size is provided.
   */
  private final static int DEFAULT_SIZE = 20;
  
  /**
   * This stores the current number of items in the stack.
   */
  private int items = 0;
  
  /**
   * This stores the actual items in the stack. 
   */
  private int stack[];
  
  /**
   * This creates a stack with the default maximum size.
   */
  public Stack() {
    stack = new int[DEFAULT_SIZE];
  }
  
  /**
   * This create a stack with the maximum size as supplied by the maxSize parameter.
   * 
   * @param maxSize this sets the maximum size of the stack.
   */
  public Stack(int maxSize) {
    stack = new int[maxSize];
  }
  
  /**
   * This method is used to push a new integer value onto the stack. If the stack is full then a StackFullException is thrown.
   * 
   * @param value the value to push onto the stack.
   * @throws StackFullException thrown if the stack is full.
   */
  public void push(int value) throws StackFullException {
    if (items == stack.length) {
      throw new StackFullException();
    }
    stack[items++] = value;
  }
  
  /**
   * This method is used to pop the last value off the stack and return its value. If the stack is empty then a StackEmptyException is thrown.
   * 
   * @return the last value added to the stack.
   */
  public int pop() throws StackEmptyException {
    if (items == 0) {
      throw new StackEmptyException();
    }
    int value = stack[--items];
    return value;
  }
  
  /**
   * This method is used to retrieve the current state of the stack with all the current items. 
   * 
   * @return a copy of the current stack.
   */
  public int[] getStack() {
    int[] output = new int[items];
    for (int i = 0; i < items; i++) {
      output[i] = stack[i];
    }
    return output;
  }
  
  /**
   * This method return the current size of the stack.
   * 
   * @return the current size of the stack.
   */
  public int getSize() {
    return items;
  }
  
  /**
   * This method returns the maximum size of the stack.
   * 
   * @return the maximum size of the stack.
   */
  public int getMaxSize() {
    return stack.length;
  }
  
}
