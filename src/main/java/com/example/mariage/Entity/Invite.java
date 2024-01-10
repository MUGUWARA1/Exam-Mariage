package com.example.mariage.Entity;

import com.example.mariage.StatutInv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Invite extends Personne{

    public Invite() {
    }
    public Invite(String CIN, String prenom, String nom, StatutInv statut) {
        super(CIN, prenom, nom);
        this.statut = statut;
    }

    @Enumerated(EnumType.STRING)
    private StatutInv statut;

    @ManyToMany(mappedBy = "Invitees")
    private List<Mariage> Mariages =new ArrayList<>();

    @JsonIgnore
    public List<Mariage> getMariages() {
        return Mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        Mariages = mariages;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "statut=" + statut +
                '}';
    }



    public StatutInv getStatut() {
        return statut;
    }

    public void setStatut(StatutInv statut) {
        this.statut = statut;
    }


}
