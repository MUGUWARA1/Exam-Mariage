package com.example.mariage.Repo;

import com.example.mariage.Entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepo extends JpaRepository<Personne,Long> {

}
