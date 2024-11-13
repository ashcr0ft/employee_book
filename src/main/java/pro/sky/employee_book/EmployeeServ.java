package pro.sky.employee_book;

import java.util.Collection;

public interface EmployeeServ {
    Employee createEmployee(String firstName, String lastName);
    Employee deleteEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> getAll();
}
