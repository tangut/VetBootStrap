package com.domain;

import javax.imageio.plugins.jpeg.JPEGQTable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "diagnose")
public class Diagnose {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String simptome;
    @NotBlank
    private String medicine;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Diagnose(){

    }

    public Diagnose(long id, @NotBlank String name, @NotBlank String simptome, @NotBlank String medicine, Pet pet) {
        this.id = id;
        this.name = name;
        this.simptome = simptome;
        this.medicine = medicine;
        this.pet = pet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimptome() {
        return simptome;
    }

    public void setSimptome(String simptome) {
        this.simptome = simptome;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

}
