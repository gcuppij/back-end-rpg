package br.com.rpg.DAO;

import javax.inject.Named;

import br.com.rpg.DO.UserDO;

@Named
public class UserDAO extends AbstractDAO<UserDO> {

    public UserDO findUserAndPassword(String username, String password) {
        UserDO result = (UserDO) getCurrentSession()
                .createQuery("from UserDO where name=:username and password=:password")
                .setParameter("username", username).setParameter("password", password).uniqueResult();

        return result;
    }

    public UserDO find(Integer id) {
        UserDO result = (UserDO) getCurrentSession().createQuery("from UserDO where id=:id").setParameter("id", id)
                .uniqueResult();

        return result;
    }

}
