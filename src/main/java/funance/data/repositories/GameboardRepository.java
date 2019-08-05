package funance.data.repositories;

import funance.data.tables.Budget;
import funance.data.tables.Gameboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface GameboardRepository extends JpaRepository<Budget, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Gameboard (username, coins)  VALUES (:username, :coins)",
            nativeQuery = true)
    void createGameboard(@Param("username") String username, @Param("coins") float coins);

    @Modifying
    @Transactional
    @Query("UPDATE Gameboard SET coins = :coins WHERE username = :username")
    void updateGameboard(@Param("coins") long coins, @Param("username") String username);

    @Query("SELECT gb FROM Gameboard gb WHERE gb.username like :username")
    Gameboard findGameboardFromUser(@Param("username") String username);

}
