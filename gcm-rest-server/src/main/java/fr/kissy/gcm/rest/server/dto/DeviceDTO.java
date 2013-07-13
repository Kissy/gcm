package fr.kissy.gcm.rest.server.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Device", namespace = "http://kissy.fr/gcm/dto")
public class DeviceDTO implements Serializable {
    @XmlElement(required = true)
    private String id;
    @XmlElement(required = true)
    private String registration;
    @XmlElement(required = true)
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
