package com.bandlanguage.bandlanguagesite.constant;

public enum EnvironmentType {

    ORGANIZATION_ENVIRONMENT(1, "机构语境"),

    BAND_ENVIRONMENT(2, "帮区语境"),

    SCRIPT_ENVIRONMENT(3, "剧本语境");

    private final Integer value;

    private final String environmentTypeName;

    EnvironmentType(Integer value, String environmentTypeName) {
        this.value = value;
        this.environmentTypeName = environmentTypeName;
    }

    public Integer value() {
        return value;
    }

    public static EnvironmentType valueOf(Integer value) {
        for (EnvironmentType item :
                EnvironmentType.values()) {
            if (item.value() == value) {
                return item;
            }
        }
        return null;
    }

    public static EnvironmentType nameOf(String environmentTypeName) {
        for (EnvironmentType item :
                EnvironmentType.values()) {
            if (item.name().equals(environmentTypeName)) {
                return item;
            }
        }
        throw new IllegalArgumentException(String.format("[%s]中根据常量名字[%s]找不到对应的枚举常量",
                EnvironmentType.class.getName(), environmentTypeName));
    }
}
