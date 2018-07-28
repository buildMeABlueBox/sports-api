package com.homebase.sportsapi;

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
    @Produces(MediaType.APPLICATION_JSON) //this method will return the data back in XML format
    public List<Player> getPlayers(@Context UriInfo uriDetails){
        String baseURI = uriDetails.getBaseUri().getPath();
        String sportResource = baseURI.split("/")[2];
        
        PlayerRepository sportRepo = new PlayerRepository(sportResource);
        return sportRepo.getPlayerData();
    }

}