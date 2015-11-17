package br.com.rpg.services;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rpg.DAO.CountryDAO;
import br.com.rpg.DO.CountryDO;

@Named
@Path("/country")
public class CountryService {

    @Inject
    private CountryDAO countryDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountries() {
        try {
            ArrayList<CountryDO> countries = countryDAO.findAll();
            return Response.status(Response.Status.OK).entity(countries).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar paises").build();
        }
    }
}
