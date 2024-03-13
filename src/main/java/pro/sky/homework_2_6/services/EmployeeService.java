package pro.sky.homework_2_6.services;

public interface EmployeeService {

    String add(String firstName, String lastName);

    String remove(String firstName, String lastName);

    String find(String firstName, String lastName);

    String browseAll();

}