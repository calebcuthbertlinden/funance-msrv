package funance.data;

import javax.persistence.*;

@Entity
@Table(name = "user_entity")
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailId;
    private String contact;

    public User() {}

    public User(String firstName, String lastName, String username, String password, String emailId, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.emailId = emailId;
        this.contact = contact;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "contact", nullable = false)
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User [id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", username=" + username +
                ", password=" + password +
                ", emailId=" + emailId
                + "]";
    }

}
