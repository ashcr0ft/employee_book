package pro.sky.employee_book;

import org.springframework.stereotype.Service;
import pro.sky.employee_book.Exeptions.EmployeeAlreadyAddedException;
import pro.sky.employee_book.Exeptions.EmployeeNotFound;
import pro.sky.employee_book.Exeptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    final int MAX_EMPLOYEE = 3;
    private static List<Employee> employees = new ArrayList<>();

    public Employee createEmployee(String firstName, String lastName) {
        if (employees.size() == MAX_EMPLOYEE) {
            throw new EmployeeStorageIsFullException("Превышено количество сотрудников");
        }
        for (Employee value : employees) {
            if (value.getFirstName().contains(firstName) &&
                    value.getLastName().contains(lastName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
            }
        }
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        return employee;
    }


    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        boolean isExist = false;
        Employee employee = null;
        for (Employee value : employees) {
            if (value.getFirstName().contains(firstName) &&
                    value.getLastName().contains(lastName)) {
                isExist = true;
                employee = value;
                break;
            }
        }
        if (!isExist) {
            throw new EmployeeNotFound("Сотрудник не найден");
        }
        return employee;
    }
    public String getAll () {
       return employees.toString();
    }
}
