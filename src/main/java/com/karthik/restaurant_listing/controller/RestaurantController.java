package com.karthik.restaurant_listing.controller;

import com.karthik.restaurant_listing.dto.RestaurantDTO;
import com.karthik.restaurant_listing.entity.Restaurant;
import com.karthik.restaurant_listing.service.RestaurantSericve;
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
    private RestaurantSericve restaurantSericve;

    @GetMapping("fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
        List<RestaurantDTO> allRestaurants = restaurantSericve.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO restaurantAdded = restaurantSericve.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Integer id) {
        return restaurantSericve.fetchRestaurantById(id);
    }
}



