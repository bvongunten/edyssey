package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.references.Material;

@Entity
public class BodyMaterial extends BaseEntity implements Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
  
    @ManyToOne
    private Body body;

    @Column
    double percent;
    
    @ManyToOne
    Material material;
    
    public BodyMaterial() {
        // Default
    }


    public BodyMaterial(Body body) {
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


    public double getPercent() {
        return percent;
    }


    public void setPercent(double percent) {
        this.percent = percent;
    }


    public Material getMaterial() {
        return material;
    }


    public void setMaterial(Material material) {
        this.material = material;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }



}
