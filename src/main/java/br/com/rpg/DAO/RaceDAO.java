package br.com.rpg.DAO;

import javax.inject.Named;

import br.com.rpg.DO.RaceDO;

@Named
public class RaceDAO extends AbstractDAO<RaceDO> {

    public RaceDO find(Integer id) {
        RaceDO result = (RaceDO) getCurrentSession().createQuery("from RaceDO where id = :id").setParameter("id", id)
                .uniqueResult();

        return result;
    }
}
