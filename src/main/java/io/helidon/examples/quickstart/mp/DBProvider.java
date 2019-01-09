package io.helidon.examples.quickstart.mp;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class DBProvider {

    private final AtomicReference<String> server = new AtomicReference<>();
    private final AtomicReference<String> port = new AtomicReference<>();
    private final AtomicReference<String> user = new AtomicReference<>();
    private final AtomicReference<String> password = new AtomicReference<>();

    @Inject
    public DBProvider(@ConfigProperty(name = "app.mysql.server") String server,
                      @ConfigProperty(name = "app.mysql.port") String port,
                      @ConfigProperty(name = "app.mysql.user") String user,
                      @ConfigProperty(name = "app.mysql.password") String password) {
        this.server.set(server);
        this.port.set(port);
        this.user.set(user);
        this.password.set(password);
    }

    String getServer() {
        return server.get();
    }

    String getPort() {
        return port.get();
    }

    String getUser() {
        return user.get();
    }

    String getPassword() {
        return password.get();
    }
}