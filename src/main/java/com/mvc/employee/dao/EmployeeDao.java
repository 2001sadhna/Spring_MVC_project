package com.mvc.employee.dao;

import com.mvc.employee.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

    @Repository
    public class EmployeeDao {
        private static List<Employee> list = new ArrayList<>();
        private static int counter = 1;

        // CREATE / SAVE
        public void save(Employee e) {
            e.setId(counter++);
            list.add(e);
        }

        // READ ALL
        public List<Employee> getAllEmployees() {
            return list;
        }

        // READ BY ID
        public Employee getEmployeeById(int id) {
            return list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        }

        // UPDATE
        public void update(Employee e) {
            Employee existing = getEmployeeById(e.getId());
            if (existing != null) {
                existing.setFirstName(e.getFirstName());
                existing.setLastName(e.getLastName());
                existing.setEmail(e.getEmail());
            }
        }

        // DELETE
        public void delete(int id) {
            list.removeIf(e -> e.getId() == id);
        }
    }

