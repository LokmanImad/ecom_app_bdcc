package org.example.billingservice.feign;

import org.example.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invetory-service")
public interface ProductRestClient {

    @GetMapping("/products/{id}")
    Product GetProductById(@PathVariable String id);

    @GetMapping("/products")
    PagedModel<Product> getAllprodcts();
}
