package br.com.rhribeiro25.domain.models;

import br.com.rhribeiro25.domain.value_objects.Department;
import br.com.rhribeiro25.shared.enums.DepartmentEnum;
import br.com.rhribeiro25.shared.enums.RoleEnum;

public class Employee {

    private String name;
    private RoleEnum role;
    private Department department;

    public Employee() {}

    private Employee(Builder builder) {
        this.name = builder.name;
        this.role = builder.role;
        this.department = builder.department;
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
        private Department department;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

       public Builder role(RoleEnum role) {
            this.role = role;
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