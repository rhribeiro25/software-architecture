package br.com.rhribeiro25.infrastructure.database.entities;

import br.com.rhribeiro25.shared.enums.RoleEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employee")
public class EmployeeDbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column
    private int performanceRating;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "department_fkey"), nullable = false)
    private DepartmentDbEntity department;

    public EmployeeDbEntity(){}

    public EmployeeDbEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
        this.salary = builder.salary;
        this.department = builder.departmentDbEntity;
    }

    public Long getId() {
        return id;
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

    public DepartmentDbEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDbEntity departmentDbEntity) {
        this.department = departmentDbEntity;
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

    public static class Builder {

        private Long id;
        private String name;
        private RoleEnum role;
        private BigDecimal salary;
        private DepartmentDbEntity departmentDbEntity;

        public EmployeeDbEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDbEntity.Builder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeDbEntity.Builder role(RoleEnum role) {
            this.role = role;
            return this;
        }

        public EmployeeDbEntity.Builder salary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeDbEntity.Builder department(DepartmentDbEntity departmentDbEntity) {
            this.departmentDbEntity = departmentDbEntity;
            return this;
        }

        public EmployeeDbEntity build() {
            return new EmployeeDbEntity(this);
        }
    }
}
