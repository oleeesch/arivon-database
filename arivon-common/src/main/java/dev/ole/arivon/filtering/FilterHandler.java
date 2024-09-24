package dev.ole.arivon.filtering;

public interface FilterHandler<T, R> {

    /**
     * Creates a filter to include values that match the specified value.
     *
     * @param id    The identifier for the filter
     * @param value The value to match.
     * @return A filter object.
     */
    Filter<T, R> match(String id, Object value);

    /**
     * Creates a filter to exclude values that match any of the specified value.
     *
     * @param id    The identifier for the filter
     * @param value The value to exclude.
     * @return A filter object.
     */
    Filter<T, R> noneMatch(String id, Object value);

}
