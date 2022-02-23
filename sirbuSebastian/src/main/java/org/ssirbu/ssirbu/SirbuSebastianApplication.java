package org.ssirbu.ssirbu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SirbuSebastianApplication {

	public static void main(String[] args) {
		SpringApplication.run(SirbuSebastianApplication.class, args);
	}

}
