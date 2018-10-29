package rest.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@Data
public class NBPresponse {
    private String Table;
    private String currency;
    private String code;
    private List<Rates> rates;

}
