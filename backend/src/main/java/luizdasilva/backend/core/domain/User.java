package luizdasilva.backend.core.domain;

import luizdasilva.backend.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;

public class User {
    private String username;
    private String email;
    private String password;
    private UserTypeEnum type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(String username, String email, String password, UserTypeEnum type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
