package service.service;

import entity.Employee;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.cglib.core.CollectionUtils.filter;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee withMaxSalary(Integer departmentId) {
        return streamByDepartment(departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    public Employee withMinSalary(Integer departmentId) {
        return streamByDepartment(departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    private Stream<Employee> streamByDepartment(Integer departmentId) {
        List<Employee> employees = employeeService.getAll();
        return employees.stream().filter(e -> departmentId == null || e.getDepartmentId().equals(departmentId));
    }

    public Map<Integer, List<Employee>> employeesByDepartment(Integer departmentId) {
                return streamByDepartment(departmentId)
                .collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.toList()));
    }
}
