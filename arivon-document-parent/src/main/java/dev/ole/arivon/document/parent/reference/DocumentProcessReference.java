package dev.ole.arivon.document.parent.reference;

import dev.ole.arivon.document.parent.connection.DocumentConnection;
import dev.ole.arivon.process.ProcessReference;

public final class DocumentProcessReference extends ProcessReference<DocumentConnection> {

    public DocumentProcessReference(DocumentConnection connection) {
        super(connection);
    }
}