package fr.oukonmange.data.dao;

import fr.oukonmange.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.pseudoUser = :pseudo AND u.passwordUser = :password")
    User getUserInfoByPseudoAndPassword(@Param("pseudo") String pseudo, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.idBusUser = :idBus")
    List<User> getUserByBus(@Param("idBus") String idBus);

    @Transactional
    @Modifying
    @Query("UPDATE User SET nomUser = :nom, prenomUser = :prenom, pseudoUser = :pseudo, passwordUser = :password WHERE idUser = :id")
    Integer updateUserByIdentifiant(@Param("id") String id, @Param("nom") String nom, @Param("prenom") String prenom, @Param("pseudo") String pseudo, @Param("password") String password);

    @Transactional
    @Modifying
    @Query("UPDATE User SET idBusUser = :idBus WHERE idUser = :id")
    Integer followBus(@Param("id") String id, @Param("idBus") String idBus);

    @Transactional
    @Modifying
    @Query("UPDATE User SET idBusUser = null WHERE idUser = :id")
    Integer unfollowBus(@Param("id") String id);
}
