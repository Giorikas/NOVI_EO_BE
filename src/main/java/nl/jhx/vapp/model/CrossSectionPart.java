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
    private String CspType;
    public String getCspType() {return CspType;}
    public void setCspType(String CspType) {this.CspType = CspType;}

    @Column
    private String typePavement;
    public String getTypePavement() {return typePavement;}
    public void setTypePavement(String typePavement) {this.typePavement = typePavement;}

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
