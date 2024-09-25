package dev.ole.arivon.layer.connection;

import dev.ole.arivon.filtering.FilterHandler;
import dev.ole.arivon.layer.PreppedLayer;
import dev.ole.arivon.process.ProcessReference;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Getter
@Accessors(fluent = true)
public abstract class ConnectableLayer<C extends Connection<?, ?>, P extends ProcessReference<? extends Connection<?, ?>>> extends PreppedLayer<P> {

    private final ConnectionAuthentication templateAuthentication;

    public ConnectableLayer(@NotNull ConnectionAuthentication authentication, FilterHandler<?, ?> filterHandler) {
        super(authentication.id(), filterHandler);
        this.templateAuthentication = authentication;

        // register for every connection a clean and separate connection shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> connection().close()));
    }

    public abstract C connection();

}