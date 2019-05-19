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

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_entity (id, username, first_name, last_name, email_address, password) VALUES (:identifier, :username, :firstname, :surname, :email, :password)",
            nativeQuery = true)
    void createUser(@Param("identifier") int identifier, @Param("username") String username, @Param("firstname") String name, @Param("surname") String surname,
                    @Param("email") String email, @Param("password") String password);
}