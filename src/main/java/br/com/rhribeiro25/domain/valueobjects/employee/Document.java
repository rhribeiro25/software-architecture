package br.com.rhribeiro25.domain.valueobjects.employee;

import br.com.rhribeiro25.shared.enums.DocumentTypeEnum;

public class Document {
    private DocumentTypeEnum type;
    private String value;

    public String getValue() {
        return value;
    }

    public DocumentTypeEnum getType() {
        return type;
    }

    private Document(Document.Builder builder) {
        this.value = builder.value;
        this.type = builder.type;
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private DocumentTypeEnum type;
        private String value;

        public Document.Builder value(String value) {
            this.value = value;
            return this;
        }

        public Document.Builder type(DocumentTypeEnum type) {
            this.type = type;
            return this;
        }

        public Document build() {
            return new Document(this);
        }
    }
}
