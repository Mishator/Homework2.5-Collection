package controller.controller;

import entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max")
    public Employee withMaxSalary(@RequestParam(name = "Id") int departmentId) {
        return departmentService.withMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee withMinSalary(@RequestParam int departmentId) {
        return departmentService.withMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> employeesByDepartment(@RequestParam(required = false) Integer departmentId) {
        return departmentService.employeesByDepartment(departmentId);
    }

}
