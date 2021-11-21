package uk.co.michaelhorgan.stack.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used to return any error messages to the client. 
 * 
 * @author Michael Horgan
 *
 */
public class ErrorDTO {

  @JsonProperty
  String message;
  
  public ErrorDTO(String message) {
    this.message = message;
  }
  
}
