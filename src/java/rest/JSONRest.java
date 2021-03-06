/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author c0587637
 */
@Path("/json")
public class JSONRest {

    @GET
    @Produces("application/json")
    public JsonObject getJson() {
        JsonObjectBuilder json = Json.createObjectBuilder();
        json.add("name", "Bobby Tables");
        json.add("id", 12342);
        return json.build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public JsonObject postJson(JsonObject json) {
        System.out.println(json.getInt("id", 0));
        System.out.println(json.getString("name", ""));
        return json;
    }
}
