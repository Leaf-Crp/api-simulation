package fr.oukonmange.api.rest;

import fr.oukonmange.beans.common.BusBean;
import fr.oukonmange.beans.common.RestaurantBean;
import fr.oukonmange.beans.common.UserBean;
import fr.oukonmange.data.dao.IUserRepository;
import fr.oukonmange.data.entity.User;
import fr.oukonmange.beans.common.FollowBusBean;
import fr.oukonmange.beans.response.ResultWrapper;
import fr.oukonmange.services.bus.IBusService;
import fr.oukonmange.services.restaurant.IRestaurantService;
import fr.oukonmange.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/oukonmange")
public class OukonmangeController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IBusService busService;

    @Autowired
    private IRestaurantService restaurantService;


    /********************** Action User **********************/
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    /********************** Action Restaurant **********************/
    @GetMapping("/restaurants")
    public ResponseEntity<ResultWrapper<List<RestaurantBean>>> getAllRestaurant() {
        ResultWrapper<List<RestaurantBean>> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(restaurantService.getAllRestaurants());
        return ResponseEntity.ok(resultWrapper);
    }

    @GetMapping("/random/restaurant")
    public ResponseEntity<ResultWrapper<RestaurantBean>> getRandomRestaurant() {
        ResultWrapper<RestaurantBean> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(restaurantService.getRandomRestaurants());
        return ResponseEntity.ok(resultWrapper);
    }

    /********************** Action Bus**********************/
    @GetMapping("/bus")
    public ResponseEntity<ResultWrapper<List<BusBean>>> getAllBus() {
        ResultWrapper<List<BusBean>> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(busService.getAllBus());
        return ResponseEntity.ok(resultWrapper);
    }

    @PostMapping("/create/bus")
    public ResponseEntity< ResultWrapper<BusBean>> creatBus(@RequestBody BusBean request) {
        ResultWrapper<BusBean> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(busService.createBus(request));
        return ResponseEntity.ok(resultWrapper);
    }

    @PostMapping("/delete/bus")
    public ResponseEntity< ResultWrapper<Integer>> deleteBus(@RequestBody BusBean request) {
        ResultWrapper<Integer> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(busService.deleteBus(request));
        return ResponseEntity.ok(resultWrapper);
    }

    @PostMapping("/follow/bus")
    public ResponseEntity< ResultWrapper<Integer>> followBus(@RequestBody FollowBusBean request) {
        ResultWrapper<Integer> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(userService.followBus(request));
        return ResponseEntity.ok(resultWrapper);
    }

    @PostMapping("/unfollow/bus")
    public ResponseEntity< ResultWrapper<Integer>> unfollowBus(@RequestBody UserBean request) {
        ResultWrapper<Integer> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(userService.unfollowBus(request));
        return ResponseEntity.ok(resultWrapper);
    }
}
