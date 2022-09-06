package com.akh.restServer.resource;

import com.akh.restServer.model.Game;
import com.akh.restServer.request.CreateGameRequest;
import com.akh.restServer.request.GamesRequest;
import com.akh.restServer.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Component
@Path("/api/v1/")
public class GameResource {

    @Autowired
    private GameService gameService;

    @GET
    @Path("/games")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGames(@QueryParam("team1") String team1, @QueryParam("team2") String team2){

        List<Game> games;

        if (!StringUtils.hasLength(team1) && !StringUtils.hasLength(team2))
            games = gameService.getGamesBetweenTeams(team1, team2);
        else if (!StringUtils.hasLength(team1) || !StringUtils.hasLength(team2)) {
            String team = !StringUtils.hasLength(team1) ? team2 : team1;
            games = gameService.getGamesOfATeam(team);
        } else
            games = gameService.getAllGames();

        return Response.status(Response.Status.OK).entity(games).build();
    }

    @POST
    @Path("/getgames")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getGames(@RequestBody(required = true) GamesRequest gamesRequest){
        String team1 = gamesRequest.getTeam1();
        String team2 = gamesRequest.getTeam2();
        List<Game> games;

        if (!StringUtils.hasLength(team1) && !StringUtils.hasLength(team2))
            games = gameService.getGamesBetweenTeams(team1, team2);
        else if (!StringUtils.hasLength(team1) || !StringUtils.hasLength(team2)) {
            String team = !StringUtils.hasLength(team1) ? team2 : team1;
            games = gameService.getGamesOfATeam(team);
        } else
            games = gameService.getAllGames();
        return Response.status(Response.Status.OK).entity(games).build();
    }

    @Path("/games")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGame(CreateGameRequest createGameRequest, @Context UriInfo uriInfo){
        System.out.println("Input game :: "+createGameRequest.getTeam1()+" - "+createGameRequest.getTeam2());
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(6575725));
        return Response.created(uriBuilder.build()).build();
    }

}
