package service.service;

import entity.Employee;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee withMaxSalary(int departmentId) {
        Collection<Employee> employees = employeeService.getAll();
        return employees.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }
}
