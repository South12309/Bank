package com.takush.bank.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class UserAbs {
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

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}

