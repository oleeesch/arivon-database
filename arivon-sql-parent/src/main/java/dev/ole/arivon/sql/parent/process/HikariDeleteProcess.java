package dev.ole.arivon.sql.parent.process;

import dev.ole.arivon.RepositoryExternalEntry;
import dev.ole.arivon.process.kind.UpdateProcess;
import dev.ole.arivon.sql.parent.HikariFilter;
import dev.ole.arivon.sql.parent.HikariFilterUtil;
import dev.ole.arivon.sql.parent.reference.HikariProcessReference;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;

public final class HikariDeleteProcess extends UpdateProcess<HikariProcessReference, HikariFilter<Object>> {

    private static final String DELETE_SQL = "DELETE FROM %s";

    @Override
    public void run(@NotNull RepositoryExternalEntry entry, @NotNull HikariProcessReference reference) {
        boolean success = reference.directly(HikariFilterUtil.appendFiltering(DELETE_SQL.formatted(entry.id()), filters()) + ";", filterArguments(), ResultSet::next);

        // todo return maybe back
    }
}