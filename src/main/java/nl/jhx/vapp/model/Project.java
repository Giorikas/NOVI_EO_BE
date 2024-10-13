package nl.jhx.vapp.model;
import jakarta.persistence.*;
import nl.jhx.vapp.Enums.Status;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private long id;

    public long getId() { return id; }

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "CrossSection_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private CrossSection crossSection;

    public CrossSection getCrossSection() {return crossSection;}
    public void setCrossSection(CrossSection crossSection) {this.crossSection = crossSection;}

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

