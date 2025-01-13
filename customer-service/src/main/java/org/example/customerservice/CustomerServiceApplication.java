package org.example.customerservice;

import lombok.Builder;
import org.example.customerservice.entities.Customers;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner (CustomerRepository customerRepository){

		return args ->{
			customerRepository.save(Customers.builder().name("imad").email("imad.lokman00@gmail.com")
					.build());
			customerRepository.save(Customers.builder().name("lokman").email("imad.lokman11@gmail.com")
					.build());
			customerRepository.save(Customers.builder().name("mohamed").email("imad.lokman22@gmail.com")
					.build());

			customerRepository.findAll().forEach(c->{
				System.out.println("==========");
				System.out.println(c.getName());
				System.out.println(c.getEmail());
				System.out.println(c.getId());
				System.out.println("==========");


			});


		};
	}


}
