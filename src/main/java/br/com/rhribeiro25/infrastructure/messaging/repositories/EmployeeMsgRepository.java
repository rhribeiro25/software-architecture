package br.com.rhribeiro25.infrastructure.messaging.repositories;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeMsgRepository implements EmployeeRepository {

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Employee update(Employee employee, Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }
}
