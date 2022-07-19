package com.takush.bank.repositories;

import com.takush.bank.entities.Depozit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepozitRepository extends JpaRepository<Depozit, Long> {
}