package dev.ole.arivon.sql.parent;

import dev.ole.arivon.filtering.Filter;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@UtilityClass
public class HikariFilterUtil {

    public static String appendFiltering(String query, @NotNull List<HikariFilter<Object>> filters) {
        var transformedFilters = filters.stream().map(Filter::filter).toList();

        if (!transformedFilters.isEmpty()) {
            query = query + " WHERE " + String.join(" AND ", transformedFilters);
        }

        return query;
    }
}