package com.example.mariage.Controller;

import com.example.mariage.Entity.Salle;
import com.example.mariage.Service.SalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Salle")
public class SalleConroller {

    private SalleService salleService;

    public SalleConroller(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/all")
    public List<Salle> getAll() {
        List<Salle> salles = salleService.findAll();
        return salles;
    }

    @GetMapping("/{id}")
    public Optional<Salle> getById(@PathVariable Long id) {
        Optional<Salle> salle = salleService.findById(id);
        return salle;
    }

    @PostMapping("/add")
    public Salle add(@RequestBody Salle salle) {
        Salle newSalle = salleService.addSalle(salle);
        return newSalle;
    }

    @PutMapping("/Update")
    public Salle update(@RequestBody Salle salle) {
        Salle newSalle = salleService.updateSalle(salle);
        return newSalle;
    }

    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        salleService.deleteSalle(id);
    }
}
