package com.example.cadastroartigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.cadastroartigos.models.repository"})
@EnableTransactionManagement
public class CadastroArtigosApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CadastroArtigosApplication.class, args);
	}
	
	

}
