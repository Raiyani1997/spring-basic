package net.lemniscate.snippy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "net.lemniscate.snippy")
public class SnippyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnippyApplication.class, args);
	}

}
