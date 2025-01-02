package br.com.rhribeiro25.infrastructure.file.enums; // Same package as your other classes

// Enum to represent the different search types
public enum SearchEnum {

    NAME(1, "Search by Name"),
    DEPARTMENT(2, "Search by DepartmentFileEntity"),
    ROLE(3, "Search by Role");

    private final int key;
    private final String description;

    // Constructor for SearchType enum
    SearchEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    // Static method to get the SearchType from the key (similar to your fromKey method in MenuEnum)
    public static SearchEnum fromKey(int key) {
        for (SearchEnum type : SearchEnum.values()) {
            if (type.getKey() == key) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid Key: " + key);
    }

}