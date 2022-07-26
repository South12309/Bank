package com.takush.bank.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private Role role;
    @Column(name="lastName")
    private String lastName;
    @Column(name="name")
    private String name;

}

