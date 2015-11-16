package br.com.rpg.DAO;

import java.util.List;

import javax.inject.Named;

import br.com.rpg.DO.CountryDO;

@Named
public class CountryDAO extends AbstractDAO<CountryDO> {

    public List<CountryDO> findAll() {
        @SuppressWarnings("unchecked")
        List<CountryDO> countries = (List<CountryDO>) getCurrentSession().createQuery("from CountryDO").list();
        return countries;
    }

}
