package dev.ole.arivon.document.redis;

import dev.ole.arivon.Repository;
import dev.ole.arivon.document.redis.connection.RedisConnection;
import dev.ole.arivon.document.redis.query.RedisDocumentQuery;
import dev.ole.arivon.layer.connection.ConnectableLayer;
import dev.ole.arivon.process.ProcessRunner;
import dev.ole.arivon.query.QueryMethod;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public final class RedisLayer extends ConnectableLayer<RedisConnection, RedisProcessReference> {

    private RedisConnection connection;

    public RedisLayer() {
        super(new RedisAuthentication("localhost", 6379, "", false), new RedisFilterHandler());
    }

    @Override
    public void prepped(Repository<?> repository) {

    }

    @Override
    protected ProcessRunner<RedisProcessReference> generateRunner() {
        return new RedisRunner(this.connection = new RedisConnection());
    }

    @Override
    public <T> QueryMethod<T> queryMethod(Repository<?> repository) {
        return new RedisDocumentQuery<>(this, runner());
    }
}