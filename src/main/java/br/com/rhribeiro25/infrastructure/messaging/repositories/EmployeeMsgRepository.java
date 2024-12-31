package br.com.rhribeiro25.infrastructure.messaging.repositories;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMsgRepository implements EmployeeRepository {


    @Override
    public Employee save(Employee employee) {
        return new Employee();
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>();
    }
}
