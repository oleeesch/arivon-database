package dev.ole.arivon.document.redis;

import dev.ole.arivon.filtering.Filter;

public abstract class RedisFilter<R> extends Filter<String, R> {

    public RedisFilter(String id, R value) {
        super(id, value);
    }
}