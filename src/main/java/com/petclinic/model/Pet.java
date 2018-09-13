package com.petclinic.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "t_pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "birth_day")
    private Date birthDay;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", owner=" + owner +
                '}';
    }
}
