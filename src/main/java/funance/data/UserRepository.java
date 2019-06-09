package funance.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username like :username")
    User findByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.contact like :contact")
    User findByContact(@Param("contact") String contact);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_entity (id, username, first_name, last_name, email_address, password, contact) VALUES (:identifier, :username, :firstname, :surname, :email, :password, :contact)",
            nativeQuery = true)
    void createUser(@Param("identifier") int identifier, @Param("username") String username, @Param("firstname") String name, @Param("surname") String surname,
                    @Param("email") String email, @Param("password") String password, @Param("contact") String contact);
}