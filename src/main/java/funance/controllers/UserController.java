package funance.controllers;

import funance.data.User;
import funance.data.UserRepository;
import funance.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.portal.api.UserApi;
import za.co.discovery.portal.model.CreateUserRequest;
import za.co.discovery.portal.model.UserResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponse> userGet(@NotNull @RequestParam String username) {
        User user = userRepository.findByUsername(username);
        UserResponse userResponse;
        if (user != null) {
            userResponse = UserMapper.mapUser(user);
            return new ResponseEntity(userResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UserResponse> userPost(@Valid CreateUserRequest body) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
