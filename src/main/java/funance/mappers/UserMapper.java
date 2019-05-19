package funance.mappers;

import funance.data.User;
import org.springframework.stereotype.Component;
import za.co.discovery.portal.model.UserResponse;

@Component
public class UserMapper {

    public static UserResponse mapUser(User user) {
        UserResponse response = new UserResponse();
        response.setName(user.getFirstName());
        response.setSurname(user.getLastName());
        response.setEmail(user.getEmailId());
        response.setPassword(user.getPassword());
        response.setUsername(user.getUsername());
        return response;
    }

}
