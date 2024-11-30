package br.com.rhribeiro25.domain;

import br.com.rhribeiro25.domain.enums.DepartmentEnum;
import br.com.rhribeiro25.domain.enums.RoleEnum;

public class Employee extends Person {

    private RoleEnum role;
    private Department department;

    public Employee() {}

    // Construtor privado (para impedir instâncias diretas sem o builder)
    private Employee(Builder builder) {
        this.role = builder.role;
        this.department = builder.department;
    }

    // Getter para role
    public RoleEnum getRole() {
        return role;
    }

    // Getter para department
    public Department getDepartment() {
        return department;
    }

    // Setter para role
    public void setRole(RoleEnum role) {
        this.role = role;
    }

    // Setter para department
    public void setDepartment(Department department) {
        this.department = department;
    }

    // Método toString para exibir informações detalhadas
    @Override
    public String toString() {
        return "\t\t\t\t\tName: " + this.getName() + "\n" +
                "\t\t\t\t\tRole: " + this.getRole().getDescription() + "\n" +
                "\t\t\t\t\tDepartment: " + this.getDepartment().getName();
    }

    // Método que retorna as informações do empregado em formato para salvar no arquivo
    public String contentToFile() {
        return this.getName() + "," +
                this.getRole() + "," +
                this.getDepartment().getName();
    }

    // Método que retorna as informações do empregado em uma linha, útil para imprimir em linha
    public String toStringInLine() {
        return this.getName() + "," +
                this.getRole().getDescription() + "," +
                DepartmentEnum.valueOf(this.getDepartment().getName()).getDescription();
    }

    // Classe Builder estática
    public static class Builder {

        private RoleEnum role;
        private Department department;

       public Builder role(RoleEnum role) {
            this.role = role;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        // Método para criar a instância do Employee
        public Employee build() {
            return new Employee(this);
        }
    }
}