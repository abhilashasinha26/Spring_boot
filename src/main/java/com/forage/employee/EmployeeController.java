package com.forage.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController

public class EmployeeController {
   public List<Employee> employeeList = new ArrayList<>();
   @GetMapping(value = "/emp")
    public ResponseEntity<List<Employee>> getAll(){
       if (employeeList.isEmpty()) {
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.ok(employeeList);

   }
   @PostMapping(value ="/employee")
    public Employee addEmployee(@RequestBody Employee employee){
       employee.setEmployeeId(employee.getEmployeeId());
       employee.setFirstName(employee.getFirstName());
       employee.setLastName(employee.getLastName());
       employee.setEmail(employee.getEmail());
       employee.setTittle(employee.getTittle());
       employeeList.add(employee);
       return employee;
   }
   @PutMapping(value ="/update")
   public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
      if(employeeList.isEmpty()){
         return  ResponseEntity.noContent().build();
      }
      if(employeeList.contains(employee.getEmployeeId())){
         employee.setEmployeeId(employee.getEmployeeId());
         employee.setFirstName(employee.getFirstName());
         employee.setLastName(employee.getLastName());
         employee.setEmail(employee.getEmail());
         employee.setTittle(employee.getTittle());
         employeeList.add(employee);
      }
      return ResponseEntity.ok(employee);
   }

}
