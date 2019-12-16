package by.bsuir.devteam.entity.employee;

import java.util.Comparator;

public class EmployeeIdComparator implements Comparator<Employee> {

    public int compare(Employee a, Employee b){

        return Integer.compare(a.getId(), b.getId());
    }
}
