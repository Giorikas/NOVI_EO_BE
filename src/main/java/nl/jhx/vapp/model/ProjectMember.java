package nl.jhx.vapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "project_members")
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String role;

    public String getEmail() { return email;}
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() { return role; }
    public void setRole(String role) {
        this.role = role;
    }


}

