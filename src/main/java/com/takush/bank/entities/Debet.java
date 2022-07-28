package com.takush.bank.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="debets")
public class Debet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne

    private Product product;

    private String balance;

    @Column(name="open_date")
    private Date openDate;

}
