package fr.oukonmange.services.user.impl;

import fr.oukonmange.services.adapter.UserBeanAdapter;
import fr.oukonmange.beans.common.UserBean;
import fr.oukonmange.data.dao.IUserRepository;
import fr.oukonmange.beans.common.FollowBusBean;
import fr.oukonmange.data.entity.User;
import fr.oukonmange.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public List<UserBean> getUserByBus(String idBus) {
        List<User> users = userRepository.getUserByBus(idBus);
        return  users.stream().map(UserBeanAdapter::transform).collect(Collectors.toList());
    }

    public Integer updateUser(UserBean request) {
        return userRepository.updateUserByIdentifiant(request.getId(),request.getNom(),request.getPrenom(),request.getPassword(),request.getPseudo());
    }

    public Integer followBus(FollowBusBean request) {
        return userRepository.followBus(request.getIdUser(), request.getIdBus());
    }

    public Integer unfollowBus(UserBean request) {
        return userRepository.unfollowBus(request.getId());
    }
}
