package br.com.rpg.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.rpg.DAO.RecordDAO;
import br.com.rpg.DAO.SkillDAO;
import br.com.rpg.DO.RecordDO;
import br.com.rpg.DO.SkillDO;
import br.com.rpg.services.beans.SkillBean;

@Named
@Path("/skill")
public class SkillService {

    Logger logger = Logger.getLogger(SkillService.class);

    @Inject
    RecordDAO recordDAO;

    @Inject
    SkillDAO skillDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(SkillBean skillBean) {
        logger.info("Criando nova habilidade. " + skillBean);
        try {
            RecordDO record = recordDAO.find(skillBean.getRecordId());
            SkillDO newSkill = new SkillDO();
            newSkill.setRecordId(record.getId());
            newSkill.setName(skillBean.getName());
            newSkill.setPoint(skillBean.getPoint());
            Integer skillId = skillDAO.save(newSkill);
            return Response.status(Response.Status.CREATED).entity(skillId).build();
        } catch (Exception e) {
            logger.error("Erro ao criar habilidade. " + skillBean + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar habilidade").build();
        }
    }

    @DELETE
    @Path("/{skillId}")
    public Response delete(@PathParam("skillId") Integer skillId) {
        try {
            logger.info("Removendo habilidade " + skillId);
            skillDAO.delete(skillId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            logger.error("Erro ao remover habilidade " + skillId + ". " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao remover habilidade").build();
        }
    }
}
