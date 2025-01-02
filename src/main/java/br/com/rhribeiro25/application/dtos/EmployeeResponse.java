package br.com.rhribeiro25.application.dtos;

import br.com.rhribeiro25.shared.enums.RoleEnum;

// Dto Response
public record EmployeeResponse(
        String name,
        RoleEnum role,
        String departmentCode
) {

    public static class Builder {

        private String name;
        private RoleEnum role;
        private String departmentCode;


        public EmployeeResponse.Builder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeResponse.Builder role(RoleEnum role) {
            this.role = role;
            return this;
        }

        public EmployeeResponse.Builder departmentCode(String department) {
            this.departmentCode = department;
            return this;
        }

        public EmployeeResponse build() {
            return new EmployeeResponse(name, role, departmentCode);
        }
    }
}
