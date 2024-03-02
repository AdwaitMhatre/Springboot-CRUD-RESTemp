package net.javacrud.springboot.controller;

import net.javacrud.springboot.exception.ResourceNotFoundException;
import net.javacrud.springboot.model.Employee;
import net.javacrud.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees in the database
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with Id "+id+" does not exist"));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable long id,@RequestBody Employee employee){
        Employee empToUpdate = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with Id "+id+" does not exist"));

        empToUpdate.setFirstName(employee.getFirstName());
        empToUpdate.setLastName(employee.getLastName());
        empToUpdate.setEmailId(employee.getEmailId());

        employeeRepository.save(empToUpdate);
        return ResponseEntity.ok(empToUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable long id){
        Employee empToDelete = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with Id "+id+" does not exist"));

        employeeRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
