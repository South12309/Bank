package com.takush.bank.repositories;

import com.takush.bank.entities.Turnover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoverRepository extends JpaRepository<Turnover, Long> {
}