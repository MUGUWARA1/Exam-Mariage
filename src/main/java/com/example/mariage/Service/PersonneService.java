package com.example.mariage.Service;

import com.example.mariage.Entity.Mariage;
import com.example.mariage.Entity.Personne;
import com.example.mariage.Entity.Salle;
import com.example.mariage.Repo.MariageRepo;
import com.example.mariage.Repo.PersonneRepo;
import com.example.mariage.Repo.SalleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonneService {

    private PersonneRepo personneRepo;
    private SalleRepo salleRepo;

    private MariageRepo mariageRepo;
    private MariageService mariageService;

    public PersonneService(PersonneRepo personneRepo, SalleRepo salleRepo, MariageRepo mariageRepo, MariageService mariageService) {
        this.personneRepo = personneRepo;
        this.salleRepo = salleRepo;
        this.mariageRepo = mariageRepo;
        this.mariageService = mariageService;
    }

    public List<Personne> getALl(){
        return this.personneRepo.findAll();
    }

    public Personne getPersonneById(Long id){
        return this.personneRepo.findById(id).orElseThrow(()->new RuntimeException("Personne Not Founded"));
    }
    public Personne addPersnone(Personne P){
        return this.personneRepo.save(P);
    }
    public void DeletePersonne(Long id){
        this.personneRepo.deleteById(id);
    }
    public Personne UpdatePersone(Personne p)
    {
        if (this.getPersonneById(p.getId())!=null){
            return this.personneRepo.save(p);
        }
        return null;
    }

    public Mariage reserver(Long hommeid,Long femmeid,Mariage mariage){
        Personne homme =this.getPersonneById(hommeid);
        Personne femme =this.getPersonneById(femmeid);

        homme.getMariagesEpoux().add(mariage);
        femme.getMarigesEpouse().add(mariage);

        mariage.setPersonneEpoux(homme);
        mariage.setPersonneEpouse(femme);

        this.personneRepo.save(homme);
        this.personneRepo.save(femme);
        this.mariageRepo.save(mariage);

        return mariage;
    }
    public Salle confirmer(Long mariagenum,Salle salle){
        Mariage mariage=this.mariageService.getMariageId(mariagenum);

        mariage.setSalle(salle);
        salle.getMariages().add(mariage);

        salleRepo.save(salle);
        mariageRepo.save(mariage);

        return salle;



    }


}
