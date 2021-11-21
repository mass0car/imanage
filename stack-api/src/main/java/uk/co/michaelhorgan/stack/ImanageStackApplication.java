package uk.co.michaelhorgan.stack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import uk.co.michaelhorgan.stack.util.Stack;

@SpringBootApplication
public class ImanageStackApplication {

    public static void main(String[] args) {
		SpringApplication.run(ImanageStackApplication.class, args);
	}

    @Value(value = "${stack-size}")
    Integer stackSize;
    
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Stack stack() {
	  return new Stack(stackSize);
	}
	
}
