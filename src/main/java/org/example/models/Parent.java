package org.example.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

    @Entity
    public class Parent extends AbstractEntity {

        @NotBlank(message = "First Name is required")
        @Size(max = 50, message = "Name is too long")
        private String firstName;

        @NotBlank (message = "Last Name is required")
        @Size (max = 50, message = "Last Name is too long")
        private String lastName;

        @OneToMany(mappedBy = "parent")
        private static List<Child> children = new ArrayList<>();


        @OneToOne(cascade = CascadeType.ALL)
        @NotNull
        private ParentUser userAccount;

        public Parent() {}

        public Parent(String firstName, String lastName, ParentUser parentUser) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.userAccount = parentUser;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public static List<Child> getChildren() {
            return children;
        }

        public void setChildren(List<Child> children) {
            this.children = children;
        }


        public ParentUser getUserAccount() {
            return userAccount;
        }

        public void setUserAccount(ParentUser userAccount) {
            this.userAccount = userAccount;
        }
    }

