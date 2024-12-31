package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.repositories.DepartmentRepository;
import br.com.rhribeiro25.domain.services.DepartmentService;
import br.com.rhribeiro25.domain.valueobjects.Department;

import java.math.BigDecimal;

public class GetAverageSalary {

    private final DepartmentRepository departmentRepository;
    private final DepartmentService salaryService;

    public GetAverageSalary(DepartmentRepository departmentRepository, DepartmentService salaryService) {
        this.departmentRepository = departmentRepository;
        this.salaryService = salaryService;
    }

    public BigDecimal getAverageSalary(String departmentId) {
        Department department = departmentRepository.findById(departmentId);
        if (department == null) {
            throw new IllegalArgumentException("Department not found");
        }

        return salaryService.calculateAverageSalary(department);
    }
}
