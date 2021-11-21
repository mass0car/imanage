package uk.co.michaelhorgan.stack.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import uk.co.michaelhorgan.stack.util.StackEmptyException;
import uk.co.michaelhorgan.stack.util.StackFullException;

/**
 * This class is used to handle any exceptions that are likely to be thrown by the StackApi.
 * 
 * @author Michael Horgan
 *
 */
@ControllerAdvice
public class StackApiExceptionHandler {
  
  @ExceptionHandler(value = StackFullException.class)
  public ResponseEntity<ErrorDTO> handleStackFull() {
    return new ResponseEntity<ErrorDTO>(new ErrorDTO("The stack is full."), HttpStatus.UNPROCESSABLE_ENTITY);
  }
  
  @ExceptionHandler(value = StackEmptyException.class)
  public ResponseEntity<ErrorDTO> handleStackEmpty() {
    return new ResponseEntity<ErrorDTO>(new ErrorDTO("The stack is empty."), HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorDTO> handleInvalidType() {
    return new ResponseEntity<ErrorDTO>(new ErrorDTO("The value supplied was not an integer."), HttpStatus.EXPECTATION_FAILED);
  }
}
