package fr.oukonmange.services.restaurant.impl;

import fr.oukonmange.beans.common.RestaurantBean;
import fr.oukonmange.data.dao.IRestaurantRepository;
import fr.oukonmange.data.entity.Restaurant;
import fr.oukonmange.services.adapter.RestaurantBeanAdapter;
import fr.oukonmange.services.restaurant.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantBean> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream().map(RestaurantBeanAdapter::transform).collect(Collectors.toList());
    }

    @Override
    public RestaurantBean getRandomRestaurants() {
        int random = (int) (Math.random() * ((5 - 1) + 1)) + 1;
        Restaurant restaurant = restaurantRepository.findById(Integer.valueOf(random).toString());
        return RestaurantBeanAdapter.transform(restaurant);
    }

}
