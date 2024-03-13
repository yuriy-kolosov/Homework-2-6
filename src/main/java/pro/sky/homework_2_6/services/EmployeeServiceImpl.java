package pro.sky.homework_2_6.services;

import org.springframework.stereotype.Service;
import pro.sky.homework_2_6.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework_2_6.exceptions.EmployeeNotFoundException;
import pro.sky.homework_2_6.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>(0);
    private final int EMPLOYEE_LIST_MAX_STORAGE = 5;
    private int employeeListStorage = 0;

    public String hello() {
        return "<b>Домашнее задание 2-6 </b>(листы и сеты)";
    }

    public String prompt() {
        return "Учет сотрудников. Введите тип операции ( /add? | /remove? | /find? ), имя (firstName=) и фамилию (lastName=) сотрудника. " +
                "Для просмотра полного списка сотрудников введите /browse";
    }

    public String add(String firstName, String lastName)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {

        Employee e = new Employee(firstName, lastName);

        if (employeeList.contains(e)) {

            System.out.print("Выбрасываем исключение: Employee Already Added");             // Проверка
            System.out.println(" Текущее состояние списка: " + employeeList.toString());    // Проверка

            throw new EmployeeAlreadyAddedException("Employee Already Added");

        } else if (employeeListStorage >= EMPLOYEE_LIST_MAX_STORAGE) {

            System.out.print("Выбрасываем исключение: Employee Storage Is Full");           // Проверка
            System.out.println(" Текущее состояние списка: " + employeeList.toString());    // Проверка

            throw new EmployeeStorageIsFullException("Employee Storage Is Full");

        }

        employeeList.add(e);
        employeeListStorage++;

        System.out.print("Сотрудник добавлен: " + e.toString());                        // Проверка
        System.out.println(" Новое состояние списка: " + employeeList.toString());      // Проверка

        return "Сотрудник добавлен";

    }

    public String find(String firstName, String lastName) throws EmployeeNotFoundException {

        Employee e = new Employee(firstName, lastName);

        if (!employeeList.isEmpty() && employeeList.contains(e)) {

            System.out.print("Сотрудник найден: " + e.toString());                          // Проверка
            System.out.println(" Текущее состояние списка: " + employeeList.toString());    // Проверка

            return "Сотрудник найден";

        } else {

            System.out.print("Выбрасываем исключение: Employee Not Found");                 // Проверка
            System.out.println(" Текущее состояние списка: " + employeeList.toString());    // Проверка

            throw new EmployeeNotFoundException("Employee Not Found");

        }

    }


    public String remove(String firstName, String lastName) throws EmployeeNotFoundException {

        Employee e = new Employee(firstName, lastName);

        if (!employeeList.isEmpty() && employeeList.contains(e)) {

            employeeList.remove(e);
            employeeListStorage--;

            System.out.print("Сотрудник удален: " + e.toString());                          // Проверка
            System.out.println(" Новое состояние списка: " + employeeList.toString());      // Проверка

            return "Сотрудник удален";

        } else {

            System.out.print("Выбрасываем исключение: Employee Not Found");                 // Проверка
            System.out.println(" Текущее состояние списка: " + employeeList.toString());    // Проверка

            throw new EmployeeNotFoundException("Employee Not Found");

        }
    }

    public String browseAll() throws EmployeeNotFoundException {


        if (!employeeList.isEmpty()) {

            System.out.print("Список всех сотрудников: ");                                    // Проверка
            System.out.println(" Текущее состояние списка: " + employeeList.toString());      // Проверка

            return employeeList.toString();

        } else {

            System.out.print("Выбрасываем исключение: Employee Not Found");                 // Проверка
            System.out.println(" Список пуст: " + employeeList.toString());                 // Проверка

            throw new EmployeeNotFoundException("Employee Not Found");

        }

    }

}