package br.com.rhribeiro25.application.dtos;

import br.com.rhribeiro25.shared.enums.RoleEnum;

// Dto Response
public record EmployeeResponse(
        String name,
        RoleEnum role,
        String departmentCnpj
) {

    public static class Builder {

        private String name;
        private RoleEnum role;
        private String departmentCnpj;


        public EmployeeResponse.Builder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeResponse.Builder role(RoleEnum role) {
            this.role = role;
            return this;
        }

        public EmployeeResponse.Builder departmentCnpj(String department) {
            this.departmentCnpj = department;
            return this;
        }

        public EmployeeResponse build() {
            return new EmployeeResponse(name, role, departmentCnpj);
        }
    }
}
