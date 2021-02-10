package com.domain;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Please enter pet name")
    private String name;
    @NotBlank(message = "Please enter pet kind")
    private String kind;
    @NotBlank(message = "Please enter pet breed")
    private String breed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User master;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name =  "diagnose_id")
    private Diagnose diagnose;

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public Pet(){

    }

    public Pet(String name, String kind, String breed, User master) {
        this.name = name;
        this.kind = kind;
        this.breed = breed;
        this.master = master;
    }

    public String getMasterName() {
        return master != null ? master.getUsername() : "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id.equals(pet.id) &&
                name.equals(pet.name) &&
                kind.equals(pet.kind) &&
                breed.equals(pet.breed) &&
                master.equals(pet.master);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, kind, breed, master);
    }
}
