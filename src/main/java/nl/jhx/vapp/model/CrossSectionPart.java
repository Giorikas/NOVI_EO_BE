package nl.jhx.vapp.model;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cross_section_parts")
public class CrossSectionPart {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private String type;
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    @Column
    private String pavementType;
    public String getPavementType() {return pavementType;}
    public void setPavementType(String pavementType) {this.pavementType = pavementType;}

    @Column
    private BigDecimal pavementWidth;
    public BigDecimal getPavementWidth() {return pavementWidth;}
    public void setPavementWidth(BigDecimal pavementWidth) {
        this.pavementWidth = pavementWidth;
    }

    @Column
    private int designVelocity;
    public int getDesignVelocity() {return designVelocity;}
    public void setDesignVelocity(int designVelocity) {this.designVelocity = designVelocity;}

    @Column
    private int intensity;
    public int getIntensity() {return intensity;}
    public void setIntensity(int intensity) {this.intensity = intensity;}


}
