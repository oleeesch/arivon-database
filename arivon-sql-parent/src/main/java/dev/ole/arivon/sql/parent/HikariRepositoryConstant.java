package dev.ole.arivon.sql.parent;

import dev.ole.arivon.RepositoryConstant;
import dev.ole.arivon.sql.parent.types.Type;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class HikariRepositoryConstant {

    public static final RepositoryConstant<Type> SQL_TYPE = new RepositoryConstant<>("SQL_TYPE");

}