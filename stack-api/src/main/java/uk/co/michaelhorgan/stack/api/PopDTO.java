package uk.co.michaelhorgan.stack.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used to return the popped value and the rest of the stack to the client.
 * 
 * @author Michael Horgan
 *
 */
public class PopDTO extends StackDTO {
  
  @JsonProperty
  int value;
  
  public PopDTO(int value, int[] stack) {
    super(stack);
    this.value = value;
  }
  
}
