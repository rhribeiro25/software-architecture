package br.com.rhribeiro25.shared.enums;

public enum DepartmentEnum {

    CUSTOMER_SERVICE(1, "Customer Service"),
    TECHNICAL_SUPPORT(2, "Technical Support"),
    HUMAN_RESOURCES(3, "Human Resources"),
    SALES(4, "Sales"),
    MARKETING(5, "Marketing"),
    DEVELOPMENT(6, "Development");

    private final int key;
    private final String description;

    DepartmentEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public String getDescription() {
        return  description;
    }

    public static DepartmentEnum fromKey(int key) {
        for (DepartmentEnum type: DepartmentEnum.values()) {
            if (type.getKey() == key) {
                return type;
            }
        }
        System.out.println("**************************************************************");
        System.out.println("Invalid Input! Please select one of the following options:");
        System.out.println("**************************************************************");
        System.out.println("1. Customer Service");
        System.out.println("Technical Support");
        System.out.println("Human Resources");
        System.out.println("Sales");
        System.out.println("Marketing");
        System.out.println("Development");
        System.out.println("**************************************************************");
        // return null;
        throw new IllegalArgumentException("Invalid Key: " + key);
    }
}