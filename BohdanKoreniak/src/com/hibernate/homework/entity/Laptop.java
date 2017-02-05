package com.hibernate.homework.entity;

import javax.persistence.*;

/**
 * Created by Bohdan on 03.02.2017.
 */
@Entity
@Table(name = "LAPTOPS")
public class Laptop
{
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SERIAL_NUMBER")
    private Integer serialNumber;

    @Column(name = "VENDOR_NAME")
    private String vendorName;
    @Column(name = "MODEL_NAME")
    private String modelName;

    @Column(name = "MANUFACTURE_DATE")
    private String manufactureDate;

    @Column(name = "PRICE")
    private Integer price;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getVendorName()
    {
        return vendorName;
    }

    public void setVendorName(String vendorName)
    {
        this.vendorName = vendorName;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getManufactureDate()
    {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate)
    {
        this.manufactureDate = manufactureDate;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }
}
