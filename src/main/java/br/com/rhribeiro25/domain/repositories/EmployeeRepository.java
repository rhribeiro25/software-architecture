package br.com.rhribeiro25.domain.repositories;

import br.com.rhribeiro25.domain.models.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    Employee update(Employee employee, Long id);
}
