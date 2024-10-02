package nl.jhx.vapp.dto;

import java.math.BigDecimal;

public class CrossSectionPartDto {

    private String name;
    private String type;
    private String pavementType;
    private BigDecimal pavementWidth;
    private int designVelocity;
    private int intensity;

    public CrossSectionPartDto(String name, String type, String pavementType, BigDecimal pavementWidth, int designVelocity, int intensity) {
        this.name = name;
        this.type = type;
        this.pavementType = pavementType;
        this.pavementWidth = pavementWidth;
        this.designVelocity = designVelocity;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public String getPavementType() { return pavementType; }

    public void setPavementType(String pavementType) {
        this.pavementType = pavementType;
    }

    public BigDecimal getPavementWidth() { return pavementWidth;}

    public void setPavementWidth(BigDecimal pavementWidth) {
        this.pavementWidth = pavementWidth;
    }

    public int getDesignVelocity() {return designVelocity;}

    public void setDesignVelocity(int designVelocity) {
        this.designVelocity = designVelocity;
    }
    
    public int getIntensity() {return intensity;}
    public void setIntensity(int intensity) {this.intensity = intensity;}

}
    
    
    
