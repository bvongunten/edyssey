package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ch.nostromo.edyssey.database.entities.references.Atmosphere;
import ch.nostromo.edyssey.database.entities.references.BodyType;
import ch.nostromo.edyssey.database.entities.references.PlanetClass;
import ch.nostromo.edyssey.database.entities.references.StarType;
import ch.nostromo.edyssey.database.entities.references.TerraformState;
import ch.nostromo.edyssey.database.entities.references.Volcanism;

@Entity
public class Body extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String bodyName;

    @ManyToOne
    private BodyType bodyType;

    @ManyToOne
    private StarSystem starSystem;

    @Column
    private Double distanceFromArrivalLS;

    @ManyToOne
    private StarType starType;

    @Column
    private Double stellarMass;

    @Column
    private Double radius;

    @Column
    private Double absoluteMagnitude;

    @Column
    private Double rotationPeriod;

    @Column
    private Double surfaceTemperature;

    @Column
    private Double ageMy;

    @OneToMany(mappedBy = "body", orphanRemoval = true)
    private List<BodyRing> rings = new ArrayList<>();

    @OneToMany(mappedBy = "body", orphanRemoval = true)
    private List<BodyMaterial> material = new ArrayList<>();

    @OneToMany(mappedBy = "body", orphanRemoval = true)
    private List<BodyAtmosphereComposition> atmosphereComposition = new ArrayList<>();

    @Column
    private Boolean tidalLock;

    @ManyToOne
    private TerraformState terraFormState;

    @ManyToOne
    private PlanetClass planetClass;

    @ManyToOne
    private Atmosphere Atmosphere;

    @ManyToOne
    private Volcanism Volcanism;

    @Column
    private Double surfaceGravity;

    @Column
    private Double surfacePressure;

    @Column
    private Boolean landable;

    @Column
    private Double semiMajorAxis;

    @Column
    private Double eccentricity;

    @Column
    private Double orbitalInclination;

    @Column
    private Double periapsis;

    @Column
    private Double orbitalPeriod;

    public Body() {
        // Default
    }

    public Body(StarSystem starSystem, String bodyName) {
        this.starSystem = starSystem;
        this.bodyName = bodyName;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBodyName() {
        return bodyName;
    }

    public void setBodyName(String bodyName) {
        this.bodyName = bodyName;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public StarSystem getStarSystem() {
        return starSystem;
    }

    public void setStarSystem(StarSystem starSystem) {
        this.starSystem = starSystem;
    }

    public Double getDistanceFromArrivalLS() {
        return distanceFromArrivalLS;
    }

    public void setDistanceFromArrivalLS(Double distanceFromArrivalLS) {
        this.distanceFromArrivalLS = distanceFromArrivalLS;
    }

    public Double getStellarMass() {
        return stellarMass;
    }

    public void setStellarMass(Double stellarMass) {
        this.stellarMass = stellarMass;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    public void setAbsoluteMagnitude(Double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    public Double getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(Double rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public Double getSurfaceTemperature() {
        return surfaceTemperature;
    }

    public void setSurfaceTemperature(Double surfaceTemperature) {
        this.surfaceTemperature = surfaceTemperature;
    }

    public Double getAgeMy() {
        return ageMy;
    }

    public void setAgeMy(Double ageMy) {
        this.ageMy = ageMy;
    }

    public List<BodyRing> getRings() {
        return rings;
    }

    public void setRings(List<BodyRing> rings) {
        this.rings = rings;
    }

    public Boolean getTidalLock() {
        return tidalLock;
    }

    public void setTidalLock(Boolean tidalLock) {
        this.tidalLock = tidalLock;
    }

    public TerraformState getTerraFormState() {
        return terraFormState;
    }

    public void setTerraFormState(TerraformState terraFormState) {
        this.terraFormState = terraFormState;
    }

    public PlanetClass getPlanetClass() {
        return planetClass;
    }

    public void setPlanetClass(PlanetClass planetClass) {
        this.planetClass = planetClass;
    }

    public Atmosphere getAtmosphere() {
        return Atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        Atmosphere = atmosphere;
    }

    public Volcanism getVolcanism() {
        return Volcanism;
    }

    public void setVolcanism(Volcanism volcanism) {
        Volcanism = volcanism;
    }

    public Double getSurfaceGravity() {
        return surfaceGravity;
    }

    public void setSurfaceGravity(Double surfaceGravity) {
        this.surfaceGravity = surfaceGravity;
    }

    public Double getSurfacePressure() {
        return surfacePressure;
    }

    public void setSurfacePressure(Double surfacePressure) {
        this.surfacePressure = surfacePressure;
    }

    public Boolean getLandable() {
        return landable;
    }

    public void setLandable(Boolean landable) {
        this.landable = landable;
    }

    public List<BodyMaterial> getMaterial() {
        return material;
    }

    public void setMaterial(List<BodyMaterial> material) {
        this.material = material;
    }

    public Double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(Double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Double getOrbitalInclination() {
        return orbitalInclination;
    }

    public void setOrbitalInclination(Double orbitalInclination) {
        this.orbitalInclination = orbitalInclination;
    }

    public Double getPeriapsis() {
        return periapsis;
    }

    public void setPeriapsis(Double periapsis) {
        this.periapsis = periapsis;
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public List<BodyAtmosphereComposition> getAtmosphereComposition() {
        return atmosphereComposition;
    }

    public void setAtmosphereComposition(List<BodyAtmosphereComposition> atmosphereComposition) {
        this.atmosphereComposition = atmosphereComposition;
    }

}
