package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.gateways.EmployeeRepository;
import br.com.rhribeiro25.domain.Department;
import br.com.rhribeiro25.domain.Employee;
import br.com.rhribeiro25.domain.enums.DepartmentEnum;
import br.com.rhribeiro25.domain.enums.RoleEnum;

import java.io.IOException;

public class ReadEmployee {

    private EmployeeRepository employeeRepository;

    public ReadEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee[] readAll(String pathFile) throws IOException {
        return employeeRepository.readAll(pathFile);
    }
}