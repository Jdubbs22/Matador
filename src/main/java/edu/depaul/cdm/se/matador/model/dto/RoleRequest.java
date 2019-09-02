package edu.depaul.cdm.se.matador.model.dto;


import lombok.Getter;

@Getter
public class RoleRequest {
    private String role;

    public void setRole(String role) {
        this.role = role.toUpperCase();
    }
}
