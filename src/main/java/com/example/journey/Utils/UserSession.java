package com.example.journey.Utils;

import java.util.HashSet;
import java.util.Set;

public final class UserSession {

    private static UserSession instance;

    private String userName;
    private Set<String> privileges;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserSession(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public static UserSession getInstance(String firstName, String lastName, String email, String password) {
        if (instance == null) {
            instance = new UserSession(firstName, lastName, email, password);
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public Set<String> getPrivileges() {
        return privileges;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void cleanUserSession() {
        userName = "";
        privileges = new HashSet<>();
        firstName = "";
        lastName = "";
        email = "";
        password = "";
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}