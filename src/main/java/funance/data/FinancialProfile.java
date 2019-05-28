package funance.data;


import javax.persistence.*;

@Entity
@Table(name = "financialprofile")
public class FinancialProfile {

    private long id;
    private String username;
    private float income;
    private float savings;
    private float investments;

    public FinancialProfile() {
    }

    public FinancialProfile(String username, float income, float savings, float investments) {
        this.income = income;
        this.savings = savings;
        this.investments = investments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "income", nullable = false)
    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    @Column(name = "savings", nullable = false)
    public float getSavings() {
        return savings;
    }

    public void setSavings(float savings) {
        this.savings = savings;
    }

    @Column(name = "investments", nullable = false)
    public float getInvestments() {
        return investments;
    }

    public void setInvestments(float investments) {
        this.investments = investments;
    }
}
