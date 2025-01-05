package br.com.rhribeiro25.shared.enums;

public enum DocumentTypeEnum {

    CPF(1, "Individual registration"),
    RG(2, "General Register"),
    PASSPORT(3, "Passport");

    private final int key;
    private final String description;

    DocumentTypeEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public static br.com.rhribeiro25.shared.enums.RoleEnum fromKey(int key) {
        for (br.com.rhribeiro25.shared.enums.RoleEnum type: br.com.rhribeiro25.shared.enums.RoleEnum.values()) {
            if (type.getKey() == key) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid Key: " + key);
    }
}
