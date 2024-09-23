package nl.jhx.vapp.model;

import jakarta.persistence.*;
import nl.jhx.vapp.Enums.CsBorder;
import nl.jhx.vapp.Enums.Status;

import java.math.BigDecimal;

@Entity
@Table(name = "cross_sections")
public class CrossSection {

    @Id
    @GeneratedValue()
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Column(name="name")
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Column(nullable = false)
    private Status status;

    public Status getStatus() { return status; }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "leftBorder")
    private CsBorder leftBorder;

    public CsBorder getLeftBorder() {return leftBorder;}
    public void setLeftBorder(CsBorder leftBorder) {this.leftBorder = leftBorder;}

    @Column(name="rightBorder")
    private CsBorder rightBorder;

    public CsBorder getRightBorder() {return rightBorder;}
    public void setRightBorder(CsBorder rightBorder) {this.rightBorder = rightBorder;}

    @Column(name = "width")
    private BigDecimal width;

    public BigDecimal getWidth() {return width;}
    public void setWidth(BigDecimal width) {this.width = width;}
    /* For precision BigDec and not f or d. --> float: (1 == 1/3 + 1/3 + 1/3) => false

     mm not an option when working with incline in later developments.. --> CivilEng.
     */

}