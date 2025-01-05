package br.com.rhribeiro25.shared.enums;

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
        throw new IllegalArgumentException("Invalid Key: " + key);
    }
}