package nl.jhx.vapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cross_sections")
public class CrossSection {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name", length = 128)
    private String name;


    @Column(name = "rush_hour_car")
    private int rushHourIntensityCar;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRushHourIntensityCar() {
        return rushHourIntensityCar;
    }

    public void setRushHourIntensityCar(int rushHourIntensityCar) {
        this.rushHourIntensityCar = rushHourIntensityCar;
    }

}