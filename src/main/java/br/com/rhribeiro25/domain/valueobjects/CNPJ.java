package br.com.rhribeiro25.domain.valueobjects;

public class CNPJ {
    private String value;

    public String getValue() {
        return value;
    }

    private CNPJ(CNPJ.Builder builder) {
        this.value = builder.value;
    }

    public static class Builder {

        private String value;

        public CNPJ.Builder value(String value) {
            this.value = value;
            return this;
        }

        public CNPJ build() {
            return new CNPJ(this);
        }
    }
}
