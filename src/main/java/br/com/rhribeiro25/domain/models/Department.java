package br.com.rhribeiro25.domain.models;

import br.com.rhribeiro25.domain.valueobjects.CNPJ;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Department {

    private CNPJ code;

    private String name;

    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    private Department(Department.Builder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public CNPJ getCode() {
        return code;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Método para calcular o total de salários no departamento
    public BigDecimal calculateTotalSalaries() {
        return employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Método para contar o número de empregados de alto desempenho
    public long countHighPerformers() {
        return employees.stream()
                .filter(employee -> employee.getPerformanceRating() >= 4)
                .count();
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Builder {

        private CNPJ code;

        private String name;

        private List<Employee> employees;

        public Department.Builder code(CNPJ code) {
            this.code = code;
            return this;
        }

        public Department.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Department.Builder employees(List<Employee> employees) {
            this.employees = employees;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}
