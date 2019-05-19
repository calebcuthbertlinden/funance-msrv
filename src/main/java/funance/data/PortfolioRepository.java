package funance.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Budget, Long> {

    @Query("SELECT b FROM Budget b WHERE b.userId = :userId")
    List<Budget> findByUserId(@Param("userId") long userId);

    @Query("SELECT b FROM Budget b WHERE b.id = :id")
    Budget findItemById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO budget (id, user_id, title, amount, category, due_date, onceoff, state)  VALUES (:id, :userId, :title, :amount, :category, :dueDate, :onceoff, :state)",
            nativeQuery = true)
    void createBudgetItem(@Param("id") long id, @Param("userId") long userId, @Param("title") String title, @Param("amount") float amount,
                          @Param("category") String category, @Param("dueDate") String dueDate, @Param("onceoff") boolean onceoff, @Param("state") String state);
}
