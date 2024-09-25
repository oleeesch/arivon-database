package dev.ole.arivon.process.kind;

import dev.ole.arivon.RepositoryExternalEntry;
import dev.ole.arivon.filtering.Filter;
import dev.ole.arivon.layer.connection.Connection;
import dev.ole.arivon.process.Process;
import dev.ole.arivon.process.ProcessReference;

public abstract class UpdateProcess<R extends ProcessReference<? extends Connection<?, ?>>, F extends Filter<?, ?>> extends Process<F> {

    public abstract void run(RepositoryExternalEntry entry, R reference);

    @SuppressWarnings("unchecked")
    public void runMapping(RepositoryExternalEntry entry, ProcessReference<?> reference) {
        run(entry, (R) reference);
    }
}