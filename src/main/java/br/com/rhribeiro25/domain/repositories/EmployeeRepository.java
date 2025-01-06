package br.com.rhribeiro25.domain.repositories;

import br.com.rhribeiro25.domain.models.Employee;

import java.util.List;

// Strategy Design Pattern offers flexibility to update, reusability across contexts,
// and scalability for complex cases with new strategies.

public interface EmployeeRepository {

    List<Employee> findAll();

    Employee save(Employee employee);

    Employee update(Employee employee, Long id);

    Employee findByDocument(String document);

    boolean deleteByDocument(String document);
}
