package com.support.restaurantlisting.controller;

import com.support.restaurantlisting.dto.RestaurantDto;
import com.support.restaurantlisting.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantControllerTest {

    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantService restaurantService;
     @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAllRestaurants()
    {
        // Mock the service behavior
        List<RestaurantDto> mockRestaurants = Arrays.asList(
                new RestaurantDto(1, "Restaurant 1", "Address 1", "city 1", "Desc 1"),
                new RestaurantDto(2, "Restaurant 2", "Address 2", "city 2", "Desc 2")
        );
        when(restaurantService.findALlRestaurants()).thenReturn(mockRestaurants);
        ResponseEntity<List<RestaurantDto>> response=restaurantController.fetchAllRestaurants();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurants, response.getBody());

        // Verify that the service method was called
        verify(restaurantService, times(1)).findALlRestaurants();
    }

    @Test
    public void testAddRestaurant() {
        // Create a mock restaurant to be saved
        RestaurantDto mockRestaurant =  new RestaurantDto(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");

        // Mock the service behavior
        when(restaurantService.addrestaurantInDb(mockRestaurant)).thenReturn(mockRestaurant);

        // Call the controller method
        ResponseEntity<RestaurantDto> response = restaurantController.addRestaurant(mockRestaurant);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockRestaurant, response.getBody());

        // Verify that the service method was called
        verify(restaurantService, times(1)).addrestaurantInDb(mockRestaurant);
    }

    @Test
    public void testFetchById() {
        // Create a mock restaurant ID
        Integer mockRestaurantId = 1;

        // Create a mock restaurant to be returned by the service
        RestaurantDto mockRestaurant = new RestaurantDto(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");

        // Mock the service behavior
        when(restaurantService.fecthrestaurantsById(mockRestaurantId)).thenReturn(new ResponseEntity<>(mockRestaurant, HttpStatus.OK));

        // Call the controller method
        ResponseEntity<RestaurantDto> response = restaurantController.fetchById(mockRestaurantId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurant, response.getBody());

        // Verify that the service method was called
        verify(restaurantService, times(1)).fecthrestaurantsById(mockRestaurantId);
    }
}
