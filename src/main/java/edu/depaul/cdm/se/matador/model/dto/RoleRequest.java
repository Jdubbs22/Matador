package edu.depaul.cdm.se.matador.model.dto;


public class RoleRequest {
    private String role;

    public String getRole(){
       this.role = role.toUpperCase();
       return this.role;
    }
    public void setRole(String role) {
        this.role = role.toUpperCase();
    }
}
