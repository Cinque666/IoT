package by.pvt.repository;

public enum Role {

    ANALYST("ANALYST"),
    ADMIN("ADMIN");

    Role(String role){
        this.role = role;
    }

    private String role;

    public String getRole() {
        return role;
    }
}
