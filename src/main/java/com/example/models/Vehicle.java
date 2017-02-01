package com.example.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;

//import org.hibernate.annotations.GenericGenerator; 
//import org.hibernate.id.SequenceGenerator;
//import org.hibernate.id.IdentifierGenerator;

@Entity
@Table(name = "REST_DB_ACCESS")
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT e FROM Vehicle e"),
    @NamedQuery(name = "Vehicle.find", query = "SELECT e FROM Vehicle e WHERE vehicleno = :vehicleno")
})

//@XmlAccessorType(XmlAccessType.NONE)
//@XmlRootElement(name = "trip_update")
@XmlType(propOrder = {"vehicleno","lat", "lon","dest","nextstop","stopsequence","uncertainty","late"})
public class Vehicle implements Serializable {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 5)
    private int vehicleno;
    
    @Column(length = 15)
    private String latitude;

    @Column(length = 15)
    private String longitude;

    @Column(length = 25)
    private String dest;

    @Column(length = 20)
    private String nextstop;

    @Column(length = 3)
    private int late;

    @Column(length = 3)
    private int uncertainty;

    @Column(length = 3)
    private int stopsequence;

    /*@XmlElement(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer i) {
        this.id = i;
    }*/

    @XmlElement(name = "vehicleno")
    public Integer getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(Integer vehicleno) {
        this.vehicleno = vehicleno;
    }
    
    @XmlElement(name = "lat")
    public String getLat() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @XmlElement(name = "lon")
    public String getLon() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @XmlElement(name = "dest")
    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @XmlElement(name = "nextstop")
    public String getNextstop() {
        return nextstop;
    }

    public void setNextstop(String nextstop) {
        this.nextstop = nextstop;
    }

    @XmlElement(name = "late")
    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
    }

    @XmlElement(name = "uncertainty")
    public Integer getUncertainty() {
        return uncertainty;
    }

    public void setUncertainty(Integer uncertainty) {
        this.uncertainty = uncertainty;
    }

    @XmlElement(name = "stopsequence")
    public Integer getStopSequence() {
        return stopsequence;
    }

    public void setStopSequence(Integer stopsequence) {
        this.stopsequence = stopsequence;
    }

}
