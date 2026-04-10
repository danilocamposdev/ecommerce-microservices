package com.danilocampos.storefront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class StorefrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorefrontApplication.class, args);
	}

	@Bean
	public RestClient restClient() {
		return RestClient.create(); // Cria o cliente diretamente
	}
}
