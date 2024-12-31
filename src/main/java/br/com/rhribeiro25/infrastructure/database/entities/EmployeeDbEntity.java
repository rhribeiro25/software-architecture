package br.com.rhribeiro25.infrastructure.database.entities;

import br.com.rhribeiro25.shared.enums.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeDbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private RoleEnum role;
    private DepartmentDbEntity department;

    public EmployeeDbEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
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

    public static class Builder {

        private Long id;
        private String name;
        private RoleEnum role;
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

        public EmployeeDbEntity.Builder department(DepartmentDbEntity departmentDbEntity) {
            this.departmentDbEntity = departmentDbEntity;
            return this;
        }

        public EmployeeDbEntity build() {
            return new EmployeeDbEntity(this);
        }
    }
}
