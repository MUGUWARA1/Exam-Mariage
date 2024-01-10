package com.example.mariage.Repo;

import com.example.mariage.Entity.Mariage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MariageRepo extends JpaRepository<Mariage,Long> {
}
