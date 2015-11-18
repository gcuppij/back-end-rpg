package br.com.rpg.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.rpg.DAO.ClassDAO;
import br.com.rpg.DAO.PlayerDAO;
import br.com.rpg.DAO.RaceDAO;
import br.com.rpg.DAO.RecordDAO;
import br.com.rpg.DO.ClassDO;
import br.com.rpg.DO.RaceDO;
import br.com.rpg.DO.RecordDO;
import br.com.rpg.services.beans.RecordBean;

@Named
@Path("/record")
public class RecordService {

    Logger logger = Logger.getLogger(RecordService.class);

    @Inject
    private PlayerDAO playerDAO;

    @Inject
    private RecordDAO recordDAO;

    @Inject
    private ClassDAO classDAO;

    @Inject
    private RaceDAO raceDAO;

    @PUT
    @Path("/change/money")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertGame(@FormParam("recordId") Integer recordId, @FormParam("money") Integer money) {
        try {
            logger.info("Alterando dinheiro para " + money + " do ficha " + recordId);
            recordDAO.updateMoney(recordId, money);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error("Erro ao alterar dinheiro para " + money + " no ficha " + recordId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao alterar dinheiro").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(RecordBean recordBean) {
        logger.info("Criando nova ficha. " + recordBean);
        try {
            RecordDO newRecord = new RecordDO();
            newRecord.setClassId(createClass(recordBean.getClassName(), recordBean.getClassBonus()));
            newRecord.setRaceId(createRace(recordBean.getRaceName(), recordBean.getRaceBonus()));
            Integer recordId = recordDAO.save(newRecord);
            playerDAO.insertRecord(recordBean.getPlayerId(), recordId);
            return Response.status(Response.Status.CREATED).entity(recordId).build();
        } catch (Exception e) {
            logger.error("Erro ao criar ficha. " + recordBean + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar ficha").build();
        }
    }

    private Integer createRace(String raceName, String raceBonus) {
        RaceDO newRace = new RaceDO();
        newRace.setName(raceName);
        newRace.setBonus(raceBonus);
        return raceDAO.save(newRace);
    }

    private Integer createClass(String className, String classBonus) {
        ClassDO newClass = new ClassDO();
        newClass.setName(className);
        newClass.setBonus(classBonus);
        return classDAO.save(newClass);
    }
}
