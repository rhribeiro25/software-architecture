package br.com.rhribeiro25.domain.services;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.valueobjects.Department;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DepartmentService {

    public BigDecimal calculateTotalSalary(Department department) {
        return department.getEmployees().stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateAverageSalary(Department department) {
        long numberOfEmployees = department.getEmployees().size();
        if (numberOfEmployees == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalSalary = calculateTotalSalary(department);
        return totalSalary.divide(BigDecimal.valueOf(numberOfEmployees), RoundingMode.HALF_UP);
    }

    // Método para aplicar aumento salarial baseado no desempenho de todos os empregados
    public void applySalaryIncreases(Department department) {
        for (Employee employee : department.getEmployees()) {
            employee.applySalaryIncrease();
        }
    }

    // Método para gerar um relatório de desempenho do departamento
    public String generatePerformanceReport(Department department) {
        long highPerformers = department.countHighPerformers();
        BigDecimal totalSalaries = department.calculateTotalSalaries();

        return String.format("Department: %s\nHigh Performers: %d\nTotal Salaries: %s",
                department.getName(), highPerformers, totalSalaries);
    }
}