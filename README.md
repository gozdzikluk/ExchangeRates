# ExchangeRates

##### The service's task is to calculate the average exchange rate from n-last quotes based on data published by the NBP website.

### Prerequisites

* The project was built using Maven.
* The project uses [ProjectLombok](https://projectlombok.org), so if you want to build it yourself, you must first install [ProjectLombok](https://projectlombok.org) for your IDE.


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


### Additional information

The repository contains a ready-made war file to deploy.
