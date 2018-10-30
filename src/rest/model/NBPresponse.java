package rest.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "ExchangeRatesSeries")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class NBPresponse {
    @XmlElement(name = "Table")
    private String Table;
    @XmlElement(name = "Currency")
    private String currency;
    @XmlElement(name = "Code")
    private String code;
    @XmlElementWrapper(name = "Rates")
    @XmlElement(name = "Rate")
    private List<Rate> rates;

}
