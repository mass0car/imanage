package uk.co.michaelhorgan.stack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.michaelhorgan.stack.util.Stack;

@Service
public class StackService {
  
  @Autowired
  private Stack stack;
  
  /**
   * Added a value to the stack.
   * 
   * @param value
   */
  public void push(int value) {
    stack.push(value);
  }
  
  /**
   * Removes a value from the stack and returns it.
   * 
   * @return
   */
  public int pop() {
    return stack.pop();
  }
  
  /**
   * Retrieves the current state of the stack.
   * 
   * @return
   */
  public int[] getStack() {
    return stack.getStack();
  }
}
