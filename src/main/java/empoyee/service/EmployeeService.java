package empoyee.service;

import empoyee.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmpolyee();

    Employee createEmployee(Employee employee);

    Employee getAllEmpolyeeById(Long id);

    Employee upadteEmpolyee(Employee employeeDeEmployee, Long id);
}
