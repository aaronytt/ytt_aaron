package com.ytt.model;

import java.io.Serializable;
import java.util.Objects;

public class RUser implements Serializable {

    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RUser)) return false;
        RUser rUser = (RUser) o;
        return Objects.equals(getUsername(), rUser.getUsername()) &&
                Objects.equals(getPassword(), rUser.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "RUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
