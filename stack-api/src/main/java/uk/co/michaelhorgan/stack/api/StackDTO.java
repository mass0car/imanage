package uk.co.michaelhorgan.stack.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used to return the stack to the client.
 * 
 * @author Michael Horgan
 *
 */
public class StackDTO {

  @JsonProperty
  int[] stack;
  
  public StackDTO(int[] stack) {
    this.stack = stack;
  }
  
}
