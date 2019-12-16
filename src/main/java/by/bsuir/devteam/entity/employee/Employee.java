package by.bsuir.devteam.entity.employee;

import by.bsuir.devteam.entity.Entity;

import java.util.Objects;

/***
 * Basic parent class for all employees in the team
 */
public abstract class Employee extends Entity implements Comparable<Employee>{

    private String name;
    private String surname;
    private String phoneNumber;

    /***
     * Name getter
     * @return Returns the name of an employee
     */
    public String getName(){
        return this.name;
    }

    /***
     * Name setter
     * @param name New name to be set
     */
    public void setName(String name){
        this.name = name;
    }

    /***
     * Surname getter
     * @return Returns the surname of an employee
     */
    public String getSurname(){
        return this.surname;
    }

    /***
     * Surname setter
     * @param surname New surname to be set
     */
    public void setSurname(String surname){
        this.surname = surname;
    }

    /***
     * Phone number getter
     * @return Returns the phone number of an employee
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /***
     * Phone number setter
     * @param phoneNumber New phone number to be set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Name: " + name + System.lineSeparator() +
                "Surname: " + surname + System.lineSeparator() +
                "Phone number: " + phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, surname, phoneNumber);
    }

    /***
     * Comparable<Employee> interface method, implements naturalOrder comparison by full name
     * @param o An employee to be compared with
     * @return -1, 0, 1 - comparison result
     */
    @Override
    public int compareTo(Employee o) {

        int result = this.getSurname().compareTo(o.getSurname());
        return result == 0 ? this.getName().compareTo(o.getName()) : result;
    }
}