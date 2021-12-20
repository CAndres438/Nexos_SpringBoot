package com.auto_inventory_1.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employments {

    @Id
    @Column(name = "NAME_EMPLOYMENT", length = 100, unique = true)
    private String employmentName;

    @Column(name = "DESCRIPTION")
    private String description = "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias";

    public String getEmploymentName() {
        return employmentName;
    }

    public void setEmploymentName(String employmentName) {
        this.employmentName = employmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
