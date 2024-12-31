package br.com.rhribeiro25.infrastructure.files.enums;

public  enum MenuEnum {

    EXIT(0, "Exit"),
    SORT(1, "Sort"),
    SEARCH(2, "Search"),
    ADD_EMPLOYEE(3, "Add Employee"),
    GENERATE_RANDOM_EMPLOYEE(4, "Generate Random Employee"),
    PRINT_ALL_EMPLOYEES(5, "Print All Employees");

    private final int key;
    private final String description;

    MenuEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public static MenuEnum fromKey(int key) {
        for (MenuEnum type: MenuEnum.values()) {
            if (type.getKey() == key) {
                return type;
            }
        }
    throw new IllegalArgumentException("Invalid Key: " + key);
    }
}