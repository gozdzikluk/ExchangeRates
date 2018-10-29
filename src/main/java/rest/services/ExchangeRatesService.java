package rest.services;




public interface ExchangeRatesService {
     double getRates(String table, String code, int topCount);
}
