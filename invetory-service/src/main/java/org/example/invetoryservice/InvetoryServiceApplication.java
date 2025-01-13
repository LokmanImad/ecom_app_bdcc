package org.example.invetoryservice;

import org.example.invetoryservice.Repository.ProductRepository;
import org.example.invetoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InvetoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvetoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return  args ->{
          productRepository.save(Product.builder().id(UUID.randomUUID().toString())
                  .Name("Ipone 16 pro ")
                  .price(10000)
                  .quantity(12)
                  .build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString())
                    .Name("Samsung 24")
                    .price(9000)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString())
                    .Name("Redmi")
                    .price(4000)
                    .quantity(20)
                    .build());

            productRepository.findAll().forEach(c->{
                System.out.println("============");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getPrice());
                System.out.println(c.getQuantity());
                System.out.println("============");



            });
        };

    }

}
