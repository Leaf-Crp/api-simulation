package fr.oukonmange.services.restaurant;

import fr.oukonmange.beans.common.RestaurantBean;

import java.util.List;

public interface IRestaurantService {

    List<RestaurantBean> getAllRestaurants();

    RestaurantBean getRandomRestaurants();
}
