package empoyee.service.Impl;

import empoyee.entity.Employee;
import empoyee.exception.ResourceNotFoundException;
import empoyee.repository.EmployeeRepository;
import empoyee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmpolyee() {
        return employeeRepository.findAll();

    }

    @Override
    public Employee createEmployee(Employee employee) {
        return  employeeRepository.save(employee);

    }

    @Override
    public Employee getAllEmpolyeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id Not Found With:"+id));
    }

    @Override
    public Employee upadteEmpolyee(Employee employeeDeEmployee, Long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With:" + id));
      emp.setEmail(employeeDeEmployee.getEmail());
      emp.setFirstName(employeeDeEmployee.getFirstName());
      emp.setLastName(employeeDeEmployee.getLastName());
      return employeeRepository.save(emp);


    }
}
