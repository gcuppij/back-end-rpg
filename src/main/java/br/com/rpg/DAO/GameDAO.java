package br.com.rpg.DAO;

import java.util.List;

import javax.inject.Named;

import br.com.rpg.DO.GameDO;

@Named
public class GameDAO extends AbstractDAO<GameDO> {

    public GameDO getGameByToken(String token) {
        GameDO result = (GameDO) getCurrentSession().createQuery("from GameDO where token=:token")
                .setParameter("token", token).uniqueResult();

        return result;
    }

    public GameDO find(Integer id) {
        GameDO result = (GameDO) getCurrentSession().createQuery("from GameDO where id=:id").setParameter("id", id)
                .uniqueResult();

        return result;
    }

    @SuppressWarnings("unchecked")
    public List<GameDO> findAll(Integer userId) {
        List<GameDO> result = (List<GameDO>) getCurrentSession().createQuery("from GameDO where userId=:userId")
                .setParameter("userId", userId).list();

        return result;
    }

    public void delete(Integer id) {
        getCurrentSession().createSQLQuery("delete from game where id = " + id).executeUpdate();
    }

    public void setMap(Integer gameId, Integer mapId) {
        getCurrentSession().createSQLQuery("update game set mapId = " + mapId + " where id = " + gameId)
                .executeUpdate();
    }

}
