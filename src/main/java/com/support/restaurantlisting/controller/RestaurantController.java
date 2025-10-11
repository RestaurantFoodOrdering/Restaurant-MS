package com.support.restaurantlisting.controller;

import com.support.restaurantlisting.dto.RestaurantDto;
import com.support.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
     @Autowired
     public RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants()
    {
        List<RestaurantDto> allrestaurants=restaurantService.findALlRestaurants();
        return new ResponseEntity<>(allrestaurants,HttpStatus.OK);
    }

    @PostMapping ("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto)
    {
        RestaurantDto restaurantAdded=restaurantService.addrestaurantInDb(restaurantDto);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDto> fetchById(@PathVariable Integer id) {
        return restaurantService.fecthrestaurantsById(id);

    }
}
