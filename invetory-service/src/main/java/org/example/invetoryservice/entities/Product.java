package org.example.invetoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder

public class Product {

    @Id
    private String id;
    private String Name;
    private double price ;
    private int quantity ;

}
