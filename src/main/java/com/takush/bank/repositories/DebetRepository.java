package com.takush.bank.repositories;

import com.takush.bank.entities.Debet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebetRepository extends JpaRepository<Debet, Long> {
}