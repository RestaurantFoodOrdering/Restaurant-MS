package com.support.restaurantlisting.Mapper;

import com.support.restaurantlisting.dto.RestaurantDto;
import com.support.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper Instance= Mappers.getMapper(RestaurantMapper.class);

    public RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
    public Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);

}
