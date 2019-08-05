package funance.controllers;

import funance.data.tables.User;
import funance.data.repositories.UserRepository;
import funance.mappers.ProfileMapper;
import funance.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.portal.api.UserApi;
import za.co.discovery.portal.model.AuthenticationRequest;
import za.co.discovery.portal.model.AuthenticationResponse;
import za.co.discovery.portal.model.CreateUserRequest;
import za.co.discovery.portal.model.UserResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class UserController implements UserApi {

    private UserRepository userRepository;

    @Autowired
    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @CrossOrigin(origins = {"http://localhost:3000", "https://funance-msrv.azurewebsites.net"})
    public ResponseEntity<AuthenticationResponse> userAuthenticatePost(@Valid AuthenticationRequest body) {
        if (body == null || body.getUsername() == null || body.getPassword() == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try {
            UserResponse userResponse = userGet(body.getUsername()).getBody();
            // TODO decrypt encrypted password
            AuthenticationResponse response = new AuthenticationResponse();
            if (userResponse == null) {
                return new ResponseEntity(response.status(AuthenticationResponse.StatusEnum.NO_ACCOUNT), HttpStatus.OK);
            } else if (userResponse.getPassword().equals(body.getPassword())) {
                return new ResponseEntity(response.status(AuthenticationResponse.StatusEnum.LOGGED_IN), HttpStatus.OK);
            } else {
                return new ResponseEntity(response.status(AuthenticationResponse.StatusEnum.INCORRECT), HttpStatus.OK);
            }
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin(origins = {"http://localhost:3000", "https://funance-msrv.azurewebsites.net"})
    public ResponseEntity<Void> userContactPost(@NotNull String contact, @NotNull String username) {
        if (contact.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if (contact.startsWith(" ")) {
            contact = contact.replace(" ", "+");
        }

        try {
            userRepository.updateContact(username, contact);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin(origins = {"http://localhost:3000", "https://funance-msrv.azurewebsites.net"})
    public ResponseEntity<UserResponse> userGet(@NotNull @RequestParam String username) {
        if (username.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try {
            UserResponse userResponse = UserMapper.mapUser(userRepository.findByUsername(username));
            return new ResponseEntity(userResponse, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin(origins = {"http://localhost:3000", "https://funance-msrv.azurewebsites.net"})
    public ResponseEntity<UserResponse> userPost(@Valid CreateUserRequest body) {
        if (body == null || body.getUsername().isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try {
            User user = userRepository.findByUsername(body.getUsername());

            if (user != null) {
                UserResponse response = new UserResponse();
                response.setStatus(UserResponse.StatusEnum.ALREADY_EXISTS);
                return new ResponseEntity(response, HttpStatus.OK);
            } else {
                long id = ProfileMapper.getRandomIntegerBetweenRange();
                userRepository.createUser((int) id, body.getUsername(), body.getName(), body.getSurname(), body.getEmail(), body.getPassword(), "");
                UserResponse userResponse = userGet(body.getUsername()).getBody();
                return userResponse != null ?
                        new ResponseEntity<>(userResponse.status(UserResponse.StatusEnum.CREATED).coinAmount(100), HttpStatus.OK)
                        : new ResponseEntity<>(new UserResponse().status(UserResponse.StatusEnum.ERROR), HttpStatus.OK);
            }
        } catch (Exception exception) {
            return new ResponseEntity(new UserResponse().status(UserResponse.StatusEnum.ERROR), HttpStatus.OK);
        }
    }
}
