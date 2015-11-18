package br.com.rpg.services;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.rpg.DAO.GameDAO;
import br.com.rpg.DO.GameDO;
import br.com.rpg.services.beans.Gamebean;
import br.com.rpg.utils.GameUtils;

@Named
@Path("/game")
public class GameService {

    Logger logger = Logger.getLogger(UserService.class);

    @Inject
    private GameDAO gameDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Gamebean gameBean) {
        logger.info("Criando novo jogo. " + gameBean);
        try {
            GameDO newGame = new GameDO();
            newGame.setUserId(gameBean.getUserId());
            newGame.setName(gameBean.getName());
            newGame.setDescription(gameBean.getDescription());
            newGame.setToken(GameUtils.generateToken(gameBean.getUserId(), gameBean.getName()));
            Integer gameId = gameDAO.save(newGame);
            return Response.status(Response.Status.CREATED).entity(gameId).build();
        } catch (Exception e) {
            logger.error("Erro ao criar jogo. " + gameBean + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar jogo").build();
        }
    }

    @GET
    @Path("/{gameId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("gameId") Integer gameId) {
        try {
            logger.info("Recuperando jogo com ID " + gameId);
            GameDO find = gameDAO.find(gameId);
            return Response.status(Response.Status.OK).entity(find).build();
        } catch (Exception e) {
            logger.error("Erro ao recuperar jogo " + gameId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar jogo").build();
        }
    }

    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByUser(@PathParam("userId") Integer userId) {
        try {
            logger.info("Recuperando jogos do usuário " + userId);
            ArrayList<GameDO> games = gameDAO.findAll(userId);
            GenericEntity<ArrayList<GameDO>> entity = new GenericEntity<ArrayList<GameDO>>(games) {
            };
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            logger.error("Erro ao recuperar jogos do usuário " + userId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar jogos").build();
        }
    }

    @DELETE
    @Path("/{gameId}")
    public Response delete(@PathParam("gameId") Integer gameId) {
        try {
            logger.info("Removendo jogo " + gameId);
            gameDAO.delete(gameId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error("Erro ao remover jogo " + gameId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao remover jogo").build();
        }
    }
}
