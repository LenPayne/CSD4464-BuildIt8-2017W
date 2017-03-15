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
        JsonArrayBuilder arr = Json.createArrayBuilder();
        for (int i = 0; i < 100; i++) {
            JsonObjectBuilder subjson = Json.createObjectBuilder();
            for (int j = 0; j < 10; j++) {
                subjson.add("object" + i + "-" + j, i*j);
            }
            arr.add(subjson);
        }
        json.add("array", arr);
        return json.build();
    }

    @POST
    @Consumes("application/json")
    public void postJson(JsonObject json) {
        // Outputs the value of a JSON property "Hello"
        System.out.println(json.getString("Hello"));
    }
}
