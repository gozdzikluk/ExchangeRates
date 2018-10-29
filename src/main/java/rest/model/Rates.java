package rest.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class Rates {
    private String no;
    private String effectiveDate;
    private double mid;
}
