package my.java.app;

public class StoredEmployee {

    // raw key, NOT hashed value
    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}