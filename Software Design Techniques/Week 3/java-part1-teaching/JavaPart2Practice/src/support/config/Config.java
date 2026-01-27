package support.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Simple properties loader so demos don't require CLI arguments.
 * Reads app.properties from the project root.
 */
public final class Config {
    private static final String CONFIG_FILE = "app.properties";
    private static Properties props;

    private Config() { }

    public static synchronized Properties load() {
        if (props != null) return props;

        props = new Properties();
        try (FileInputStream in = new FileInputStream(CONFIG_FILE)) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Could not load " + CONFIG_FILE + ". Using defaults. Details: " + e.getMessage());
        }
        return props;
    }

    public static String getString(String key, String defaultValue) {
        return load().getProperty(key, defaultValue);
    }

    public static int getInt(String key, int defaultValue) {
        String raw = load().getProperty(key);
        if (raw == null) return defaultValue;
        try { return Integer.parseInt(raw.trim()); }
        catch (NumberFormatException e) { return defaultValue; }
    }
}

