package br.com.rpg.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.rpg.DAO.UserDAO;
import br.com.rpg.DO.UserDO;

@Named
@Path("/user")
public class UserService {

    Logger logger = Logger.getLogger(UserService.class);

    @Inject
    private UserDAO userDAO;

    @POST
    public Response post(@FormParam("username") String userName, @FormParam("password") String password,
            @FormParam("countryid") Integer countryId) {
        logger.info("Salvando novo usuário " + userName + " do país " + countryId);
        try {
            UserDO newUser = new UserDO();
            newUser.setName(userName);
            newUser.setPassword(password);
            newUser.setCountryId(countryId);
            Integer userId = userDAO.save(newUser);
            return Response.status(Response.Status.CREATED).entity(userId).build();
        } catch (Exception e) {
            logger.error("Erro ao salvar usuário " + userName + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar usuário").build();
        }
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("userId") Integer userId) {
        try {
            logger.info("Recuperando usuário com ID " + userId);
            UserDO find = userDAO.find(userId);
            return Response.status(Response.Status.OK).entity(find).build();
        } catch (Exception e) {
            logger.error("Erro ao recuperar usuário " + userId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar usuário").build();
        }
    }

}
