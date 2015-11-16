package br.com.rpg.DAO;

import javax.inject.Named;

import br.com.rpg.DO.MapDO;

@Named
public class MapDAO extends AbstractDAO<MapDO> {

    public MapDO find(Integer id) {
        MapDO result = (MapDO) getCurrentSession().createQuery("from MapDO where id = :id")
                .setParameter("id", id).uniqueResult();

        return result;
        
    }

}
