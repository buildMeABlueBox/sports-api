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
 * @Path: player - mapping from sports servlet
 */
@Path("players")
public class PlayerResource {

    @GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public List<Player> getPlayers(@Context UriInfo uriDetails){
        String baseURI = uriDetails.getBaseUri().getPath();
        String sportResource = baseURI.split("/")[2];
        
        PlayerRepository sportRepo = new PlayerRepository(sportResource);
        return sportRepo.getPlayerData();
    }

}