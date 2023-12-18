package org.example.app.constant;

public enum Role {
    ADMIN(1),
    USER(0);
    private int role;
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    Role(int role) {
        this.role = role;
    }
}
