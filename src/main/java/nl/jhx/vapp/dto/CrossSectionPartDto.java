package nl.jhx.vapp.dto;

import java.math.BigDecimal;

public class CrossSectionPartDto {

    private String name;
    private String cspType;
    private String pavementType;
    private BigDecimal pavementWidth;
    private int designVelocity;
    private int intensity;

    public CrossSectionPartDto(String name, String cspType, String pavementType, BigDecimal pavementWidth, int designVelocity, int intensity) {
        this.name = name;
        this.cspType = cspType;
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

    public String getCspType() { return cspType; }

    public void setType(String cspType) {
        this.cspType = cspType;
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
    
    
    
