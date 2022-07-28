package com.takush.bank.dto;

import com.takush.bank.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDto {

    private String login;
    private String password;
    private String matchingPassword;
    private Role role;
    private String lastName;
    private String name;

    public UserDto() {
    }

    public UserDto(String login, String password, String matchingPassword, Role role, String lastName, String name) {

        this.login = login;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.role = role;
        this.lastName = lastName;
        this.name = name;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getRole() {
        return role.name();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
