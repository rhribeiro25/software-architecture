package br.com.rhribeiro25.domain.enums;

public enum RoleEnum {

    MAIN_MANAGER(1, "Main Manager"),
    ASSISTANT_MANAGER(2, "Assistant Manager"),
    TEAM_LEADER(3, "Team Leader");

    private final int key;
    private final String description;

    RoleEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public static RoleEnum fromKey(int key) {
        for (RoleEnum type: RoleEnum.values()) {
            if (type.getKey() == key) {
                return type;
            }
        }
        System.out.println("**************************************************************");
        System.out.println("Invalid Input! Please select one of the following options: \n" +
                "************************************************************** \n" +
                "1. Main Manager \n" +
                "2. Assistant Manager \n" +
                "3. Team Leader");
        //return  null;
        throw new IllegalArgumentException("Invalid Key: " + key);
    }
}