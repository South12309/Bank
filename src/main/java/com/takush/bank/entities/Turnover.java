package com.takush.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="turnovers")
public class Turnover {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne

    private Account account;


    private Long balance;
    @Column(name="incoming_balance")
    private Long incomingBalance;
    @Column(name="outgoing_balance")
    private Long outgoingBalance;

    @Column(name="operdate")
    private Date operDate;
}

