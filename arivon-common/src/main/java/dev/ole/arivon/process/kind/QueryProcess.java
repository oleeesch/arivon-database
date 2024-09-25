package dev.ole.arivon.process.kind;

import dev.ole.arivon.RepositoryExternalEntry;
import dev.ole.arivon.filtering.Filter;
import dev.ole.arivon.layer.connection.Connection;
import dev.ole.arivon.process.Process;
import dev.ole.arivon.process.ProcessReference;

public abstract class QueryProcess<T, R extends ProcessReference<? extends Connection<?, ?>>, F extends Filter<?, ?>> extends Process<F> {

    public abstract T run(RepositoryExternalEntry entry, R reference);

    @SuppressWarnings("unchecked")
    public T runMapping(RepositoryExternalEntry entry, ProcessReference<?> reference) {
        return this.run(entry, (R) reference);
    }
}