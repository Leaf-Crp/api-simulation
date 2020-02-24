package fr.oukonmange.data.dao;


import fr.oukonmange.data.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBusRepository extends JpaRepository<Bus, Integer> {

    @Query("SELECT b FROM Bus b WHERE b.idBus = :id")
    Bus findById(@Param("id") String id);
}
