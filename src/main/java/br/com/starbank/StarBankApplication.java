package br.com.starbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
public class StarBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarBankApplication.class, args);
	}

}
