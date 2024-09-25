package dev.ole.arivon.document.redis;

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