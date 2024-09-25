package dev.ole.arivon.sql.postgresql;

import dev.ole.arivon.sql.parent.HikariDefaultAuthentication;
import dev.ole.arivon.sql.parent.HikariParentConnectionLayer;
import lombok.SneakyThrows;

public final class PostgreSqlLayer extends HikariParentConnectionLayer<HikariDefaultAuthentication> {

    @SneakyThrows
    public PostgreSqlLayer() {
        super(new HikariDefaultAuthentication("POSTGRESQL", false));

        Class.forName("org.postgresql.Driver");
    }
}