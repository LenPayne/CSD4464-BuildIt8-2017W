/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author c0587637
 */
@Path("/todo")
@ApplicationScoped
public class TodoRest {

    List<String> todoList = new ArrayList<>();

    @GET
    @Produces("application/json")
    public JsonArray get() {
        JsonArrayBuilder arr = Json.createArrayBuilder();
        for (String todo : todoList) {
            arr.add(todo);
        }
        return arr.build();
    }
    
    @POST
    @Consumes("application/json")
    public void post(JsonObject json) {
        todoList.add(json.getString("todo", ""));
    }
}
