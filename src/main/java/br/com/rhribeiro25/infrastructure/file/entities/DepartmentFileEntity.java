package br.com.rhribeiro25.infrastructure.file.entities;

public class DepartmentFileEntity {

    private Long id;

    private String code;

    private String name;


    public DepartmentFileEntity() {}

    private DepartmentFileEntity(DepartmentFileEntity.Builder builder) {
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

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private Long id;
        private String code;
        private String name;

        public DepartmentFileEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public DepartmentFileEntity.Builder code(String code) {
            this.code = code;
            return this;
        }

        public DepartmentFileEntity.Builder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentFileEntity build() {
            return new DepartmentFileEntity(this);
        }
    }
}
