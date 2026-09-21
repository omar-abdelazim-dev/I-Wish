package iti.iwish.shared;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Reads the shared server endpoint from server.properties. */
public final class NetworkConfig {
    private static final Properties SETTINGS = load();

    private NetworkConfig() { }

    public static String host() {
        return SETTINGS.getProperty("server.host", "127.0.0.1").trim();
    }

    public static int port() {
        String value = SETTINGS.getProperty("server.port", "5217").trim();
        try {
            int port = Integer.parseInt(value);
            if (port < 1 || port > 65535) throw new NumberFormatException();
            return port;
        } catch (NumberFormatException exception) {
            throw new IllegalStateException("server.port must be a number between 1 and 65535.");
        }
    }

    private static Properties load() {
        Properties properties = new Properties();
        try (InputStream input = NetworkConfig.class.getResourceAsStream("/server.properties")) {
            if (input == null) throw new IllegalStateException("server.properties is missing.");
            properties.load(input);
            return properties;
        } catch (IOException exception) {
            throw new IllegalStateException("Could not load server.properties.", exception);
        }
    }
}
