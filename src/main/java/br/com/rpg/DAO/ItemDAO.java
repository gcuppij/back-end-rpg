package br.com.rpg.DAO;

import java.util.List;

import javax.inject.Named;

import br.com.rpg.DO.ItemDO;

@Named
public class ItemDAO extends AbstractDAO<ItemDO> {

    @SuppressWarnings("unchecked")
    public List<ItemDO> findByRecord(Integer recordId) {
        List<ItemDO> result = (List<ItemDO>) getCurrentSession().createQuery("from ItemDO where recordId=:recordId")
                .setParameter("recordId", recordId).list();

        return result;
    }

    public void delete(Integer id) {
        getCurrentSession().createSQLQuery("delete from item where id = " + id).executeUpdate();
    }
}
