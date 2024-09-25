package nl.jhx.vapp.model;
import jakarta.persistence.*;
import nl.jhx.vapp.Enums.Status;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private long id;

    public long getId() { return id; }

    @Column(nullable = false, unique = true)
    private String name;

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private Status status;

    public Status getStatus() { return status; }
    public void setStatus(Status status) {
        this.status = status;
    }
}

