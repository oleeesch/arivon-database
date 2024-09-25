package dev.ole.arivon.layer;

import dev.ole.arivon.Repository;
import dev.ole.arivon.filtering.FilterHandler;
import dev.ole.arivon.layer.connection.Connection;
import dev.ole.arivon.process.ProcessReference;

public abstract class PreppedLayer<Q extends ProcessReference<? extends Connection<?, ?>>> extends Layer<Q> {

    public PreppedLayer(String id, FilterHandler<?, ?> filterHandler) {
        super(id, filterHandler);
    }

    public abstract void prepped(Repository<?> repository);

}