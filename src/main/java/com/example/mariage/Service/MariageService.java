package com.example.mariage.Service;

import com.example.mariage.Controller.MariageController;
import com.example.mariage.Entity.Invite;
import com.example.mariage.Entity.Mariage;
import com.example.mariage.Repo.InvRepo;
import com.example.mariage.Repo.MariageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MariageService {
    private MariageRepo mariageRepo;
    private InvRepo invrepo;

    public MariageService(MariageRepo mariageRepo, InvRepo invrepo) {
        this.mariageRepo = mariageRepo;
        this.invrepo = invrepo;
    }

    public List<Mariage> getALL(){
        return mariageRepo.findAll();
    }
    public Mariage getMariageId(Long id){
        return mariageRepo.findById(id).
                orElseThrow(()-> new RuntimeException("this id not Founded"));
    }

    public Mariage addMariage(Mariage m){
        return this.mariageRepo.save(m);
    }
    public Mariage UpdateMariage(Mariage m){
        if(this.getMariageId(m.getNum())!=null){
            return mariageRepo.save(m);
        }
        return null;
    }

    public void DeleteMariageByID(Long id){
        this.mariageRepo.deleteById(id);
    }
    public Mariage qrinvitation(Long mariage_id, Invite inv){
        Mariage mariage=this.getMariageId(mariage_id);

         mariage.getInvitees().add(inv);
         inv.getMariages().add(mariage);
         invrepo.save(inv);
         mariageRepo.save(mariage);

         return mariage;

    }

}
