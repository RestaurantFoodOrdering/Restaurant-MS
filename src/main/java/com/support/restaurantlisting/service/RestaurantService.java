package com.support.restaurantlisting.service;

import com.support.restaurantlisting.Mapper.RestaurantMapper;
import com.support.restaurantlisting.dto.RestaurantDto;
import com.support.restaurantlisting.entity.Restaurant;
import com.support.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    public RestaurantRepo restaurantRepo;

    public List<RestaurantDto> findALlRestaurants() {

        List<Restaurant> restaurants=restaurantRepo.findAll();
        List<RestaurantDto> restaurantDtos=restaurants.stream().map(restaurant -> RestaurantMapper.Instance.mapRestaurantToRestaurantDto(restaurant)).collect(Collectors.toList());


        return restaurantDtos;
    }

    public RestaurantDto addrestaurantInDb(RestaurantDto restaurantDto) {
       Restaurant savedrestaurant= restaurantRepo.save(RestaurantMapper.Instance.mapRestaurantDtoToRestaurant(restaurantDto));
       return RestaurantMapper.Instance.mapRestaurantToRestaurantDto(savedrestaurant);
    }

    public ResponseEntity<RestaurantDto> fecthrestaurantsById(Integer id) {

        Optional<Restaurant> restaurant=restaurantRepo.findById(id);
        if(restaurant.isPresent())
            return new ResponseEntity<>(RestaurantMapper.Instance.mapRestaurantToRestaurantDto(restaurant.get()), HttpStatus.OK);

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
