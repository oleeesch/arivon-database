package dev.ole.arivon.sql.parent;

import dev.ole.arivon.Repository;
import dev.ole.arivon.layer.connection.ConnectableLayer;
import dev.ole.arivon.layer.connection.ConnectionAuthentication;
import dev.ole.arivon.process.ProcessRunner;
import dev.ole.arivon.query.Query;
import dev.ole.arivon.query.QueryMethod;
import dev.ole.arivon.sql.parent.connection.HikariConnection;
import dev.ole.arivon.sql.parent.driver.ProtocolDriver;
import dev.ole.arivon.sql.parent.process.HikariPreppedProcess;
import dev.ole.arivon.sql.parent.query.HikariLayerQuery;
import dev.ole.arivon.sql.parent.reference.HikariProcessReference;
import dev.ole.arivon.sql.parent.types.TypeDefaultDetector;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Getter
@Accessors(fluent = true)
public abstract class HikariParentConnectionLayer<A extends ConnectionAuthentication> extends ConnectableLayer<HikariConnection, HikariProcessReference> {

    private HikariConnection connection;
    private final TypeDefaultDetector detector = new TypeDefaultDetector();

    public HikariParentConnectionLayer(A templateCredentials) {
        super(templateCredentials, new HikariFilterHandler());
    }

    public ProtocolDriver<A> protocol() {
        return credentials -> {
            if (credentials instanceof HikariDefaultAuthentication auth) {
                return "jdbc:" + auth.id().toLowerCase() + "://" + auth.hostname() + ":" + auth.port() + "/" + auth.database();
            }
            return credentials.id();
        };
    }

    /**
     * Calculate and create the base of the specific repository
     *
     * @param repository which is preparing for access
     */
    @Override
    public void prepped(@NotNull Repository<?> repository) {
        runner().apply(this,  new Query(repository, Set.of()), new HikariPreppedProcess(this));
    }

    @Override
    public ProcessRunner<HikariProcessReference> generateRunner() {
        return new HikariConnectionRunner(this.connection = new HikariConnection(protocol()));
    }

    @Override
    public <T> QueryMethod<T> queryMethod(Repository<?> repository) {
        return new HikariLayerQuery<>(this, repository, runner());
    }
}