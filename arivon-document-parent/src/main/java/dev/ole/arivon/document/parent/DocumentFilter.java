package dev.ole.arivon.document.parent;

import dev.ole.arivon.filtering.Filter;

public abstract class DocumentFilter<R> extends Filter<R, DocumentFilter<R>> {

    public DocumentFilter(String id, DocumentFilter<R> value) {
        super(id, value);
    }
}