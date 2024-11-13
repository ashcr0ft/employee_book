package pro.sky.employee_book;

import org.springframework.stereotype.Service;
import pro.sky.employee_book.Exeptions.EmployeeAlreadyAddedException;
import pro.sky.employee_book.Exeptions.EmployeeNotFound;
import pro.sky.employee_book.Exeptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServImpl implements EmployeeServ {
    final int MAX_EMPLOYEE = 3;
    private static List<Employee> employees = new ArrayList<>();

    @Override
    public Employee createEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() == MAX_EMPLOYEE) {
            throw new EmployeeStorageIsFullException("Превышено количество сотрудников");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    public Collection<Employee> getAll() {
        return employees;
    }
}
