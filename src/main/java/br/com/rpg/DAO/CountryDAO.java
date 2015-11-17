package br.com.rpg.DAO;

import java.util.ArrayList;

import javax.inject.Named;

import br.com.rpg.DO.CountryDO;

@Named
public class CountryDAO extends AbstractDAO<CountryDO> {

    public ArrayList<CountryDO> findAll() {
        @SuppressWarnings("unchecked")
        ArrayList<CountryDO> countries = (ArrayList<CountryDO>) getCurrentSession().createQuery("from CountryDO").list();
        return countries;
    }

}
