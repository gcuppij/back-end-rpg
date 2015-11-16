package br.com.rpg.DAO;

import java.util.List;

import javax.inject.Named;

import br.com.rpg.DO.SkillDO;

@Named
public class SkillDAO extends AbstractDAO<SkillDO> {

    @SuppressWarnings("unchecked")
    public List<SkillDO> findByRecord(Integer recordId) {
        List<SkillDO> result = (List<SkillDO>) getCurrentSession().createQuery("from SkillDO where recordId=:recordId")
                .setParameter("recordId", recordId).list();

        return result;
    }
}
