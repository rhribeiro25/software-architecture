package br.com.rhribeiro25.interfaces.dtos;

//Dto Request
public class DepartmentRequest {

    private String code;
    private String name;

    public DepartmentRequest() {}

    private DepartmentRequest(Builder builder) {
        this.code = builder.code;
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private String code;
        private String name;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentRequest build() {
            return new DepartmentRequest(this);
        }
    }
}
