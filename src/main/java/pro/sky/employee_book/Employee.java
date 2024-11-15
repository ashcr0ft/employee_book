package pro.sky.employee_book;

import java.util.Objects;

public class Employee {
    private final String surname;
    private final String firstName;
    private final String patronymic;

    public Employee(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(surname, employee.surname) && Objects.equals(firstName, employee.firstName) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, firstName, patronymic);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "patronymic='" + patronymic + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
