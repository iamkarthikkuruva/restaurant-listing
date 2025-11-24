package com.karthik.restaurant_listing.mapper;

import com.karthik.restaurant_listing.dto.RestaurantDTO;
import com.karthik.restaurant_listing.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
        RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

        Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);
        RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);

}
