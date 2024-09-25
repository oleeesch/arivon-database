package dev.ole.arivon.process;

import dev.ole.arivon.layer.connection.Connection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public abstract class ProcessReference<C extends Connection<?, ?>> {

    private C connection;

}