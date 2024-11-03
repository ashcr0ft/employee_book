package pro.sky.employee_book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee_book.Exeptions.EmployeeAlreadyAddedException;
import pro.sky.employee_book.Exeptions.EmployeeNotFound;
import pro.sky.employee_book.Exeptions.EmployeeStorageIsFullException;

@RestController
@RequestMapping("/employee")

public class EmployeeBookController {
    private final EmployeeService employeeService;

    public EmployeeBookController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String hello() {
            return employeeService.getAll() ;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        try {
            return employeeService.createEmployee(firstName, lastName).toString();
        } catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        try {
            return employeeService.deleteEmployee(firstName, lastName).toString();
        } catch (EmployeeNotFound e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        try {
           return employeeService.findEmployee(firstName, lastName).toString();
        } catch (EmployeeNotFound e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

}

