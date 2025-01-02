package br.com.rhribeiro25.domain.services;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.valueobjects.CNPJ;
import br.com.rhribeiro25.shared.enums.RoleEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DepartmentServiceTest {
    @Test
    void shouldCalculateTotalSalary() {
        Department department = new Department.Builder().cnpj(new CNPJ.Builder().value("123456789").build()).name("Engineering").build();
        department.addEmployee(new Employee.Builder()
                .name("Alice")
                .role(RoleEnum.MAIN_MANAGER)
                .salary(BigDecimal.valueOf(5000))
                .departmentCnpj(department.getCnpj().getValue()).build());
        department.addEmployee(new Employee.Builder()
                .name("Fernando")
                .role(RoleEnum.MAIN_MANAGER)
                .salary(BigDecimal.valueOf(6000))
                .departmentCnpj(department.getCnpj().getValue()).build());

        DepartmentService salaryService = new DepartmentService();
        BigDecimal totalSalary = salaryService.calculateTotalSalary(department);

        Assertions.assertEquals(BigDecimal.valueOf(11000), totalSalary);
    }

    @Test
    void shouldCalculateAverageSalary() {
        Department department = new Department.Builder().cnpj(new CNPJ.Builder().value("123456789").build()).name("Engineering").build();
        department.addEmployee(new Employee.Builder()
                .name("Alice")
                .role(RoleEnum.MAIN_MANAGER)
                .salary(BigDecimal.valueOf(5000))
                .departmentCnpj(department.getCnpj().getValue()).build());
        department.addEmployee(new Employee.Builder()
                .name("Fernando")
                .role(RoleEnum.MAIN_MANAGER)
                .salary(BigDecimal.valueOf(6000))
                .departmentCnpj(department.getCnpj().getValue()).build());

        DepartmentService salaryService = new DepartmentService();
        BigDecimal averageSalary = salaryService.calculateAverageSalary(department);

        Assertions.assertEquals(BigDecimal.valueOf(5500), averageSalary);
    }

    @Test
    void shouldApplySalaryIncreaseBasedOnPerformance() {
        Department department = new Department.Builder().cnpj(new CNPJ.Builder().value("123456789").build()).name("Engineering").build();
        Employee employee = new Employee.Builder()
                .name("Fernando")
                .role(RoleEnum.MAIN_MANAGER)
                .salary(BigDecimal.valueOf(5000))
                .performanceRating(5)
                .departmentCnpj(department.getCnpj().getValue()).build();
        department.addEmployee(employee);

        DepartmentService departmentService = new DepartmentService();
        departmentService.applySalaryIncreases(department);

        Assertions.assertEquals(BigDecimal.valueOf(5500.0), employee.getSalary()); // Aumento de 10%
    }

    @Test
    void shouldGeneratePerformanceReport() {
        Department department = new Department.Builder().cnpj(new CNPJ.Builder().value("123456789").build()).name("Engineering").build();
        department.addEmployee(new Employee.Builder()
                .name("Alice")
                .role(RoleEnum.MAIN_MANAGER)
                .salary(BigDecimal.valueOf(5000))
                .performanceRating(5)
                .departmentCnpj(department.getCnpj().getValue()).build());
        department.addEmployee(new Employee.Builder()
                .name("Fernando")
                .role(RoleEnum.MAIN_MANAGER)
                .salary(BigDecimal.valueOf(4000))
                .performanceRating(3)
                .departmentCnpj(department.getCnpj().getValue()).build());

        DepartmentService departmentService = new DepartmentService();
        String report = departmentService.generatePerformanceReport(department);

        Assertions.assertTrue(report.contains("High Performers: 1"));
        Assertions.assertTrue(report.contains("Total Salaries: 9000"));
    }
}
