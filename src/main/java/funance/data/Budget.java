package funance.data;

import javax.persistence.*;

@Entity
@Table(name = "budget")
public class Budget {

    private long id;
    private long userId;
    private String title;
    private String category;
    private String state;
    private float amount;
    private String date;
    private boolean onceoff;

    public Budget() {}

    public Budget(long userId, float amount, String category, String date, boolean onceoff, String state, String title) {
        this.userId = userId;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.onceoff = onceoff;
        this.state = state;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "state", nullable = false)
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "onceoff", nullable = false)
    public boolean getOnceoff() {
        return onceoff;
    }
    public void setOnceoff(boolean onceoff) {
        this.onceoff = onceoff;
    }

    @Column(name = "amount", nullable = false)
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Column(name = "due_date", nullable = false)
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Budget [id=" + id +
                ", userId=" + userId +
                ", category=" + category +
                ", amount=" + amount +
                ", date=" + date +
                 "]";
    }
}
