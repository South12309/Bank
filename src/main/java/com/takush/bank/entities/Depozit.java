package com.takush.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="depozits")
public class Depozit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne
    @Column(name="product_id")
    private Product product;

    private String amount;
    private String percent;
    private int period;

    @Column(name="open_date")
    private Date openDate;

    @Column(name="update_date")
    private Date updateDate;
}
