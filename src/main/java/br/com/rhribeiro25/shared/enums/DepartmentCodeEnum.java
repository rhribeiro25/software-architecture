package br.com.rhribeiro25.shared.enums;

public enum DepartmentCodeEnum {

    FIN_01(1, "Financial"),
    HR_01(2, "Human Resources"),
    IST_01(3, "Information Technology"),
    SAL_01(4, "Sales"),
    MKT_01(5, "Marketing");

    private final int key;
    private final String description;

    DepartmentCodeEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public long getKey() {
        return key;
    }

    public String getDescription() {
        return  description;
    }

    public static DepartmentCodeEnum fromKey(int key) {
        for (DepartmentCodeEnum type: DepartmentCodeEnum.values()) {
            if (type.getKey() == key) {
                return type;
            }
        }
        return null;
    }
}