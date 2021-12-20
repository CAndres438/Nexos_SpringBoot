package com.auto_inventory_1.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME_PRODUCT", length = 100, unique = true)
    private String productName;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "ENTRY")
    private String entryDate;

    @Column(name = "USER_NEXOS")
    private String userNexos;

    @Column(name = "USER_CHANGE", length = 150, nullable = false)
    private String userChange = "No aplica";

    @Column(name = "DATE_CHANGE", nullable = false)
    private String dateUserChange = "No aplica";

    @Column(name = "USER_DELETE", length = 150, nullable = false)
    private String userDelete = "No aplica";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getUserNexos() {
        return userNexos;
    }

    public void setUserNexos(String userNexos) {
        this.userNexos = userNexos;
    }

    public String getUserChange() {
        return userChange;
    }

    public void setUserChange(String userChange) {
        this.userChange = userChange;
    }

    public String getDateUserChange() {
        return dateUserChange;
    }

    public void setDateUserChange(String dateUserChange) {
        this.dateUserChange = dateUserChange;
    }

    public String getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(String userDelete) {
        this.userDelete = userDelete;
    }
}
