package com.takush.bank.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="lastName")
    private String lastName;
    @Column(name="name")
    private String name;
    @Column(name="pasport")
    private String pasport;
}
