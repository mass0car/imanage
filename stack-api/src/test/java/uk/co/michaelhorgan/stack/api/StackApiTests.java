package uk.co.michaelhorgan.stack.api;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import uk.co.michaelhorgan.stack.service.StackService;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
class StackApiTests {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  StackService stackService;
  
  @Test
  void testGet() throws Exception {
    this.mockMvc.perform(get("/stack"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().json("{stack: []}"));
  }
  
  @Test
  @DirtiesContext
  void testGet_WithContents() throws Exception {
    stackService.push(1);
    this.mockMvc.perform(get("/stack"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().json("{stack: [1]}"));
  }
  
  @Test
  @DirtiesContext
  void testPush() throws Exception {
    this.mockMvc.perform(post("/stack/push/123"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().json("{stack: [123]}"));
  }
  
  @Test
  @DirtiesContext
  void testPush_WithFullStack() throws Exception {
    stackService.push(1);
    this.mockMvc.perform(post("/stack/push/123"))
      .andDo(print())
      .andExpect(status().isUnprocessableEntity())
      .andExpect(content().string(containsStringIgnoringCase("message")))
      .andExpect(content().string(containsStringIgnoringCase("full")));
  }
  
  @Test
  @DirtiesContext
  void testPush_WithNonInteger() throws Exception {
    stackService.push(1);
    this.mockMvc.perform(post("/stack/push/abc"))
      .andDo(print())
      .andExpect(status().isExpectationFailed())
      .andExpect(content().string(containsStringIgnoringCase("message")))
      .andExpect(content().string(containsStringIgnoringCase("not an integer")));
  }
  
  @Test
  @DirtiesContext
  void testPop() throws Exception {
    stackService.push(123);
    this.mockMvc.perform(get("/stack/pop"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().json("{value: 123, stack: []}"));
  }
  
  @Test
  void testPop_WithEmptyStack() throws Exception {
    this.mockMvc.perform(get("/stack/pop"))
      .andDo(print())
      .andExpect(status().isNotFound())
      .andExpect(content().string(containsStringIgnoringCase("message")))
      .andExpect(content().string(containsStringIgnoringCase("empty")));
  }
  
}
