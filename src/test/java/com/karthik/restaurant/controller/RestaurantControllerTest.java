package com.karthik.restaurant.controller;

import com.karthik.restaurant.dto.RestaurantDTO;
import com.karthik.restaurant.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantControllerTest {

    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    private static final RestaurantDTO RESTAURANT_1 = new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");
    private static final RestaurantDTO RESTAURANT_2 = new RestaurantDTO(2, "Restaurant 2", "Address 2", "city 2", "Desc 2");

    @BeforeEach
    void setUp() {
        //in order for Mock and InjectMocks annotations to take effect, you need to call MockitoAnnotations.openMocks(this);
        // this is equivalent to @ExtendWith(MockitoExtension.class)
//        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchAllRestaurants() {
        // Mock the service behavior
        List<RestaurantDTO> mockRestaurants = Arrays.asList(RESTAURANT_1, RESTAURANT_2);

        when(restaurantService.findAllRestaurants()).thenReturn(mockRestaurants);

        // Call the controller method
        ResponseEntity<List<RestaurantDTO>> response = restaurantController.fetchAllRestaurants();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurants, response.getBody());

        // Verify that the service method was called
        verify(restaurantService, times(1)).findAllRestaurants();
    }

    @Test
    void testFetchAllRestaurants_EmptyList() {
        when(restaurantService.findAllRestaurants()).thenReturn(Collections.emptyList());

        ResponseEntity<List<RestaurantDTO>> response = restaurantController.fetchAllRestaurants();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    void testSaveRestaurant() {
        // Create a mock restaurant to be saved
        RestaurantDTO mockRestaurant = new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");

        when(restaurantService.addRestaurantInDB(mockRestaurant)).thenReturn(RESTAURANT_1);

        //call the controller method
        ResponseEntity<RestaurantDTO> response = restaurantController.saveRestaurant(mockRestaurant);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockRestaurant, response.getBody());

        //verify that the service method was called
        verify(restaurantService, times(1)).addRestaurantInDB(mockRestaurant);
    }

    @Test
    void testFetchRestaurantById() {
        // Create a mock restaurant ID
        Integer mockRestaurantId = 1;

        // Create a mock restaurant to be returned by the service
        RestaurantDTO mockRestaurant = new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");

        // Mock the service behavior
        when(restaurantService.fetchRestaurantById(mockRestaurantId)).thenReturn(new ResponseEntity<>(mockRestaurant, HttpStatus.OK));

        //call the controller method

        ResponseEntity<RestaurantDTO> response = restaurantController.fetchRestaurantById(mockRestaurantId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurant, response.getBody());

        // Verify that the service method was called
        verify(restaurantService, times(1)).fetchRestaurantById(mockRestaurantId);
    }


}