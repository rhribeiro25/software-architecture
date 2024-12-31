package br.com.rhribeiro25.interfaces.dtos;

import br.com.rhribeiro25.shared.enums.RoleEnum;

//Dto Request
public record EmployeeRequest(

        String name,
        RoleEnum role,
        DepartmentRequest department
) {

    public static class Builder {


        private String name;
        private RoleEnum role;
        private DepartmentRequest department;


        public EmployeeRequest.Builder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeRequest.Builder role(RoleEnum role) {
            this.role = role;
            return this;
        }

        public EmployeeRequest.Builder department(DepartmentRequest department) {
            this.department = department;
            return this;
        }

        public EmployeeRequest build() {
            return new EmployeeRequest(name, role, department);
        }
    }
}
