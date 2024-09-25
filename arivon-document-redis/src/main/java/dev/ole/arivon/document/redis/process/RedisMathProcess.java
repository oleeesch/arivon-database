package dev.ole.arivon.document.redis.process;

import dev.ole.arivon.RepositoryExternalEntry;
import dev.ole.arivon.document.redis.RedisFilter;
import dev.ole.arivon.document.redis.RedisProcessReference;
import dev.ole.arivon.process.kind.QueryProcess;

import java.util.List;

public final class RedisMathProcess extends QueryProcess<Object, RedisProcessReference, RedisFilter<Object>> {
    @Override
    public Object run(RepositoryExternalEntry entry, RedisProcessReference reference) {




        return List.of();
    }
}