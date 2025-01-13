package org.example.billingservice.web;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.feign.CustomerRestClient;
import org.example.billingservice.feign.ProductRestClient;
import org.example.billingservice.repositories.Billrepository;
import org.example.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    @Autowired
    private Billrepository billrepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/bills/{id}")
     public Bill getBill(@PathVariable long id){
         Bill bill = billrepository.findById(id).get();
         bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
         bill.getProductItems().forEach(productItem -> {
             productItem.setProduct(productRestClient.GetProductById(productItem.getProductId()));
         });
         return bill;
     };
}
