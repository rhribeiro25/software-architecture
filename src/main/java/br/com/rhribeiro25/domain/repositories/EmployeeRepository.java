package br.com.rhribeiro25.domain.repositories;

import br.com.rhribeiro25.domain.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee save(Employee employee);

    List<Employee> findAll();
}
