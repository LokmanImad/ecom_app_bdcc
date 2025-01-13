package org.example.billingservice.feign;

import org.example.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("/customerses/{id}")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customerses")
    PagedModel<Customer> getAllcustomer();
}
