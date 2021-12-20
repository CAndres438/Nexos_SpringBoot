package com.auto_inventory_1.models;

import javax.persistence.*;


@Entity
public class UserNexos {

    @Id
    @Column(name= "NAME", length= 150, unique = true)
    private String completeName;

    @Column(name= "Age", nullable = false)
    private Integer age = 18;

    @Column(name= "EMPLOYMENT", nullable = false)
    private String userEmployment = "Coordinador";

    @Column(name = "ENTRY_USER", nullable = false)
    private String entryUser;

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserEmployment() {
        return userEmployment;
    }

    public void setUserEmployment(String userEmployment) {
        this.userEmployment = userEmployment;
    }

    public String getEntryUser() {
        return entryUser;
    }

    public void setEntryUser(String entryUser) {
        this.entryUser = entryUser;
    }
}

