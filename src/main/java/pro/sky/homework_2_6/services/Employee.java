package pro.sky.homework_2_6.services;

import java.util.Objects;

public class Employee {

    //                      Сотрудник
    private String firstName;
    private String lastName;

    public Employee(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "имя: " + firstName +
                " фамилия: " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}