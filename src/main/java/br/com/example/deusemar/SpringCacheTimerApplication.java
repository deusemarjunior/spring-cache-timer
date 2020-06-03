package br.com.example.deusemar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableCaching
@EnableJpaRepositories
@SpringBootApplication
public class SpringCacheTimerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheTimerApplication.class, args);
	}

}
