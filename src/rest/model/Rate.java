package rest.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rate")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Rate {
    @XmlElement(name = "No")
    private String no;
    @XmlElement(name = "EffectiveDate")
    private String effectiveDate;
    @XmlElement(name = "Mid")
    private double mid;
}
