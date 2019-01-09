package io.helidon.examples.quickstart.mp;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Path("/students")
@RequestScoped
public class StudentDetails {

    private Connection connection;
    private final DBProvider dbProvider;

    @Inject
    public StudentDetails(DBProvider dbProvider) {
        this.dbProvider = dbProvider;
    }

    public void initialize () throws Exception {
        
            String url = String.format("jdbc:mysql://%s:%s/school", this.dbProvider.getServer(), this.dbProvider.getPort());
            String username = this.dbProvider.getUser();
            String password = this.dbProvider.getPassword();
            connection = DriverManager.getConnection(url, username, password);
        
    }

    @SuppressWarnings("checkstyle:designforextension")
    @Path("/mysqlstatus")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public boolean getMysqlStatus(@PathParam("mysqlstatus") String id) {
        boolean isUp = false;
        //JsonObjectBuilder mysqlObject = Json.createObjectBuilder();
        try {
            initialize();
            isUp = true;
            //mysqlObject.addNull("Mysql Connects");
        } catch (Exception e) {
            System.out.println("MYSQL SERVER IS DOWN" + e.toString());
        }
        return isUp;
    }
}