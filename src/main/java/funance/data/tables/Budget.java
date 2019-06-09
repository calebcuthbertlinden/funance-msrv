package funance.data.tables;

import javax.persistence.*;

@Entity
@Table(name = "budget")
public class Budget {

    private long id;
    private String username;
    private String title;
    private String category;
    private String state;
    private String description;
    private float amount;
    private String date;
    private boolean onceoff;

    public Budget() {}

    public Budget(String username, float amount, String category, String date, boolean onceoff, String state, String title, String description) {
        this.username = username;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.onceoff = onceoff;
        this.state = state;
        this.description = description;
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

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
                ", username=" + username +
                ", category=" + category +
                ", amount=" + amount +
                ", date=" + date +
                 "]";
    }
}
