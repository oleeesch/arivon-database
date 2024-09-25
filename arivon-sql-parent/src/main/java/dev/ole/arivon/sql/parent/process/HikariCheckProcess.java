package dev.ole.arivon.sql.parent.process;

import dev.ole.arivon.RepositoryExternalEntry;
import dev.ole.arivon.process.kind.QueryProcess;
import dev.ole.arivon.sql.parent.HikariFilter;
import dev.ole.arivon.sql.parent.HikariFilterUtil;
import dev.ole.arivon.sql.parent.reference.HikariProcessReference;
import org.jetbrains.annotations.NotNull;

public final class HikariCheckProcess extends QueryProcess<Boolean, HikariProcessReference, HikariFilter<Object>> {

    private static final String CHECK_QUERY = "SELECT * FROM %s";

    @Override
    public @NotNull Boolean run(@NotNull RepositoryExternalEntry entry, @NotNull HikariProcessReference reference) {
        return reference.directly(HikariFilterUtil.appendFiltering(CHECK_QUERY.formatted(entry.id()), filters()) + " LIMIT 1;", filterArguments(), it -> it.next());
    }
}