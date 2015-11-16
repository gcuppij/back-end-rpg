package br.com.rpg.DAO;

import javax.inject.Named;

import br.com.rpg.DO.RecordDO;

@Named
public class RecordDAO extends AbstractDAO<RecordDO> {

    public RecordDO find(Integer id) {
        RecordDO result = (RecordDO) getCurrentSession().createQuery("from RecordDO where id = :id")
                .setParameter("id", id).uniqueResult();

        return result;
    }

    public void updateMoney(Integer id, Integer money) {
        getCurrentSession().createSQLQuery(
                "update record set money = " + money + " where id = " + id).executeUpdate();
    }
}
