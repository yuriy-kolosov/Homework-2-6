package pro.sky.homework_2_6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_6.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework_2_6.exceptions.EmployeeNotFoundException;
import pro.sky.homework_2_6.exceptions.EmployeeStorageIsFullException;
import pro.sky.homework_2_6.services.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String fName,
                      @RequestParam("lastName") String lName) {

        try {
            return employeeService.add(fName, lName);
        } catch (EmployeeAlreadyAddedException e) {
            throw new EmployeeAlreadyAddedException();
        } catch (EmployeeStorageIsFullException e) {
            throw new EmployeeStorageIsFullException();
        }

    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("firstName") String fName,
                       @RequestParam("lastName") String lName) {

        try {
            return employeeService.find(fName, lName);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }

    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("firstName") String fName,
                         @RequestParam("lastName") String lName) {

        try {
            return employeeService.remove(fName, lName);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }

    }

    @GetMapping(path = "/browse")
    public String browse() {

        try {
            return employeeService.browseAll();
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }

    }

}