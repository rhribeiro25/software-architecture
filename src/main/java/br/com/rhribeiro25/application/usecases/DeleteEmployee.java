package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.repositories.EmployeeRepository;

public class DeleteEmployee {
    private final EmployeeRepository employeeRepository;

    public DeleteEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean delete(String document) {
        return employeeRepository.deleteByDocument(document);
    }
}
