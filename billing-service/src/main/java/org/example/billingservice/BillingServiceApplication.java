package org.example.billingservice;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.entities.ProductItem;
import org.example.billingservice.feign.CustomerRestClient;
import org.example.billingservice.feign.ProductRestClient;
import org.example.billingservice.model.Customer;
import org.example.billingservice.model.Product;
import org.example.billingservice.repositories.Billrepository;
import org.example.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(Billrepository billrepository , ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
											ProductRestClient productRestClient
										){
		return args -> {
			Collection<Customer> customers = customerRestClient.getAllcustomer().getContent();
			Collection<Product> products = productRestClient.getAllprodcts().getContent();

			customers.forEach(customer ->{
				Bill bill = Bill.builder()
						.billingDate(new Date())
						.customerId(customer.getId())
						.build();
				billrepository.save(bill);
				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder()
							.productId(product.getId())
							.bill(bill)
							.quantite(1+new Random().nextInt(10))
							.unitPrice(product.getPrice())
							.build();
					productItemRepository.save(productItem);
				});

			});

		};

	}
}
