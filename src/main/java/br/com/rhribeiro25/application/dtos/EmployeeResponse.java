package br.com.rhribeiro25.application.dtos;

import br.com.rhribeiro25.shared.enums.RoleEnum;

// Dto Response
public record EmployeeResponse(
        Long id,
        String name,
        RoleEnum role,
        DepartmentResponse department
) {

    public static class Builder {

        private Long id;
        private String name;
        private RoleEnum role;
        private DepartmentResponse department;

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

        public Builder department(DepartmentResponse department) {
            this.department = department;
            return this;
        }

        public EmployeeResponse build() {
            return new EmployeeResponse(id, name, role, department);
        }
    }
}
