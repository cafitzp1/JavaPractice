package my.java.app;

public class Employee {

    // instance fields
    private String firstName;
    private String lastName;
    private int id;
  
    // constructor
    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
  
    // getter and setter methods
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return this.firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return this.lastName; }
    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }
  
    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;

        return true;
    }
  
    // hashcode
    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + id;
        return result;
    }
  
    // to string
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id + '\'' +
                '}';
    }
}