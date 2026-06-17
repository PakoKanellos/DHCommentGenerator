package dh.parser.enums;

/**
 * Enum representing different levels of comment detail
 * that can be generated for Darkest Hour events.
 */
public enum CommentType {
    MINIMAL(1, "Minimal : id/country/name"),
    MEDIUM(2, "Medium : id/country/name/date"),
    COMPLETE(3, "Full : id/country/name/desc/date");

    private final int value;
    private final String description;

    CommentType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Converts an integer choice to CommentType
     * @param choice the integer choice (1, 2, or 3)
     * @return the corresponding CommentType
     * @throws IllegalArgumentException if choice is invalid
     */
    public static CommentType fromValue(int choice) {
        for (CommentType type : CommentType.values()) {
            if (type.value == choice) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid comment type: " + choice);
    }
}
