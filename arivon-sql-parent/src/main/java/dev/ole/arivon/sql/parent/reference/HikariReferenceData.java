package dev.ole.arivon.sql.parent.reference;

import dev.ole.arivon.sql.parent.connection.HikariConnectionFunction;

public record HikariReferenceData<R>(String query, Object[] values, HikariConnectionFunction<R> consumer) {

}