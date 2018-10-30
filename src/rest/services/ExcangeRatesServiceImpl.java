package rest.services;

import rest.model.NBPresponse;
import rest.model.Rate;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@Stateless
public class ExcangeRatesServiceImpl implements ExchangeRatesService {
    @Override
    public double getRates(String table, String code, int topCount) {
        Client client = ClientBuilder.newClient();
        NBPresponse nbPresponse = client
                .target("http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/last/{count}/?format=xml")
                .resolveTemplate("table", table)
                .resolveTemplate("code", code)
                .resolveTemplate("count", String.valueOf(topCount))
                .request(MediaType.APPLICATION_XML)
                .get(NBPresponse.class);
        client.close();
        
        System.out.println(nbPresponse.getCurrency());
        System.out.println(nbPresponse.getRates().size());

        return countMean(nbPresponse);
    }

    public double countMean(NBPresponse nbPresponse){
        return nbPresponse.getRates().stream()
                .mapToDouble(Rate::getMid)
                .average()
                .orElse(Double.NaN);
    }
}
