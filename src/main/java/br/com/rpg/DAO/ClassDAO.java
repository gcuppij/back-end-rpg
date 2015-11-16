package br.com.rpg.DAO;

import javax.inject.Named;

import br.com.rpg.DO.ClassDO;

@Named
public class ClassDAO extends AbstractDAO<ClassDO> {

    public ClassDO find(Integer id) {
        ClassDO result = (ClassDO) getCurrentSession().createQuery("from ClassDO where id = :id")
                .setParameter("id", id).uniqueResult();

        return result;
    }
}
