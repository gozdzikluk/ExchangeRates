package rest.services;

import rest.model.NBPresponse;
import rest.model.Rates;

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
                .target("http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/last/{count}/")
                .resolveTemplate("table", table)
                .resolveTemplate("code", code)
                .resolveTemplate("count", String.valueOf(topCount))
                .request(MediaType.APPLICATION_JSON)
                .get(NBPresponse.class);
        client.close();

        return countMean(nbPresponse);
    }

    public double countMean(NBPresponse nbPresponse){
        return nbPresponse.getRates().stream()
                .mapToDouble(Rates::getMid)
                .average()
                .orElse(Double.NaN);
    }
}
