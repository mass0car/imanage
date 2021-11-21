package uk.co.michaelhorgan.stack.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class StackTests {
  
  @Test
  void testPush() {
    int value = 12;
    Stack stack = new Stack();
    try {
      stack.push(value);
    } catch (StackFullException e) {
      e.printStackTrace();
    }
    assertEquals(stack.getSize(), 1);
    int[] newStack = stack.getStack();
    assertEquals(newStack.length, 1);
    assertEquals(newStack[0], value);
  }
  
  @Test 
  void testPop() {
    int value1 = 15;
    int value2 = 63;
    Stack stack = new Stack();
    try {
      stack.push(value1);
      stack.push(value2);
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertEquals(stack.getSize(), 2);
    assertEquals(stack.pop(), value2);
    assertEquals(stack.getSize(), 1);
    assertEquals(stack.pop(), value1);
    assertEquals(stack.getSize(), 0);
  }

  @Test
  void testCustomSize() {
    Stack stack = new Stack(5);
    assertEquals(stack.getMaxSize(), 5);
  }
  
  @Test
  void testStackFull_DefaultSize() {
    Stack stack = new Stack();
    Exception exception = assertThrows(StackFullException.class, () -> {
      IntStream.range(0, stack.getMaxSize()+1).forEach(stack::push);      
    });
  }
  
}
