package PrubaXolitTecnica.PrubaXolitTecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "PrubaXolitTecnica.PrubaXolitTecnica.model")
@EnableJpaRepositories(basePackages = "PrubaXolitTecnica.PrubaXolitTecnica.adapter.out")
public class PrubaXolitTecnicaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PrubaXolitTecnicaApplication.class, args);
	}

}
