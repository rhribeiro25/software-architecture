package br.com.rhribeiro25.domain.models;

import br.com.rhribeiro25.domain.valueobjects.Department;
import br.com.rhribeiro25.shared.enums.DepartmentEnum;
import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private RoleEnum role;
    private int performanceRating; // 1 a 5, onde 5 é o melhor desempenho
    private BigDecimal salary;
    private Department department;

    public Employee() {}

    private Employee(Builder builder) {
        this.name = builder.name;
        this.role = builder.role;
        this.department = builder.department;
        this.salary = builder.salary;
        this.performanceRating = builder.performanceRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleEnum getRole() {
        return role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }

    // Método para aplicar aumento salarial baseado no desempenho
    public void applySalaryIncrease() {
        BigDecimal increasePercentage = switch (performanceRating) {
            case 5 -> BigDecimal.valueOf(0.10); // 10% de aumento para bom desempenho
            case 4 -> BigDecimal.valueOf(0.07); // 7% de aumento
            case 3 -> BigDecimal.valueOf(0.05); // 5% de aumento
            default -> BigDecimal.ZERO; // Sem aumento
        };
        this.salary = this.salary.add(this.salary.multiply(increasePercentage));
    }

    @Override
    public String toString() {
        return "\t\t\t\t\tName: " + this.getName() + "\n" +
                "\t\t\t\t\tRole: " + this.getRole().getDescription() + "\n" +
                "\t\t\t\t\tDepartmentFileEntity: " + this.getDepartment().getName();
    }

    public String contentToFile() {
        return this.getName() + "," +
                this.getRole() + "," +
                this.getDepartment().getName();
    }

    public String toStringInLine() {
        return this.getName() + "," +
                this.getRole().getDescription() + "," +
                DepartmentEnum.valueOf(this.getDepartment().getName()).getDescription();
    }

    public static class Builder {

        private String name;
        private RoleEnum role;
        private BigDecimal salary;
        private int performanceRating;
        private Department department;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

       public Builder role(RoleEnum role) {
            this.role = role;
            return this;
        }

        public Builder salary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public Builder performanceRating(int performanceRating) {
            this.performanceRating = performanceRating;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}