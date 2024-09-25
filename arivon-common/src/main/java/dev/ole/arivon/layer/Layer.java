package dev.ole.arivon.layer;

import dev.ole.arivon.Repository;
import dev.ole.arivon.filtering.FilterHandler;
import dev.ole.arivon.layer.connection.Connection;
import dev.ole.arivon.process.ProcessReference;
import dev.ole.arivon.process.ProcessRunner;
import dev.ole.arivon.query.QueryMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public abstract class Layer<Q extends ProcessReference<? extends Connection<?, ?>>> {

    // general auth binding id
    private final String id;

    // executor for every process
    private final ProcessRunner<Q> runner = generateRunner();

    private final FilterHandler<?, ?> filterHandler;

    protected abstract ProcessRunner<Q> generateRunner();

    public abstract <T> QueryMethod<T> queryMethod(Repository<?> repository);

}