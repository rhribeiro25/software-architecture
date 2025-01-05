package br.com.rhribeiro25.domain.models;

import br.com.rhribeiro25.domain.valueobjects.employee.Document;
import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.math.BigDecimal;

public class Employee {

    private Document document;
    private String name;
    private RoleEnum role;
    private int performanceRating; // 1 a 5, onde 5 é o melhor desempenho
    private BigDecimal salary;
    private String departmentCode;

    public Employee() {}

    private Employee(Builder builder) {
        this.document = builder.document;
        this.name = builder.name;
        this.role = builder.role;
        this.departmentCode = builder.departmentCode;
        this.salary = builder.salary;
        this.performanceRating = builder.performanceRating;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
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
        return "Employee{" +
                "document=" + document +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", performanceRating=" + performanceRating +
                ", salary=" + salary +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }

    public String contentToFile() {
        return this.getName() + "," +
                this.getRole() + "," +
                this.getDepartmentCode();
    }

    public String toStringInLine() {
        return "";
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private Document document;
        private String name;
        private RoleEnum role;
        private BigDecimal salary;
        private int performanceRating;
        private String departmentCode;

        public Builder document(Document document) {
            this.document = document;
            return this;
        }

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

        public Builder departmentCode(String departmentCode) {
            this.departmentCode = departmentCode;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}