package com.example.mariage.Service;

import com.example.mariage.Entity.Invite;
import com.example.mariage.Repo.InvRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InviteeService {
    private InvRepo invRepo;
    public InviteeService(InvRepo inviteRepository) {
        this.invRepo = inviteRepository;
    }

    public List<Invite> findAll() {
        return invRepo.findAll();
    }

    public Optional<Invite> findById(Long id) {
        return invRepo.findById(id);
    }

    public Invite addInvite(Invite invite) {
        return invRepo.save(invite);
    }

    public Invite updateInvite(Invite invite) {
        if(invRepo.findById(invite.getId()) != null)
            return invRepo.save(invite);
        return null;
    }

    public void deleteInvite(Long id) {
        invRepo.deleteById(id);
}
}