package pro.sky.employee_book;

import org.springframework.stereotype.Service;
import pro.sky.employee_book.Exeptions.EmployeeAlreadyAddedException;
import pro.sky.employee_book.Exeptions.EmployeeNotFound;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServImpl implements EmployeeServ {

    private static Map<String, Employee> employees = new HashMap<>();

    private static String generateKey(String surname, String firstName, String patronymic) {
        return surname + " " + firstName + " " + patronymic;
    }

    @Override
    public Employee createEmployee(String surname, String firstName, String patronymic) {
        Employee employee = new Employee(surname, firstName, patronymic);
        String key  = generateKey(surname, firstName, patronymic);
        if (!employees.containsKey(key)) {
            employees.put(key, employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }


    }


    @Override
    public Employee deleteEmployee(String surname, String firstName, String patronymic) {
        String key = generateKey(surname, firstName, patronymic);
        if (employees.containsKey(key)) {
            Employee employee = employees.get(key);
            employees.remove(key);
            return employee;
        } else {
            throw new EmployeeNotFound("Сотрудник не найден");
        }
    }

    @Override
    public Employee findEmployee(String surname, String firstName, String patronymic) {
        String key = generateKey(surname, firstName, patronymic);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    public String getAll() {
      return employees.toString();
    }
}
