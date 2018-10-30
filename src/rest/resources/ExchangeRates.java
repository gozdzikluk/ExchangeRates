package rest.resources;


import rest.services.ExchangeRatesService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.DecimalFormat;

@Stateless
@Path("/exchangerates")
public class ExchangeRates {
    @EJB
    private ExchangeRatesService exchangeRatesService;

    @GET
    @Path("/rates/{table}/{code}/{topCount}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRates(@PathParam("table") String table,
                             @PathParam("code") String code,
                             @PathParam("topCount") int topCount){

        DecimalFormat dec = new DecimalFormat("#0.0000");
        return dec.format(exchangeRatesService.getRates(table,code,topCount));
    }
}