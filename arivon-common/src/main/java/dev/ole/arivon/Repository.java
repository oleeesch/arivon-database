package dev.ole.arivon;

import dev.ole.arivon.external.RepositoryObjectEntry;
import dev.ole.arivon.layer.Layer;
import dev.ole.arivon.query.Query;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public record Repository<T>(RepositoryObjectEntry entry, Set<Layer<?>> layers) {

    @Contract(value = "_ -> new", pure = true)
    public static <R> @NotNull RepositoryBuilder<R> build(Class<R> clazz) {
        return new RepositoryBuilder<>(clazz);
    }

    @Contract(" -> new")
    public @NotNull Query<T> query() {
        return new Query<>(this, layers);
    }

    public @NotNull Query<T> query(Class<? extends Layer<?>> layer) {
        return new Query<>(this, Set.of(layers.stream().filter(it -> it.getClass().equals(layer)).findFirst().orElseThrow()));
    }

    @Override
    public @NotNull String toString() {
        return entry.clazz().getSimpleName();
    }
}
