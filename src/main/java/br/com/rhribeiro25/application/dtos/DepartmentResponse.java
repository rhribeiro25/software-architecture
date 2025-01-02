package br.com.rhribeiro25.application.dtos;

// Dto Response
public class DepartmentResponse {

    private String cnpj;

    public DepartmentResponse() {}

    private DepartmentResponse(Builder builder) {
        this.cnpj = builder.cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }

    public static class Builder {

        private String cnpj;

        public Builder cnpj(String name) {
            this.cnpj = cnpj;
            return this;
        }

        public DepartmentResponse build() {
            return new DepartmentResponse(this);
        }
    }
}
