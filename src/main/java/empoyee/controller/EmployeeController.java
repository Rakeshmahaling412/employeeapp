package empoyee.controller;

import empoyee.entity.Employee;
import empoyee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/v1")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmpolyee(){
        List<Employee> allEmpolyee = employeeService.getAllEmpolyee();
        return new ResponseEntity<>(allEmpolyee, HttpStatus.OK);

    }

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.createEmployee(employee);
        return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee allEmpolyeeById = employeeService.getAllEmpolyeeById(id);
        return new ResponseEntity<>(allEmpolyeeById,HttpStatus.OK);

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmpolyee(@PathVariable Long id,@RequestBody Employee employeeDeEmployee){
        Employee employee = employeeService.upadteEmpolyee(employeeDeEmployee, id);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);

    }

}
