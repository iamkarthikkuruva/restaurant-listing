package com.karthik.restaurant.mapper;

import com.karthik.restaurant.dto.RestaurantDTO;
import com.karthik.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
        RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

        Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);
        RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
