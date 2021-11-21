package uk.co.michaelhorgan.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uk.co.michaelhorgan.stack.service.StackService;

@SpringBootTest
class ImanageStackApplicationTests {

    @Autowired
    StackService stackService;
  
	@Test
	void contextLoads() {
	  assertThat(stackService).isNotNull();
	}

}
