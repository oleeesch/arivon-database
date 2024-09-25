package dev.ole.arivon.sql.parent.process;

import dev.ole.arivon.RepositoryExternalEntry;
import dev.ole.arivon.process.kind.QueryProcess;
import dev.ole.arivon.sql.parent.HikariFilter;
import dev.ole.arivon.sql.parent.HikariFilterUtil;
import dev.ole.arivon.sql.parent.reference.HikariProcessReference;
import org.jetbrains.annotations.NotNull;

public final class HikariCountProcess extends QueryProcess<Long, HikariProcessReference, HikariFilter<Object>> {

    private static final String COUNT_QUERY = "SELECT COUNT(*) AS ELEMENTS FROM %s";

    @Override
    public @NotNull Long run(@NotNull RepositoryExternalEntry entry, @NotNull HikariProcessReference reference) {
        return reference.directly(HikariFilterUtil.appendFiltering(COUNT_QUERY.formatted(entry.id()), filters()) + ";", filterArguments(), it -> {
            if(it.next()) {
                return it.getLong("ELEMENTS");
            }
            return -1L;
        });
    }
}