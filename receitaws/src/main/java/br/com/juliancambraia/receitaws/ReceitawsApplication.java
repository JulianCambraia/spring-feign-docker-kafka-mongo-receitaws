package br.com.juliancambraia.receitaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReceitawsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitawsApplication.class, args);
	}

}
