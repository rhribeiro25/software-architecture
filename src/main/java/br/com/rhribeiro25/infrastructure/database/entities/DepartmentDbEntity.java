package br.com.rhribeiro25.infrastructure.database.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "department",
        uniqueConstraints = @UniqueConstraint(name = "employee_id_cnpj_uk", columnNames = {"id", "cnpj"})
)
public class DepartmentDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cnpj;

    @Column
    private String name;

    @OneToMany(mappedBy = "department")
    private List<EmployeeDbEntity> employees;

    public DepartmentDbEntity() {}

    private DepartmentDbEntity(Builder builder) {
        this.id = builder.id;
        this.cnpj = builder.cnpj;
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<EmployeeDbEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDbEntity> employees) {
        this.employees = employees;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Builder {

        private Long id;
        private String cnpj;
        private String name;

        public DepartmentDbEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public DepartmentDbEntity.Builder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentDbEntity build() {
            return new DepartmentDbEntity(this);
        }
    }
}
