package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.references.RingClass;

@Entity
public class BodyRing extends BaseEntity implements Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
  
    @ManyToOne
    private Body body;

    @Column
    double outerRad;
    
    @Column
    double innerRad;
    
    @Column
    double massMt;
    
    @Column
    String name;
    
    @ManyToOne
    RingClass ringClass;
    
    public BodyRing() {
        // Default
    }


    public BodyRing(Body body) {
        this.body = body;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Body getBody() {
        return body;
    }


    public void setBody(Body body) {
        this.body = body;
    }


    public double getOuterRad() {
        return outerRad;
    }


    public void setOuterRad(double outerRad) {
        this.outerRad = outerRad;
    }


    public double getInnerRad() {
        return innerRad;
    }


    public void setInnerRad(double innerRad) {
        this.innerRad = innerRad;
    }


    public double getMassMt() {
        return massMt;
    }


    public void setMassMt(double massMt) {
        this.massMt = massMt;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public RingClass getRingClass() {
        return ringClass;
    }


    public void setRingClass(RingClass ringClass) {
        this.ringClass = ringClass;
    }
    

}
