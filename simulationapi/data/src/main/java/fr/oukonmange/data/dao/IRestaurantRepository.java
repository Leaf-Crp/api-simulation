package fr.oukonmange.data.dao;

import fr.oukonmange.data.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("SELECT r FROM Restaurant r WHERE r.idRestaurant = :id")
    Restaurant findById(@Param("id") String id);
}
