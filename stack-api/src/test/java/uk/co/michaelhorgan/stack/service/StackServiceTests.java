package uk.co.michaelhorgan.stack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import uk.co.michaelhorgan.stack.util.Stack;

@SpringJUnitConfig
class StackServiceTests {
  
  @Mock
  Stack stack;
  
  @InjectMocks
  StackService service;
  
  @Test
  void testPushMethod() {
    service.push(1);
    verify(stack, times(1)).push(1);
  }
  
  @Test
  void testPopMethod() {
    int value = 1;
    when(stack.pop()).thenReturn(value);
    int returnValue = service.pop();
    assertEquals(returnValue, value);
    verify(stack, times(1)).pop();
  }
  
  @Test
  void testGetStackMethod() {
    int[] value = new int[] {1,2,3};
    when(stack.getStack()).thenReturn(value);
    int[] returnValue = service.getStack();
    assertEquals(returnValue.length, 3);
    assertEquals(returnValue[0], 1);
    assertEquals(returnValue[1], 2);
    assertEquals(returnValue[2], 3);
    verify(stack, times(1)).getStack();
  }
  
}
