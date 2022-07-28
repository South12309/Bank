package com.takush.bank.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="credits")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne

    private Product product;

    private String amount;
    private String percent;
    private int period;

    @Column(name="open_date")
    private Date openDate;

    @Column(name="update_date")
    private Date updateDate;
}
