package my.java.app;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Object myObject = new Object();
        String myVar = "hello";
        myObject = myVar;

        Employee emp = new Employee();
        Accountant acc = new Accountant();
        emp = acc;

        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee());
        ArrayList<Accountant> accountants = new ArrayList<Accountant>();
        accountants.add(new Accountant());
        // employees = accountants;

        ArrayList<?> employees2 = new ArrayList<>();
        ArrayList<Accountant> accountants2 = new ArrayList<>();
        employees2 = accountants2;

        // upper bound
        ArrayList<? extends Employee> employees3 = new ArrayList<>();
        ArrayList<Accountant> accountants3 = new ArrayList<>();
        employees3 = accountants3;

        // lower bound
        ArrayList<? super Employee> employees4 = new ArrayList<>();
        ArrayList<Object> accountants4 = new ArrayList<>();
        employees4 = accountants4; 

        makeEmployeeWork(accountants);
    }

    public static void makeEmployeeWork(List<? extends Employee> employees) {
        for (Employee emp : employees) {
            emp.work();
        }
    }
}