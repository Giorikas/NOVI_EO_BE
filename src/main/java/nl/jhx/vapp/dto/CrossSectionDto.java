package nl.jhx.vapp.dto;

import nl.jhx.vapp.Enums.Status;
import nl.jhx.vapp.Enums.CsBorder;

import java.math.BigDecimal;

public class CrossSectionDto {

    private Long id;
    private String name;

    private CsBorder leftBorder;
    private CsBorder rightBorder;
    private BigDecimal width;

    private Status status;

    private Status getStatusFromString(String status){

        return switch (status) {
            case "STARTED"-> Status.STARTED;
            case "TRAFFIC_ENGINEERING"-> Status.TRAFFIC_ENGINEERING;
            case "TRAFFIC_EVALUATION"-> Status.TRAFFIC_EVALUATION;
            case "CIVIL_ENGINEERING"-> Status.CIVIL_ENGINEERING;
            case "CIVIL_EVALUATION"-> Status.CIVIL_EVALUATION;
            case "FINISHED"-> Status.FINISHED;
            default -> Status.MF;
        };
    }

   private CsBorder getBorderFromString(String border) {
       System.out.println(border);
        return switch (border) {
            case "GEVEL" -> CsBorder.GEVEL;
            case "BOMEN" -> CsBorder.BOMEN;
            case "BERM_(OBSTAKELVRIJ)" -> CsBorder.BERM;
            case "SLOOT" -> CsBorder.SLOOT;
            case "KADE" -> CsBorder.KADE;
            case "WATER" -> CsBorder.WATER;
            default -> CsBorder.MF;
        };
   }

   public CrossSectionDto(Long id, String name, Status status, CsBorder leftBorder, CsBorder rightBorder, BigDecimal width) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.width = width;
   }


    public Long getId() {return id;}
    public String getName() {return name;}
    public CsBorder getLeftBorder() {return leftBorder;}
    public CsBorder getRightBorder() {return rightBorder;}
    public BigDecimal getWidth() {return width;}
    public Status getStatus() {return status;}

    public void setName(final String name) {this.name = name;}
    public void setWidth(final BigDecimal width) {this.width = width;}

    public void setLeftBorder(String leftBorder){
        this.leftBorder = getBorderFromString(leftBorder);}

    public void setRightBorder(String rightBorder){
        this.rightBorder = getBorderFromString(rightBorder);}

    public void setStatus(String status){
        this.status = getStatusFromString(status);}

}
