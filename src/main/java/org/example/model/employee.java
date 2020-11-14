package org.example.model;

import org.mindrot.jbcrypt.BCrypt;

public class employee {
    private long id;
    private String username;
    private String password;

    public employee() {}

    public employee(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public employee(String username, String password) {
        this.username = username;
        this.setPassword(password);
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
