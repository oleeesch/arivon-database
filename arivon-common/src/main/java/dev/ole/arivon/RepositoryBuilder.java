package dev.ole.arivon;

import dev.ole.arivon.external.RepositoryObjectEntry;
import dev.ole.arivon.layer.Layer;
import dev.ole.arivon.layer.LayerService;
import dev.ole.arivon.layer.PreppedLayer;
import dev.ole.arivon.layer.connection.ConnectableLayer;
import dev.ole.arivon.layer.connection.ConnectionAuthenticationService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

public final class RepositoryBuilder<T> {

    private final Class<T> clazz;
    private final Set<Layer<?>> layers = new LinkedHashSet<>();

    private String id;

    @Contract(pure = true)
    RepositoryBuilder(@NotNull Class<T> clazz) {
        this.clazz = clazz;
        this.id = clazz.getSimpleName();
    }

    public RepositoryBuilder<T> withId(String id) {
        this.id = id;
        return this;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public RepositoryBuilder<T> withLayer(Class<? extends Layer> layerClass) {
        var layer = LayerService.layerOf((Class<? extends Layer<?>>) layerClass);
        this.layers.add(layer);

        if (layer instanceof ConnectableLayer<?, ?> connectableLayer) {
            ConnectionAuthenticationService.appendCredentials(connectableLayer, connectableLayer.templateAuthentication());
        }

        return this;
    }

    @Contract(" -> new")
    public @NotNull Repository<T> build() {
        if (!(RepositoryEntryFinder.find(clazz, null, id, null) instanceof RepositoryObjectEntry entry)) {
            throw new UnsupportedOperationException("Repository type not allowed!");
        }
        var repository = new Repository<T>(entry, this.layers);
        // check all layers are ready to be used
        for (var layer : this.layers) {
            // some layers need to be prepped before the object is returned
            if (layer instanceof PreppedLayer<?> preppedLayer) {
                preppedLayer.prepped(repository);
            }
        }
        return repository;
    }
}