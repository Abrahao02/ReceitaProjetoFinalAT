package br.edu.infnet.appReceitaProjetobloco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppReceitaProjetoblocoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppReceitaProjetoblocoApplication.class, args);
	}

}
