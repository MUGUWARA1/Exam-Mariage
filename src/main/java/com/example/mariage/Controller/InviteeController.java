package com.example.mariage.Controller;

import com.example.mariage.Entity.Invite;
import com.example.mariage.Service.InviteeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Invitee")
public class InviteeController {

    private final InviteeService inviteService;

    public InviteeController(InviteeService inviteService) {
        this.inviteService = inviteService;
    }

    @GetMapping("/all")
    public List<Invite> getAll() {
        List<Invite> invites = inviteService.findAll();
        return invites;
    }

    @GetMapping("/find/{id}")
    public Optional<Invite> getById(@PathVariable("id") Long id) {
        Optional<Invite> invite = inviteService.findById(id);
        return invite;
    }

    @PostMapping("/add")
    public Invite add(@RequestBody Invite invite) {
        Invite newInvite = inviteService.addInvite(invite);
        return newInvite;
    }

    @PutMapping("/update")
    public Invite update(@RequestBody Invite invite) {
        Invite newInvite = inviteService.updateInvite(invite);
        return newInvite;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        inviteService.deleteInvite(id);
    }


}
