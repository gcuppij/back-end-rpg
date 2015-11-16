package br.com.rpg.DAO;

import java.util.List;

import javax.inject.Named;

import br.com.rpg.DO.PlayerDO;

@Named
public class PlayerDAO extends AbstractDAO<PlayerDO> {

    @SuppressWarnings("unchecked")
    public List<PlayerDO> findByGameId(Integer id) {
        List<PlayerDO> result = (List<PlayerDO>) getCurrentSession()
                .createQuery("from PlayerDO where gameId = :gameId").setParameter("gameId", id).list();

        return result;
    }

    public PlayerDO find(Integer id) {
        PlayerDO result = (PlayerDO) getCurrentSession().createQuery("from PlayerDO where id = :id")
                .setParameter("id", id).uniqueResult();

        return result;
    }

    @SuppressWarnings("unchecked")
    public List<PlayerDO> findAll(Integer userId) {
        List<PlayerDO> result = (List<PlayerDO>) getCurrentSession()
                .createQuery("from PlayerDO where userId = :userId").setParameter("userId", userId).list();

        return result;
    }

    public void delete(Integer id) {
        getCurrentSession().createSQLQuery("delete from player where id = " + id).executeUpdate();
    }

    public void insertGame(Integer id, Integer gameId) {
        getCurrentSession().createSQLQuery("update player set gameId = " + gameId + " where id = " + id)
                .executeUpdate();
    }

    public void insertRecord(Integer id, Integer recordId) {
        getCurrentSession().createSQLQuery("update player set recordId = " + recordId + " where id = " + id)
                .executeUpdate();
    }

}
