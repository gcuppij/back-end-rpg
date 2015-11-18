package br.com.rpg.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.rpg.DAO.ItemDAO;
import br.com.rpg.DAO.RecordDAO;
import br.com.rpg.DO.ItemDO;
import br.com.rpg.DO.RecordDO;
import br.com.rpg.services.beans.ItemBean;

public class ItemService {
    
    Logger logger = Logger.getLogger(ItemService.class);

    @Inject
    RecordDAO recordDAO;

    @Inject
    ItemDAO itemDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(ItemBean itemBean) {
        logger.info("Criando novo item. " + itemBean);
        try {
            RecordDO record = recordDAO.find(itemBean.getRecordId());
            ItemDO newItem = new ItemDO();
            newItem.setRecordId(record.getId());
            newItem.setName(itemBean.getName());
            newItem.setPower(itemBean.getPower());
            newItem.setDamage(itemBean.getDamage());
            Integer itemId = itemDAO.save(newItem);
            return Response.status(Response.Status.CREATED).entity(itemId).build();
        } catch (Exception e) {
            logger.error("Erro ao criar item. " + itemBean + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar item").build();
        }
    }

    @DELETE
    @Path("/{itemId}")
    public Response delete(@PathParam("itemId") Integer itemId) {
        try {
            logger.info("Removendo item " + itemId);
            itemDAO.delete(itemId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error("Erro ao remover item " + itemId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao remover item").build();
        }
    }
}
