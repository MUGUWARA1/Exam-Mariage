package com.example.mariage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CIN;
    private String Prenom;
    private String Nom;

    @OneToMany(mappedBy = "personneEpoux" ,fetch = FetchType.EAGER)
    private List<Mariage> MariagesEpoux=new ArrayList<>();
    @OneToMany(mappedBy = "personneEpouse",fetch = FetchType.EAGER)
    private List<Mariage> MarigesEpouse =new ArrayList<>();

    public Personne(){}

    @JsonIgnore
    public List<Mariage> getMariagesEpoux() {
        return MariagesEpoux;
    }

    public void setMariagesEpoux(List<Mariage> mariagesEpoux) {
        MariagesEpoux = mariagesEpoux;
    }

    @JsonIgnore
    public List<Mariage> getMarigesEpouse() {
        return MarigesEpouse;
    }

    public void setMarigesEpouse(List<Mariage> marigesEpouse) {
        MarigesEpouse = marigesEpouse;
    }

    public Personne(String CIN, String prenom, String nom) {
        this.CIN = CIN;
        Prenom = prenom;
        Nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", CIN='" + CIN + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Nom='" + Nom +"}";
    }
}

