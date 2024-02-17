package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class ParentUser extends User {

    @OneToOne(mappedBy = "userAccount")
    private Parent parent;

    public ParentUser() {}

    public ParentUser(String username, String password) {
        super(username, password);
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

}