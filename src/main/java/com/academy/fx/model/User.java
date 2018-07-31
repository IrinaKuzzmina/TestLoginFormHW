package com.academy.fx.model;

public class User {
    private String firstName;
    private String lastName;
    private String mail;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.mail = builder.mail;
        this.password = builder.password;
    }

    public static Builder newUser() {
        return new Builder();
    }


    public static final class Builder {
        private String firstName;
        private String lastName;
        private String mail;
        private String password;

        private Builder() {
        }

        public User build() {
            return new User(this);
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withMail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }
    }
}
