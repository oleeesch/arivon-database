package dev.ole.arivon.sql.parent.process;

import dev.ole.arivon.RepositoryExternalEntry;
import dev.ole.arivon.process.kind.QueryProcess;
import dev.ole.arivon.sql.parent.HikariFilter;
import dev.ole.arivon.sql.parent.HikariFilterUtil;
import dev.ole.arivon.sql.parent.reference.HikariProcessReference;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public final class HikariMathProcess<T> extends QueryProcess<Object, HikariProcessReference, HikariFilter<Object>> {

    private static final String MATH_QUERY = "SELECT %s AS data FROM %s";
    private String type;
    private T defaultValue;

    @Override
    public @NotNull Object run(@NotNull RepositoryExternalEntry entry, @NotNull HikariProcessReference reference) {
        return reference.directly(HikariFilterUtil.appendFiltering(MATH_QUERY.formatted(type, entry.id()), filters()) + ";", filterArguments(), result -> result.getObject("data") != null ? result.getObject("data") : defaultValue);
    }
}