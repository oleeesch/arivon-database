package dev.ole.arivon.sql.parent.driver;

import dev.ole.arivon.layer.connection.ConnectionAuthentication;

public interface ProtocolDriver<A extends ConnectionAuthentication> {

    String jdbcUrl(A credentials);

    @SuppressWarnings("unchecked")
    default String jdbcUrlBinding(ConnectionAuthentication credentials) {
        return this.jdbcUrl((A) credentials);
    }

}