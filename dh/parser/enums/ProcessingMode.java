package dh.parser.enums;

/**
 * Enum representing the processing mode for comment generation.
 */
public enum ProcessingMode {
    MASSIVE(1, "Massive - Process all files in a directory"),
    SINGLE(2, "Single File - Process a single file");

    private final int value;
    private final String description;

    ProcessingMode(int value, String description) {
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
     * Converts an integer choice to ProcessingMode
     * @param choice the integer choice (1 or 2)
     * @return the corresponding ProcessingMode
     * @throws IllegalArgumentException if choice is invalid
     */
    public static ProcessingMode fromValue(int choice) {
        for (ProcessingMode mode : ProcessingMode.values()) {
            if (mode.value == choice) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Invalid processing mode: " + choice);
    }
}
