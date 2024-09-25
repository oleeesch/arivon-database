package dev.ole.arivon.process;

import dev.ole.arivon.layer.Layer;
import dev.ole.arivon.layer.connection.Connection;
import dev.ole.arivon.process.kind.QueryProcess;
import dev.ole.arivon.process.kind.UpdateProcess;
import dev.ole.arivon.query.Query;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public abstract class ProcessRunner<Q extends ProcessReference<? extends Connection<?, ?>>> {

    public void apply(Layer<?> layer, @NotNull Query<?> query, @NotNull UpdateProcess<?, ?> process) {
        var base = generateBase();
        this.prepareConstants(process, query, layer);
        process.runMapping(query.associatedRepository().entry(), base);
        this.update(base);
    }

    public <T> T apply(Layer<?> layer, @NotNull Query<?> query, @NotNull QueryProcess<T, ?, ?> process) {
        var base = generateBase();
        this.prepareConstants(process, query, layer);
        var object = process.runMapping(query.associatedRepository().entry(), base);
        this.query(base);
        return object;
    }

    private void prepareConstants(@NotNull Process<?> process, @NotNull Query<?> query, Layer<?> layer) {
        process.constants().cloneConstants(query.constants());
        if (query.filters().get(layer) != null) {
            process.appendFilters(query.filters().get(layer));
        }
    }

    public abstract Q generateBase();

    protected abstract void query(Q query);

    protected abstract void update(Q query);

}