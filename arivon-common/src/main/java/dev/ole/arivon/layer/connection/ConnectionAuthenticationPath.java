package dev.ole.arivon.layer.connection;

import lombok.experimental.UtilityClass;

import java.nio.file.Path;

@UtilityClass
public final class ConnectionAuthenticationPath {

    public static Path CONFIGURATION_PATH = Path.of("arivon-connection-credentials.json");
    private static final String ENV_ID = "arivon.credentials.path";

    static {
        if (System.getenv().containsKey(ENV_ID)) {
            set(System.getenv(ENV_ID));
        }
    }

    public static void set(String id) {
        CONFIGURATION_PATH = Path.of(id);
    }

}