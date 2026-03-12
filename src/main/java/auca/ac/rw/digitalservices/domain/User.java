package auca.ac.rw.digitalservices.domain;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="user_id")
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

}