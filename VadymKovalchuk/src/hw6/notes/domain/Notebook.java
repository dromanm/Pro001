package hw6.notes.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by eriol4ik on 01/02/2017.
 */

@Entity
@Table(name = "NOTEBOOK")
public class Notebook {
    private Long id;
    private String serial;
    private String vendor;
    private String model;
    private Date manufDate;
    private Double price;

    public Notebook() {}

    public Notebook(String serial, String vendor, String model, Date manufDate, Double price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufDate = manufDate;
        this.price = price;
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "ID")
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    @Column(name = "SERIAL", length = 20)
    public String getSerial() {return serial;}
    public void setSerial(String serial) {this.serial = serial;}

    @Column(name = "VENDOR", length = 20)
    public String getVendor() {return vendor;}
    public void setVendor(String vendor) {this.vendor = vendor;}

    @Column(name = "MODEL", length = 20)
    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    @Column(name = "MANUFACTURE_DATE")
    public Date getManufDate() {return manufDate;}
    public void setManufDate(Date manufDate) {this.manufDate = manufDate;}

    @Column(name = "PRICE", length = 20)
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
             sb.append(id).append(": ").
                append(serial).append(", ").
                append(vendor).append(", ").
                append(model).append(", ").
                append(manufDate).append(", ").
                append(price);

        return sb.toString();
    }
}