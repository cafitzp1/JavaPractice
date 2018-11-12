package my.java.app;

public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next;
    private EmployeeNode previous;
  
    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() { return this.employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public EmployeeNode getNext() { return this.next; }
    public void setNext(EmployeeNode next) { this.next = next; }
    public EmployeeNode getPrevious() { return this.previous; }
    public void setPrevious(EmployeeNode previous) { this.previous = previous; }

    public String toString() {
        return employee.toString();
    }
}