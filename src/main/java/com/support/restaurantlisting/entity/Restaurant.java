package com.support.restaurantlisting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String address;
    private String name;
    private String city;
    private String restaurantdiscription;

}
