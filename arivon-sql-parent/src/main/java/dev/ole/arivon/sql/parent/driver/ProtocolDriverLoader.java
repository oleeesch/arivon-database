package dev.ole.arivon.sql.parent.driver;

import dev.ole.arivon.layer.connection.ConnectionAuthentication;

public interface ProtocolDriverLoader<CRE extends ConnectionAuthentication> extends ProtocolDriver<CRE> {

    void initialize();

}