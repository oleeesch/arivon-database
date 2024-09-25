package dev.ole.arivon.document.parent;

import dev.ole.arivon.Repository;
import dev.ole.arivon.document.parent.reference.DocumentProcessReference;
import dev.ole.arivon.filtering.FilterHandler;
import dev.ole.arivon.layer.Layer;
import dev.ole.arivon.process.ProcessRunner;
import dev.ole.arivon.query.QueryMethod;

public abstract class DocumentParentLayer extends Layer<DocumentProcessReference> {

    public DocumentParentLayer(String id, FilterHandler<?, ?> filterHandler) {
        //todo
        super(id, filterHandler);
    }

    @Override
    protected ProcessRunner<DocumentProcessReference> generateRunner() {
        //todo
        return null;
    }

    @Override
    public <T> QueryMethod<T> queryMethod(Repository<?> repository) {
        //todo
        return null;
    }
}