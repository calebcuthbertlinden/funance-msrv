package funance.data.tables;

import javax.persistence.*;

@Entity
@Table(name = "gameboard")
public class Gameboard {

    private long id;
    private long coins;
    private String username;

    public Gameboard() {
    }

    public Gameboard(long coins, String username) {
        this.coins = coins;
        this.username = username;
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

    @Column(name = "coins", nullable = false)
    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }
}
