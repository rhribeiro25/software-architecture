package br.com.rhribeiro25.infrastructure.files.entities;

import br.com.rhribeiro25.shared.enums.RoleEnum;

public class EmployeeFileEntity {

    private Long id;
    private String name;
    private RoleEnum role;
    private DepartmentFileEntity department;

    public EmployeeFileEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
        this.department = builder.department;
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

    public DepartmentFileEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentFileEntity department) {
        this.department = department;
    }

    public static class Builder {

        private Long id;
        private String name;
        private RoleEnum role;
        private DepartmentFileEntity department;

        public Builder id(Long id) {
            this.id = id;
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

        public Builder department(DepartmentFileEntity department) {
            this.department = department;
            return this;
        }

        public EmployeeFileEntity build() {
            return new EmployeeFileEntity(this);
        }
    }
}
