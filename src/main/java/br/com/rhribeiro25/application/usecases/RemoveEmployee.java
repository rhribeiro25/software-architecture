package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

public class RemoveEmployee {
    private final EmployeeRepository employeeRepository;

    public RemoveEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean remove(String document) {
        return employeeRepository.deleteByDocument(document);
    }
}
