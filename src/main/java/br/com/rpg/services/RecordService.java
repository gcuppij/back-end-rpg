package br.com.rpg.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.rpg.DAO.PlayerDAO;
import br.com.rpg.DAO.RecordDAO;

@Named
@Path("/record")
public class RecordService {

    Logger logger = Logger.getLogger(RecordService.class);

    @Inject
    private PlayerDAO playerDAO;

    @Inject
    RecordDAO recordDAO;

    @PUT
    @Path("/change/money")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertGame(@FormParam("recordId") Integer recordId, @FormParam("money") Integer money) {
        try {
            logger.info("Alterando dinhereiro para " + money + " do ficha " + recordId);
            recordDAO.updateMoney(recordId, money);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error("Erro ao alterar dinheiro para " + money + " no ficha " + recordId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao alterar dinheiro").build();
        }
    }
}
