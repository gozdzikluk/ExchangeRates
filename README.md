# ExchangeRates

##### The service's task is to calculate the average exchange rate from n-last quotes based on data published by the NBP website.

### API Resources
#### GET /4JA18L07/exchangerates/rates/{table}/{code}/{topCount}/
where:

* {table} – table type (A, B, or C)
* {code} – currency code (ISO 4217)
* {topCount} – a number that specifies the maximum cardinality of the returned data series

Response body:

```
{stringValue} pattern: "#0.0000"
```
