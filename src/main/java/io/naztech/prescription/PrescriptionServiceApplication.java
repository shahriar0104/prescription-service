package io.naztech.prescription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = { "io.naztech.prescription" })
//@EntityScan(basePackages = { "io.naztech.prescription.model", "io.naztech.prescription.dao" })
public class PrescriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrescriptionServiceApplication.class, args);
	}

}
