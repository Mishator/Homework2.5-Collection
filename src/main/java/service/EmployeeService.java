package service;

import entity.Employee;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final int MAX_SIZE = 2;

    public EmployeeService() {
        employees.add(new Employee("Макар", "Макаров", 3, 65000));
        employees.add(new Employee("Макар", "Макаров", 3, 65000));
        employees.add(new Employee("Александр", "Кержаков", 1, 165000));
        employees.add(new Employee("Андрей", "Аршавин", 2, 265000));
        employees.add(new Employee("Валера", "Карпин", 4, 500));
        employees.add(new Employee("Сергей", "Семак", 3, 365000));
    }

    public Employee add(String firstName, String lastName) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }

        Employee newEmployee = new Employee(firstName, lastName);


        if (employees.contains(newEmployee)) {

            throw new EmployeeAlreadyAddedException("Сотрудник " + newEmployee + " уже существует");
        }
        employees.add(newEmployee);
        return newEmployee;

    }


    public Employee find(String firstName, String lastName) {
        Employee employeeForFind = new Employee(firstName, lastName);

        if (!employees.contains(employeeForFind)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }

        return employees.get(employees.indexOf(employeeForFind));
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeForRemove = new Employee(firstName, lastName);

        if (!employees.contains(employeeForRemove)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }

        employees.remove(employeeForRemove);
        return employeeForRemove;
    }

    public List<Employee> getAll() {
        return employees;
    }

 //   private void checkExistence(String fullName) {
 //       if (!employeeByFullName.containsKey(fullName)) {
 //           throw new EmployeeNotFoundException("Такого сотрудника нет");
 //       }
 //       checkExistence(fullName);
 //   }

 //   private String getFullName(Employee employee) {
 //       return employee.getFirstName() + employee.getLastName();
 //   }

}
