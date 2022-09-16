package com.accountOpening.model;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long clientId;
    String clientName;
    String clientMobile;
    String clientAge;

    public Client() {
        super();
    }

    public Client(Long clientId, String clientName, String clientMobile, String clientAge) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientMobile = clientMobile;
        this.clientAge = clientAge;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public String getClientAge() {
        return clientAge;
    }

    public void setClientAge(String clientAge) {
        this.clientAge = clientAge;
    }

}
