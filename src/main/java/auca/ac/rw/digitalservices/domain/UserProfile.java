package auca.ac.rw.digitalservices.domain;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name="user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nationalId;

    private String address;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}