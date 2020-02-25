package fr.simulation.data.dao;


import fr.simulation.data.entity.Pan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPanRepository extends JpaRepository<Pan, Integer> {

}
