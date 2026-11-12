package com.mvc.employee.Controller;

import com.mvc.employee.dao.EmployeeDao;
import com.mvc.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

    @Controller
    public class EmployeeController {

        @Autowired
        private EmployeeDao employeeDao;

        // 1. READ: Show all employees on home page
        @GetMapping("/")
        public String viewHomePage(Model model) {
            model.addAttribute("listEmployees", employeeDao.getAllEmployees());
            return "index"; // maps to index.jsp
        }

        // 2. CREATE: Show form to add employee
        @GetMapping("/showNewEmployeeForm")
        public String showNewEmployeeForm(Model model) {
            model.addAttribute("employee", new Employee());
            return "new_employee"; // maps to new_employee.jsp
        }

        @PostMapping("/saveEmployee")
        public String saveEmployee(@ModelAttribute("employee") Employee employee) {
            employeeDao.save(employee);
            return "redirect:/";
        }

        // 3. UPDATE: Show form to edit employee
        @GetMapping("/showFormForUpdate/{id}")
        public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
            Employee employee = employeeDao.getEmployeeById(id);
            model.addAttribute("employee", employee);
            return "update_employee"; // maps to update_employee.jsp
        }

        @PostMapping("/updateEmployee")
        public String updateEmployee(@ModelAttribute("employee") Employee employee) {
            employeeDao.update(employee);
            return "redirect:/";
        }

        // 4. DELETE: Remove employee by ID
        @GetMapping("/deleteEmployee/{id}")
        public String deleteEmployee(@PathVariable(value = "id") int id) {
            employeeDao.delete(id);
            return "redirect:/";
        }
    }

