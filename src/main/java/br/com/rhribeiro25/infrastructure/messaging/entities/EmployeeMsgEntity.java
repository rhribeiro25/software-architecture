package br.com.rhribeiro25.infrastructure.messaging.entities;

import br.com.rhribeiro25.shared.enums.RoleEnum;

public class EmployeeMsgEntity {

    private Long id;
    private String name;
    private RoleEnum role;
    private DepartmentMsgEntity department;

    public EmployeeMsgEntity(Builder builder) {
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

    public DepartmentMsgEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentMsgEntity department) {
        this.department = department;
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private Long id;
        private String name;
        private RoleEnum role;
        private DepartmentMsgEntity department;

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

        public Builder department(DepartmentMsgEntity department) {
            this.department = department;
            return this;
        }

        public EmployeeMsgEntity build() {
            return new EmployeeMsgEntity(this);
        }
    }
}
