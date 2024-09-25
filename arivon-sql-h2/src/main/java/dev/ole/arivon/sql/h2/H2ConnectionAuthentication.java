package dev.ole.arivon.sql.h2;

import dev.ole.arivon.layer.connection.ConnectionAuthentication;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public final class H2ConnectionAuthentication extends ConnectionAuthentication {

    private final String path;

    public H2ConnectionAuthentication() {
        super("H2", false);

        this.path = "database.h2";
    }
}