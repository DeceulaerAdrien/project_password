package com.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.security.passwordUtils;

public class User extends BaseEntity<UUID> {

    private String passwordHash;
    private String salt;

    public User(String username, char[] password) throws Exception {
        super(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now());
        this.salt = passwordUtils.generateSalt();
        this.passwordHash = passwordUtils.hashPassword(password, this.salt);
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

}
