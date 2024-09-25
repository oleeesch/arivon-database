package dev.ole.arivon.sql.parent.types;

import dev.ole.arivon.RepositoryEntry;

public interface TypeDetector {

    /**
     * layers with special types can overwrite current implementation.
     * Set the new layer in front of the search algorithm
     *
     * @param type the new one
     */
    void overwrite(Type type);

    /**
     * some layers are not allowed to use some types
     * With this method you remove the unsupported search
     * @param typeId the id of type
     */
    void removeType(String typeId);

    /**
     * Search and return the sql type of entry
     *
     * @param entry the current searched entry
     * @return the sql type
     */
    Type detect(RepositoryEntry entry);

}