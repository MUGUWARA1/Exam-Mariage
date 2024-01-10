package com.example.mariage.Repo;

import com.example.mariage.Entity.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvRepo extends JpaRepository<Invite,Long> {
}
