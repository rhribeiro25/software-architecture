package br.com.rhribeiro25.domain.valueobjects;

public class DepartmentCode {
    private String value;

    public String getValue() {
        return value;
    }

    private DepartmentCode(DepartmentCode.Builder builder) {
        this.value = builder.value;
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private String value;

        public DepartmentCode.Builder value(String value) {
            this.value = value;
            return this;
        }

        public DepartmentCode build() {
            return new DepartmentCode(this);
        }
    }
}
