package br.com.rpg.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.rpg.DAO.UserDAO;
import br.com.rpg.DO.UserDO;

@Named
@Path("/user")
public class UserService {

    @Inject
	private UserDAO userDAO;

	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDO getAll(@PathParam("userId") Integer userId) {

		return userDAO.find(userId);

	}

}
