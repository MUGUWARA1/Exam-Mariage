package com.example.mariage.Controller;


import com.example.mariage.Entity.Mariage;
import com.example.mariage.Entity.Personne;
import com.example.mariage.Entity.Salle;
import com.example.mariage.Service.PersonneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Persone")
public class PersonneController {
    private PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/")
    public List<Personne>  getAll(){
        return this.personneService.getALl();
    }
    @GetMapping("/{id}")
    public Personne getPersoneid(@PathVariable Long id){
        return this.personneService.getPersonneById(id);
    }
    @PostMapping("/add")
    public Personne addPersonne(@RequestBody Personne p){
        return this.personneService.addPersnone(p);
    }

    @PutMapping("/Update")
    public Personne Update(@RequestBody Personne p){
        return this.personneService.UpdatePersone(p);
    }
    @DeleteMapping("/Delete/{id}")
    public void DeletePersonne(@PathVariable Long id){
        this.personneService.DeletePersonne(id);
    }

    @PostMapping("/reserver/{idhomme}/{idfemme}")
    public Mariage Reserver(Long idhomme,Long idfemme,@RequestBody Mariage m){
        return this.personneService.reserver(idhomme,idfemme,m);
    }
    @PostMapping("/confirmer/{idmariage}")
    public Salle Confirmer(@PathVariable  Long idmariage,@RequestBody Salle s){
        return this.personneService.confirmer(idmariage,s);
    }

}
