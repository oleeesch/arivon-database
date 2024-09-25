package dev.ole.arivon.document.redis.query;

import dev.ole.arivon.Ordering;
import dev.ole.arivon.document.redis.RedisProcessReference;
import dev.ole.arivon.document.redis.process.RedisCountProcess;
import dev.ole.arivon.document.redis.process.RedisCreateProcess;
import dev.ole.arivon.document.redis.process.RedisDeleteProcess;
import dev.ole.arivon.document.redis.process.RedisSearchProcess;
import dev.ole.arivon.layer.Layer;
import dev.ole.arivon.process.ProcessRunner;
import dev.ole.arivon.query.Query;
import dev.ole.arivon.query.QueryMethod;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class RedisDocumentQuery<V> implements QueryMethod<V> {

    private final Layer<?> layer;
    private ProcessRunner<RedisProcessReference> runner;

    @Override
    public void create(Query<?> query, V value) {
        runner.apply(layer, query, new RedisCreateProcess(value));
    }

    @Override
    public void update(Query<?> query, V value) {

    }

    @Override
    public void delete(Query<?> query) {
        runner.apply(layer, query, new RedisDeleteProcess());
    }

    @Override
    public boolean exists(Query<?> query) {
        return findFirst(query) != null;
    }

    @Override
    public V findFirst(Query<?> query) {
        query.limit(1);
        var values = runner.apply(layer, query, new RedisSearchProcess());
        if (!values.isEmpty()) {
            return (V) values.get(0);
        }
        return null;
    }

    @Override
    public long count(Query<?> query) {
        return runner.apply(layer, query, new RedisCountProcess());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<V> find(Query<?> query) {
        return (List<V>) runner.apply(layer, query, new RedisSearchProcess());
    }

    @Override
    public long sum(Query<?> query, String id) {
        return 0;
    }

    @Override
    public double average(Query<?> query, String id) {
        return 0;
    }

    @Override
    public V min(String id) {
        return null;
    }

    @Override
    public V max(String id) {
        return null;
    }

    @Override
    public List<V> order(Query<?> query, String id, Ordering ordering) {
        return List.of();
    }
}