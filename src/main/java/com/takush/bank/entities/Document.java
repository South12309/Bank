package com.takush.bank.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne

    private Account debetAccount;

    @ManyToOne

    private Account creditAccount;


    private Long amount;
    private String type;
    private String purpose;

    @Column(name="operation_date")
    private Date operationDate;
}
