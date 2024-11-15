package pro.sky.employee_book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeBookController {
    private final EmployeeServ employeeService;

    public EmployeeBookController(EmployeeServ employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String hello() {
        return employeeService.getAll();
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("surname") String surname,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("patronymic") String patronymic) {
        return employeeService.createEmployee(surname, firstName, patronymic).toString();
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("surname") String surname,
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("patronymic") String patronymic) {
        return employeeService.deleteEmployee(surname, firstName, patronymic).toString();

    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("surname") String surname,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("patronymic") String patronymic) {
        return employeeService.findEmployee(surname, firstName, patronymic).toString();

    }

}

