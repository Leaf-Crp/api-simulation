package fr.oukonmange.services.user;

import fr.oukonmange.beans.common.FollowBusBean;
import fr.oukonmange.beans.common.UserBean;

import java.util.List;

public interface IUserService {

    List<UserBean> getUserByBus(String idBus);

    Integer updateUser(UserBean request);

    Integer followBus(FollowBusBean request);

    Integer unfollowBus(UserBean request);
}
