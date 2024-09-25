package dev.ole.arivon.document.redis;

import dev.ole.arivon.document.redis.connection.RedisConnection;
import dev.ole.arivon.process.ProcessReference;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public final class RedisProcessReference extends ProcessReference<RedisConnection> {

    public RedisProcessReference(RedisConnection connection) {
        super(connection);
    }
}