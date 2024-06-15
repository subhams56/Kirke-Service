package com.kirke.service;

import com.kirke.service.service.KirkePulsarListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.pulsar.annotation.EnablePulsar;

@SpringBootApplication
@EnablePulsar
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner kirkePulsarRunner(KirkePulsarListener kirkePulsarListener) {
		return args -> {
			// Execute KirkePulsarListener.startListener() method on application startup
			kirkePulsarListener.startListener();
		};
	}

}
