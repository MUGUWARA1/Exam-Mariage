package com.example.mariage.Controller;

import com.example.mariage.Entity.Invite;
import com.example.mariage.Entity.Mariage;
import com.example.mariage.Repo.MariageRepo;
import com.example.mariage.Service.MariageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Mariages")
public class MariageController {

    private MariageService mariageService;

    public MariageController(MariageService mariageService) {
        this.mariageService = mariageService;
    }

    @GetMapping("/")
    public List<Mariage> getALLMariages(){
        return this.mariageService.getALL();
    }
    @GetMapping("/{id}")
    public Mariage getMariageByID(@PathVariable Long id){
        return this.mariageService.getMariageId(id);
    }
    @PostMapping("/add")
    public Mariage addMariage(@RequestBody Mariage m){
        return this.mariageService.addMariage(m);
    }
    @PutMapping("/Update")
    public Mariage Update(@RequestBody Mariage m){
        return this.mariageService.UpdateMariage(m);
    }
    @DeleteMapping("/Delete/{id}")
    public void DeletebyId(@PathVariable Long id ){
        this.mariageService.DeleteMariageByID(id);
    }

    @PostMapping("/qrinvite/{mariageid}")
    public Mariage qrInvite(@PathVariable Long mariageid, @RequestBody Invite inv){
        return this.mariageService.qrinvitation(mariageid,inv);
    }








}
