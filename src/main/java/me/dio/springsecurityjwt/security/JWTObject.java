package me.dio.springsecurityjwt.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JWTObject {

    private String subject;
    private Date issedAt;
    private Date expiration;
    private List<String> roles;

    public void setRoles(String... roles) {
        this.roles = Arrays.asList(roles);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getIssedAt() {
        return issedAt;
    }

    public void setIssedAt(Date issedAt) {
        this.issedAt = issedAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
