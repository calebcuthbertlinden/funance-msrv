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

    @Query("SELECT b FROM Budget b WHERE b.username like :username")
    List<Budget> findByUserId(@Param("username") String username);

    @Query("SELECT b FROM Budget b WHERE b.id = :id")
    Budget findItemById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO budget (id, username, title, description, amount, category, due_date, onceoff, state)  VALUES (:id, :username, :title, :description, :amount, :category, :dueDate, :onceoff, :state)",
            nativeQuery = true)
    void createBudgetItem(@Param("id") long id, @Param("username") String username, @Param("title") String title, @Param("amount") float amount,
                          @Param("category") String category, @Param("dueDate") String dueDate, @Param("onceoff") boolean onceoff,
                          @Param("state") String state, @Param("description") String description);

    @Modifying
    @Transactional
    @Query("UPDATE Budget SET state = :state WHERE id = :id")
    void updateBudgetItem(@Param("id") long id, @Param("state") String state);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO FinancialProfile (income, savings, investments, username)  VALUES (:income, :savings, :investments, :username)",
            nativeQuery = true)
    void createFinancialProfile(@Param("username") String username, @Param("income") float income, @Param("savings") float savings, @Param("investments") float investments);

    @Query("SELECT fp FROM FinancialProfile fp WHERE fp.username like :username")
    FinancialProfile findFinancialProfileByUser(@Param("username") String username);
}
