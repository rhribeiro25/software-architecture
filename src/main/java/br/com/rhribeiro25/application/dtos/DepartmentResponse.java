package br.com.rhribeiro25.application.dtos;

// Dto Response
public class DepartmentResponse {

    private String name;

    public DepartmentResponse() {}

    private DepartmentResponse(Builder builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Builder {

        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentResponse build() {
            return new DepartmentResponse(this);
        }
    }
}
