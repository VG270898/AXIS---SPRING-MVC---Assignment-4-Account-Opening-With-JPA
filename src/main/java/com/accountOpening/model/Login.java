package com.accountOpening.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
    @Id
    Long clientId;
    String password;

    public Login() {
        super();
    }

    public Login(Long clientId, String password) {
        this.clientId = clientId;
        this.password = password;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
