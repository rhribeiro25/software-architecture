package br.com.rhribeiro25.domain.valueobjects.department;

public class Code {
    private String value;

    public String getValue() {
        return value;
    }

    private Code(Code.Builder builder) {
        this.value = builder.value;
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private String value;

        public Code.Builder value(String value) {
            this.value = value;
            return this;
        }

        public Code build() {
            return new Code(this);
        }
    }
}
