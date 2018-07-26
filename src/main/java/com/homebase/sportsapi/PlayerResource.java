package com.homebase.sportsapi;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
/**
 * PlayerResource
 * @Path: player - this means whenever I have the path player, I am calling this resource
 */
@Path("players")
public class PlayerResource {

    @GET //Whenever a get request is called on player path, it will call this method
    @Produces(MediaType.APPLICATION_XML) //this method will return the data back in XML format
    public List<Player> getPlayers(@Context UriInfo uriDetails){
        String basePath = uriDetails.getBaseUri().getPath();
        String resource = basePath.split("/")[2];
        Player p1 = new Player("Carl", "Reed", "Quarterback", 23);
        Player p2 = new Player("Richard", "Jackson", "Center Tackle", 23);
        List<Player> playerList = Arrays.asList(p1,p2);
        return playerList;
    }

}