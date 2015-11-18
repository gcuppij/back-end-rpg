package br.com.rpg.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
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
import br.com.rpg.services.beans.UserBean;
import br.com.rpg.utils.UserUtils;

@Named
@Path("/user")
public class UserService {

    Logger logger = Logger.getLogger(UserService.class);

    @Inject
    private UserDAO userDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(UserBean userBean) {
        logger.info("Criando novo usuário. " + userBean);
        try {
            UserDO newUser = new UserDO();
            newUser.setName(userBean.getUserName());
            newUser.setPassword(UserUtils.generateMD5(userBean.getUserName() + userBean.getPassword()));
            newUser.setCountryId(userBean.getCountryId());
            Integer userId = userDAO.save(newUser);
            return Response.status(Response.Status.CREATED).entity(userId).build();
        } catch (Exception e) {
            logger.error("Erro ao criar usuário " + userBean.getUserName() + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar usuário").build();
        }
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("userId") Integer userId) {
        try {
            logger.info("Recuperando usuário " + userId);
            UserDO find = userDAO.find(userId);
            return Response.status(Response.Status.OK).entity(find).build();
        } catch (Exception e) {
            logger.error("Erro ao recuperar usuário " + userId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar usuário").build();
        }
    }

    @GET
    @Path("{userName}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response auth(@PathParam("userName") String userName, @PathParam("password") String password) {
        try {
            logger.info("Recuperando usuário " + userName + " para autenticação");
            UserDO find = userDAO.findUserAndPassword(userName, password);
            return Response.status(Response.Status.OK).entity(find).build();
        } catch (Exception e) {
            logger.error("Erro ao recuperar usuário " + userName + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar usuário").build();
        }
    }

}
