package com.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.security.passwordUtils;

public class User extends BaseEntity<UUID> {

    private String username;
    private String passwordHash;
    private String salt;

    public User(String username, char[] password) throws Exception {
        super(UUID.randomUUID(), LocalDateTime.now(), LocalDateTime.now());
        this.username = username;
        this.salt = passwordUtils.generateSalt();
        this.passwordHash = passwordUtils.hashPassword(password, this.salt);
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", passwordHash=" + passwordHash + ", salt=" + salt + "]";
    }

    public Boolean verifyPassword(char[] attemptedPassword) throws Exception {
        return passwordUtils.verify(attemptedPassword, this.passwordHash, this.salt);
    }

    // Test
    public class Main {
        public static void main(String[] args) throws Exception {
            // Création d'un utilisateur
            User user = new User("Alice", "monSuperMotDePasse123".toCharArray());
            System.out.println("Username : " + user.getUsername());
            System.out.println("Salt : " + user.getSalt());
            System.out.println("Hash : " + user.getPasswordHash());

            // Vérification du mot de passe
            boolean correct = user.verifyPassword("monSuperMotDePasse123".toCharArray());
            System.out.println("Mot de passe correct ? " + correct);
        }
    }

}
