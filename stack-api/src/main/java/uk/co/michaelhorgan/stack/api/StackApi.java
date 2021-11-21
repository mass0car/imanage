package uk.co.michaelhorgan.stack.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.michaelhorgan.stack.service.StackService;

/**
 * This controller is used to provide HTTP end-point to interact with the applications stack. 
 * 
 * @author Michael Horgan
 *
 */
@CrossOrigin("*") // TODO: Needs to be removed. Not best practice added to simplify UI interaction.
@RestController
public class StackApi {
  
  @Autowired 
  StackService stackService;
  
  /**
   * This method defines the end-point GET /stack. This is used to retrieve the current state of the stack.
   *  
   * @return 
   */
  @GetMapping(value = "/stack")
  public ResponseEntity<StackDTO> get() {
    int[] stack = stackService.getStack();
    return new ResponseEntity<StackDTO>(new StackDTO(stack), HttpStatus.OK);
  }
  
  /**
   * This method defines the end-point GET /stack/pop. This is used to pop the last value off of the stack and return it 
   * to the client along with the rest of the stack. 
   *  
   * @return 
   */
  @GetMapping(value = "/stack/pop")
  public ResponseEntity<PopDTO> pop() {
    Integer value = stackService.pop();
    int[] stack = stackService.getStack();
    return new ResponseEntity<PopDTO>(new PopDTO(value, stack), HttpStatus.OK);
  }
  
  /**
   * This method defines the end-point POST /stack/push/{value}. This is used to push the supplied {value} onto the stack,
   * which is then returned to the client.
   * 
   * @param value the value to pop onto the stack.
   * @return
   */
  @PostMapping(value = "/stack/push/{value}")
  public ResponseEntity<StackDTO> push(@PathVariable Integer value) {
    stackService.push(value);
    int[] stack = stackService.getStack();
    return new ResponseEntity<StackDTO>(new StackDTO(stack), HttpStatus.OK);
  }
  
}
