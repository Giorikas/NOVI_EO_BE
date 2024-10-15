package nl.jhx.vapp.dtos;

import nl.jhx.vapp.Enums.CsBorder;
import nl.jhx.vapp.Enums.Status;

import java.math.BigDecimal;

public class CrossSectionDto {
    private long id;
    private String name;
    private Status status;
    private CsBorder leftBorder;
    private CsBorder rightBorder;
    private BigDecimal width;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public CsBorder getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(CsBorder leftBorder) {
        this.leftBorder = leftBorder;
    }

    public CsBorder getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(CsBorder rightBorder) {
        this.rightBorder = rightBorder;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }
}
