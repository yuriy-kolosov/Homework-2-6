package pro.sky.homework_2_6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_6.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework_2_6.exceptions.EmployeeNotFoundException;
import pro.sky.homework_2_6.exceptions.EmployeeStorageIsFullException;
import pro.sky.homework_2_6.services.EmployeeService;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String hello() {
        return employeeService.hello();
    }

    @GetMapping(path = "/employee")
    public String prompt() {
        return employeeService.prompt();
    }

    @GetMapping(path = "/employee/add")
    public String add(@RequestParam("firstName") String fName,
                      @RequestParam("lastName") String lName) {

        try {
            return employeeService.add(fName, lName);
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            return "Ошибка: " + e;
        }

    }

    @GetMapping(path = "/employee/find")
    public String find(@RequestParam("firstName") String fName,
                       @RequestParam("lastName") String lName) {

        try {
            return employeeService.find(fName, lName);
        } catch (EmployeeNotFoundException e) {
            return "Ошибка: " + e;
        }

    }

    @GetMapping(path = "/employee/remove")
    public String remove(@RequestParam("firstName") String fName,
                         @RequestParam("lastName") String lName) {

        try {
            return employeeService.remove(fName, lName);
        } catch (EmployeeNotFoundException e) {
            return "Ошибка: " + e;
        }

    }

    @GetMapping(path = "/employee/browse")
    public String browse() {

        try {
            return employeeService.browseAll();
        } catch (EmployeeNotFoundException e) {
            return "Ошибка: " + e;
        }

    }

}