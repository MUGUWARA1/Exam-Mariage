package com.example.mariage;

import com.example.mariage.Controller.InviteeController;
import com.example.mariage.Controller.MariageController;
import com.example.mariage.Controller.PersonneController;
import com.example.mariage.Controller.SalleConroller;
import com.example.mariage.Entity.Invite;
import com.example.mariage.Entity.Mariage;
import com.example.mariage.Entity.Personne;
import com.example.mariage.Entity.Salle;
import com.example.mariage.Service.MariageService;
import com.example.mariage.Service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class MariageApplication {
    @Autowired
    private PersonneController p;
    @Autowired
    private MariageController mariageController;

    @Autowired
    private SalleConroller salleConroller;
    @Autowired
    private InviteeController inviteeController;

    public static void main(String[] args) {
        SpringApplication.run(MariageApplication.class, args);
    }

    @Bean
    public CommandLineRunner useService(){
        return args -> {
            Personne homme=new Personne("karim","derouich","karim");
            Personne femme=new Personne("ff","Fatima","jere");
            Salle s1=new Salle("RABATJJ","IBN SINA EMI","RABAT",800);
            Invite inv=new Invite("JG52366","Youssef","Fathani",StatutInv.INVITE_EPOUX);
            p.addPersonne(homme);
            p.addPersonne(femme);
            salleConroller.add(s1);
            inviteeController.add(inv);
            LocalDate date =LocalDate.parse("2022-02-06");
            Mariage m=new Mariage(date,52,55,96);
            p.Reserver(1L,2L,m);
            mariageController.qrInvite(m.getNum(),inv);
            p.Confirmer(m.getNum(),s1);


        };
    }



}
