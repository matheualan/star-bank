package br.com.starbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StarBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarBankApplication.class, args);
	}

}
