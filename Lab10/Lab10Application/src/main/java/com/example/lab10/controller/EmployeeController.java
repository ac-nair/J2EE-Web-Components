package com.example.lab10.controller;

import com.example.lab10.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // Initialize with a mutable list
    private List<Employee> employeeList = new ArrayList<>(List.of(
        new Employee(1L, "Akash Nair", "akashnair@gmail.com", "ITS")
    ));

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeList);
        return "employee-list"; // Maps to /WEB-INF/views/employee-list.jsp
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee-form";
        }
        employee.setId((long) (employeeList.size() + 1)); // Assign a new ID
        employeeList.add(employee); // Add to the mutable list
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (employee == null) {
            return "redirect:/employees"; // Redirect if no employee found
        }

        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid @ModelAttribute("employee") Employee updatedEmployee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee-form";
        }
        employeeList = employeeList.stream()
                .map(emp -> emp.getId().equals(id) ? updatedEmployee : emp)
                .toList();
        return "redirect:/employees";
    }
}
