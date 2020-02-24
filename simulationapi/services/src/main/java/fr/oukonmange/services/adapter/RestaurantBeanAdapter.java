package fr.oukonmange.services.adapter;

import fr.oukonmange.beans.common.RestaurantBean;
import fr.oukonmange.data.entity.Restaurant;

public class RestaurantBeanAdapter {

    private RestaurantBeanAdapter() {
        throw new IllegalStateException("Utility class");
    }

    public static RestaurantBean transform(Restaurant restaurant){
        RestaurantBean restaurantBean = new RestaurantBean();
        restaurantBean.setIdRestaurant(restaurant.getIdRestaurant());
        restaurantBean.setNameRestaurant(restaurant.getNomRestaurant());
        restaurantBean.setAdresseRestaurant(restaurant.getAdresseRestaurant());
        restaurantBean.setCommentaireRestaurant(restaurant.getCommentaireRestaurant());
        restaurantBean.setStoryRestaurant(restaurant.getStoryRestaurant());
        restaurantBean.setTypeRestaurant(restaurant.getTypeRestaurant());
        return restaurantBean;
    }
}
