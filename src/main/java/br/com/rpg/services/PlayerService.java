package br.com.rpg.services;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.rpg.DAO.GameDAO;
import br.com.rpg.DAO.PlayerDAO;
import br.com.rpg.DAO.RecordDAO;
import br.com.rpg.DO.GameDO;
import br.com.rpg.DO.PlayerDO;
import br.com.rpg.services.beans.PlayerBean;

@Named
@Path("/player")
public class PlayerService {

    Logger logger = Logger.getLogger(PlayerService.class);

    @Inject
    private PlayerDAO playerDAO;

    @Inject
    private GameDAO gameDAO;
    
    @Inject RecordDAO recordDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PlayerBean playerBean) {
        logger.info("Criando novo personagem. " + playerBean);
        try {
            PlayerDO newPlayer = new PlayerDO();
            newPlayer.setUserId(playerBean.getUserId());
            newPlayer.setName(playerBean.getName());
            newPlayer.setAge(playerBean.getAge());
            Integer playerId = playerDAO.save(newPlayer);
            return Response.status(Response.Status.CREATED).entity(playerId).build();
        } catch (Exception e) {
            logger.error("Erro ao criar personagem. " + playerBean + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar personagem").build();
        }
    }

    @GET
    @Path("/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("playerId") Integer playerId) {
        try {
            logger.info("Recuperando personagem " + playerId);
            PlayerDO find = playerDAO.find(playerId);
            return Response.status(Response.Status.OK).entity(find).build();
        } catch (Exception e) {
            logger.error("Erro ao recuperar personagem " + playerId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar personagem")
                    .build();
        }
    }

    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByUser(@PathParam("userId") Integer userId) {
        try {
            logger.info("Recuperando personagens do usuário " + userId);
            ArrayList<PlayerDO> games = playerDAO.findAll(userId);
            GenericEntity<ArrayList<PlayerDO>> entity = new GenericEntity<ArrayList<PlayerDO>>(games) {
            };
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            logger.error("Erro ao recuperar personagens do usuário " + userId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar personagens")
                    .build();
        }
    }

    @DELETE
    @Path("/{playerId}")
    public Response delete(@PathParam("playerId") Integer playerId) {
        try {
            logger.info("Removendo personagem " + playerId);
            playerDAO.delete(playerId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error("Erro ao remover personagem " + playerId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao remover personagem").build();
        }
    }

    @PUT
    @Path("/insert/game")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertGame(@FormParam("playerId") Integer playerId, @FormParam("token") String token) {
        try {
            GameDO gameDO = gameDAO.getGameByToken(token);
            if (gameDO == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Token não encontrado").build();
            }
            playerDAO.insertGame(playerId, gameDO.getId());
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error("Erro ao inserir token " + token + " no personagem " + playerId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao inserir token").build();
        }
    }

}
