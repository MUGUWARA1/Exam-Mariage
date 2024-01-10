package com.example.mariage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class    Mariage {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    private LocalDate date;
    private int nombreMinimumTemoin;
    private int capaciteMinimal;
    private int nombreMaxInviteEpoux;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;


    @ManyToOne
    @JoinColumn(name = "EpouxId")
    private Personne personneEpoux;

    @ManyToOne
    @JoinColumn(name = "EpouseID")
    private  Personne personneEpouse;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Mariage_Inv",
            joinColumns = @JoinColumn(name = "Mariage_num"),
            inverseJoinColumns = @JoinColumn(name = "Inv_id")
    )
    private List<Invite> Invitees = new ArrayList<>();



    public Mariage(LocalDate date, int nombreMinimumTemoin, int capaciteMinimal, int nombreMaxInviteEpoux) {
        this.date = date;
        this.nombreMinimumTemoin = nombreMinimumTemoin;
        this.capaciteMinimal = capaciteMinimal;
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }
    public Mariage(){}

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNombreMinimumTemoin() {
        return nombreMinimumTemoin;
    }

    public void setNombreMinimumTemoin(int nombreMinimumTemoin) {
        this.nombreMinimumTemoin = nombreMinimumTemoin;
    }

    public int getCapaciteMinimal() {
        return capaciteMinimal;
    }

    public void setCapaciteMinimal(int capaciteMinimal) {
        this.capaciteMinimal = capaciteMinimal;
    }

    public int getNombreMaxInviteEpoux() {
        return nombreMaxInviteEpoux;
    }

    public void setNombreMaxInviteEpoux(int nombreMaxInviteEpoux) {
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Personne getPersonneEpoux() {
        return personneEpoux;
    }

    public void setPersonneEpoux(Personne personneEpoux) {
        this.personneEpoux = personneEpoux;
    }

    public Personne getPersonneEpouse() {
        return personneEpouse;
    }

    public void setPersonneEpouse(Personne personneEpouse) {
        this.personneEpouse = personneEpouse;
    }

    public List<Invite> getInvitees() {
        return Invitees;
    }

    public void setInvitees(List<Invite> invitees) {
        Invitees = invitees;
    }

    @Override
    public String toString() {
        return "Mariage{" +
                "num=" + num +
                ", date=" + date +
                ", nombreMinimumTemoin=" + nombreMinimumTemoin +
                ", capaciteMinimal=" + capaciteMinimal +
                ", nombreMaxInviteEpoux=" + nombreMaxInviteEpoux +
                ", salle=" + salle +
                ", personneEpoux=" + personneEpoux +
                ", personneEpouse=" + personneEpouse +
                ", Invitees=" + Invitees +
                '}';
    }
}
