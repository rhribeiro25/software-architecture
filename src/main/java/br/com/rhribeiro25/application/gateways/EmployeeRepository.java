package br.com.rhribeiro25.application.gateways;

import br.com.rhribeiro25.domain.Employee;

import java.io.IOException;

public interface EmployeeRepository {
    void write(Employee employee, String pathFile);

    Employee[] readAll(String pathFile) throws IOException;
}
