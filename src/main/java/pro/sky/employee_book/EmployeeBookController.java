package pro.sky.employee_book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee_book.Exeptions.EmployeeAlreadyAddedException;
import pro.sky.employee_book.Exeptions.EmployeeNotFound;
import pro.sky.employee_book.Exeptions.EmployeeStorageIsFullException;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeBookController {
    private final EmployeeServ employeeService;

    public EmployeeBookController(EmployeeServ employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public Collection<Employee> hello() {
        return employeeService.getAll();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        return employeeService.createEmployee(firstName, lastName);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);

    }

}

