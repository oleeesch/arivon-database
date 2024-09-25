package dev.ole.arivon.document.parent.process;

import dev.ole.arivon.RepositoryExternalEntry;
import dev.ole.arivon.document.parent.DocumentFilter;
import dev.ole.arivon.document.parent.reference.DocumentProcessReference;
import dev.ole.arivon.process.kind.UpdateProcess;

public final class DocumentCreateProcess extends UpdateProcess<DocumentProcessReference, DocumentFilter<Object>> {

    @Override
    public void run(RepositoryExternalEntry entry, DocumentProcessReference reference) {
        //todo generate jsonObject
    }
}