package dh.parser.config;

import java.util.regex.Pattern;

/**
 * Central configuration and constants for the DHCommentGenerator application.
 * Consolidates magic numbers, hardcoded strings, and regex patterns.
 */
public class Constants {

    // Application metadata
    public static final String APP_NAME = "DHParser";
    public static final String APP_VERSION = "1.0 beta";
    public static final String AUTHOR = "Pako";
    public static final String OUTPUT_FILENAME = "events.txt";

    // File patterns
    public static final String EVENT_FILE_EXTENSION = "txt";
    public static final String MODS_FILENAME = "mods.csv";
    public static final String SEPARATOR_CHAR = ";";  // CSV separator

    // Regex patterns (compiled once for performance)
    public static final Pattern ID_PATTERN = Pattern.compile("id\\s*=");
    public static final Pattern COUNTRY_PATTERN = Pattern.compile("country\\s*=|TAG\\s*=");
    public static final Pattern NAME_PATTERN = Pattern.compile("name\\s*=");
    public static final Pattern DESC_PATTERN = Pattern.compile("desc\\s*=");
    public static final Pattern DATE_PATTERN = Pattern.compile("date\\s*=");
    public static final Pattern DEATHDATE_PATTERN = Pattern.compile("deathdate\\s*=");
    public static final Pattern YEAR_PATTERN = Pattern.compile("year\\s*=");
    public static final Pattern MOD_PATTERN = Pattern.compile("([^;]+);([^;]+);");

    // Output formatting
    public static final String SEPARATOR_LINE = "# ----------------";
    public static final String HEADER_LINE = "###########################################################";
    public static final String COMMENT_PREFIX = "# ";

    // UI Messages
    public static final String HEADER_TEMPLATE = "Event comments generator";
    public static final String SELECT_GENERATOR_TYPE = "Select type of generator : ";
    public static final String SELECT_COMMENT_LEVEL = "Select type of comments : ";
    public static final String EVENTS_DIR_PROMPT = "Events dir path ---> ";
    public static final String MODS_DIR_PROMPT = "mods.csv dir path ---> ";
    public static final String FILE_NAME_PROMPT = "Insert file name : ";
    public static final String FILE_PROMPT = "File ---> ";

    // Cross-platform path handling
    public static final String PATH_SEPARATOR = java.io.File.separator;

    // Validation
    public static final int MIN_VALID_CHOICE = 1;
    public static final int MAX_GENERATOR_CHOICE = 2;
    public static final int MAX_COMMENT_CHOICE = 3;

    // Error messages
    public static final String ERROR_FILE_NOT_FOUND = "File not found";
    public static final String ERROR_FILE_READ = "File reading error";
    public static final String ERROR_GENERIC = "Generic exception";

    private Constants() {
        // Utility class, prevent instantiation
        throw new AssertionError("Cannot instantiate Constants class");
    }
}
