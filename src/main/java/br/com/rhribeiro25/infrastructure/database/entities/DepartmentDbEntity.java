package br.com.rhribeiro25.infrastructure.database.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "department",
        uniqueConstraints = @UniqueConstraint(name = "employee_code_uk", columnNames = {"code"})
)
public class DepartmentDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column
    private String name;

    @OneToMany(mappedBy = "department")
    private List<EmployeeDbEntity> employees;

    public DepartmentDbEntity() {}

    private DepartmentDbEntity(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
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

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "DepartmentDbEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private Long id;
        private String code;
        private String name;

        public DepartmentDbEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public DepartmentDbEntity.Builder code(String code) {
            this.code = code;
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
