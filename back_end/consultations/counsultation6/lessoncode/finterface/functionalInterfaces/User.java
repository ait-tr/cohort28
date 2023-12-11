package finterface.functionalInterfaces;

class User {
    private String name, role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User Name: " + name + ", Role: " + role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
