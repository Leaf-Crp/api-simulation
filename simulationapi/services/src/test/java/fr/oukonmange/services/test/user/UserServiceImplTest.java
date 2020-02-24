package fr.oukonmange.services.test.user;


import fr.oukonmange.beans.common.FollowBusBean;
import fr.oukonmange.beans.common.UserBean;
import fr.oukonmange.data.dao.IUserRepository;
import fr.oukonmange.data.entity.User;
import fr.oukonmange.services.user.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.doReturn;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserServiceImpl.class})
public class UserServiceImplTest {

    @MockBean
    private IUserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    private UserBean userBean;

    @Before
    public void init(){
        userBean = new UserBean();
        userBean.setId("1");
        userBean.setIdBus("1");
        userBean.setNom("TEST");
        userBean.setPrenom("TEST");
        userBean.setPseudo("TEST");
        userBean.setPassword("TEST");
    }

    @Test
    public void getUserByBusTest(){
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());

        doReturn(userList).when(userRepository).getUserByBus(anyString());

        assertEquals(3, userService.getUserByBus("TEST").size());
    }

    @Test
    public void updateUserTest() {
       userService.updateUser(userBean);
       verify(userRepository, times(1)).updateUserByIdentifiant(anyString(), anyString(), anyString(), anyString(), anyString());
    }

    @Test
    public void followBusTest() {
        FollowBusBean followBusBean = new FollowBusBean();
        followBusBean.setIdBus("1");
        followBusBean.setIdUser("1");

        userService.followBus(followBusBean);
        verify(userRepository, times(1)).followBus(anyString(), anyString());
    }

    @Test
    public void unfollowBusTest() {
        userService.unfollowBus(userBean);
        verify(userRepository, times(1)).unfollowBus(anyString());
    }

}