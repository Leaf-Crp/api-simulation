package fr.oukonmange.api.rest;

import fr.oukonmange.beans.common.UserBean;
import fr.oukonmange.data.dao.IUserRepository;
import fr.oukonmange.data.entity.User;
import fr.oukonmange.beans.common.LoginBean;
import fr.oukonmange.beans.response.ResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/security")
public class LoginController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<ResultWrapper<User>> login(@RequestBody LoginBean loginRequest) {
        User user = userRepository.getUserInfoByPseudoAndPassword(loginRequest.getPseudo(), loginRequest.getPassword());
        ResultWrapper<User> resultWrapper = new ResultWrapper<>();
        resultWrapper.setPayload(user);
        return ResponseEntity.ok(resultWrapper);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserBean user) {
        User userToPersist = new User();
        userToPersist.setNomUser(user.getNom());
        userToPersist.setPrenomUser(user.getPrenom());
        userToPersist.setPseudoUser(user.getPseudo());
        userToPersist.setPasswordUser(user.getPassword());
        userRepository.saveAndFlush(userToPersist);
        return ResponseEntity.ok("user registered");
    }

}
