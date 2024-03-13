package pro.sky.homework_2_6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        return employeeService.add(fName, lName);
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("firstName") String fName,
                       @RequestParam("lastName") String lName) {
        return employeeService.find(fName, lName);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("firstName") String fName,
                         @RequestParam("lastName") String lName) {
        return employeeService.remove(fName, lName);
    }

    @GetMapping(path = "/browse")
    public String browse() {
        return employeeService.browseAll();
    }

}