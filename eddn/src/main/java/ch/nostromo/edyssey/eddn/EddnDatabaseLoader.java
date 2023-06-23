package ch.nostromo.edyssey.eddn;

import ch.nostromo.edyssey.database.Database;
import ch.nostromo.edyssey.database.entities.*;
import ch.nostromo.edyssey.database.entities.references.Module;
import ch.nostromo.edyssey.database.entities.references.PendingState;
import ch.nostromo.edyssey.database.entities.references.RecoveringState;
import ch.nostromo.edyssey.database.entities.references.Ship;
import ch.nostromo.edyssey.eddn.json.EddnEnvelope;
import ch.nostromo.edyssey.eddn.json.blackmarket.EddnBlackMarket;
import ch.nostromo.edyssey.eddn.json.commodity.EddnCommodity;
import ch.nostromo.edyssey.eddn.json.commodity.JsonCommodityMessageEntry;
import ch.nostromo.edyssey.eddn.json.journal.EddnJournal;
import ch.nostromo.edyssey.eddn.json.outfitting.EddnOutfitting;
import ch.nostromo.edyssey.eddn.json.shipyard.EddnShipyard;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EddnDatabaseLoader implements EddnConsumerListener {

    public static final Logger LOG = Logger.getLogger(EddnDatabaseLoader.class);

    public static final String EDDN_RELAY = "tcp://eddn.edcd.io:9500";

    EddnConsumer consumer;
    Database database;

    EddnDatabaseLoaderListener eventListener;


    public EddnDatabaseLoader(Database database, EddnDatabaseLoaderListener eventListener) throws Exception {
        this.database = database;
        this.eventListener = eventListener;
    }

    public void startCollecting() throws IOException {
        consumer = new EddnConsumer(this, EDDN_RELAY);
        consumer.run();
    }

    public void stopCollecting() {
        consumer.setRunning(false);
        consumer = null;
        database = null;
    }

    private Double toDouble(Object value) {
        if (value == null) {
            return null;
        }

        return ((Number) value).doubleValue();
    }

    private void handleDockedJournalEntry(StarSystem starSystem, Map<String, Object> valueMap) {

        // Check if station already exists, if not, add to StarSystem
        String stationName = (String) valueMap.get("StationName");
        if (stationName == null) {
            throw new IllegalArgumentException("No station key given");
        }

        Station stationToEdit = database.getMainEntityHelper().getOrCreateStationInStarSystem(starSystem, stationName);

        // Add staiton values
        if (valueMap.get("StationFaction") instanceof String) {
            String stationFaction = (String) valueMap.get("StationFaction");
            if (stationFaction != null) {
                stationToEdit.setStationFaction(database.getReferenceEntityHelper().getOrCreateFaction(stationFaction));
            }

        } else {
            LinkedHashMap<String, String> stationFaction = (LinkedHashMap<String, String>) valueMap.get("StationFaction");
            if (stationFaction != null) {
                stationToEdit.setStationFaction(database.getReferenceEntityHelper().getOrCreateFaction(stationFaction.get("Name")));
            }
        }


        String stationAllegiance = (String) valueMap.get("StationAllegiance");
        if (stationAllegiance != null) {
            stationToEdit.setStationAllegiance(database.getReferenceEntityHelper().getOrCreateAllegiance(stationAllegiance));
        }

        String stationEconomy = (String) valueMap.get("StationEconomy");
        if (stationEconomy != null) {
            stationToEdit.setStationEconomy(database.getReferenceEntityHelper().getOrCreateEconomy(stationEconomy));
        }

        String factionState = (String) valueMap.get("FactionState");
        if (factionState != null) {
            stationToEdit.setStationFactionState(database.getReferenceEntityHelper().getOrCreateFactionState(factionState));
        }

        String stationGovernment = (String) valueMap.get("StationGovernment");
        if (stationGovernment != null) {
            stationToEdit.setStationGovernment(database.getReferenceEntityHelper().getOrCreateGovernment(stationGovernment));
        }

        String stationType = (String) valueMap.get("StationType");
        if (stationType != null) {
            stationToEdit.setStationType(database.getReferenceEntityHelper().getOrCreateStationType(stationType));
        }

        Double distance = toDouble(valueMap.get("DistFromStarLS"));
        if (distance != null) {
            stationToEdit.setDistFromStarLS(distance);
        }

        // If body is set, add body to station & set type
        String bodyName = (String) valueMap.get("Body");
        if (bodyName != null) {

            // Check if body exists in star system
            Body bodyToEdit = database.getMainEntityHelper().getOrCreateBodyInStarSystem(starSystem, bodyName);
            stationToEdit.setBody(bodyToEdit);

            String bodyType = (String) valueMap.get("BodyType");
            if (bodyType != null) {
                bodyToEdit.setBodyType(database.getReferenceEntityHelper().getOrCreateBodyType(bodyType));
            }

        }

    }

    private void handleFSDJumpJournalEntry(StarSystem starSystem, Map<String, Object> valueMap) {

        String systemFactionState = (String) valueMap.get("FactionState");
        if (systemFactionState != null) {
            starSystem.setFactionState(database.getReferenceEntityHelper().getOrCreateFactionState(systemFactionState));
        }


        if (valueMap.get("SystemFaction") instanceof String) {
            String systemFaction = (String) valueMap.get("SystemFaction");
            if (systemFaction != null) {
                starSystem.setSystemFaction(database.getReferenceEntityHelper().getOrCreateFaction(systemFaction));
            }
        } else {
            LinkedHashMap<String, String> systemFaction = (LinkedHashMap) valueMap.get("SystemFaction");
            if (systemFaction != null) {
                starSystem.setSystemFaction(database.getReferenceEntityHelper().getOrCreateFaction(systemFaction.get("Name")));
            }
        }
        String systemSecurity = (String) valueMap.get("SystemSecurity");
        if (systemSecurity != null) {
            starSystem.setSystemSecurity(database.getReferenceEntityHelper().getOrCreateSecurity(systemSecurity));
        }

        String systemAllegiance = (String) valueMap.get("SystemAllegiance");
        if (systemAllegiance != null) {
            starSystem.setSystemAllegiance(database.getReferenceEntityHelper().getOrCreateAllegiance(systemAllegiance));
        }

        String systemEconomy = (String) valueMap.get("SystemEconomy");
        if (systemEconomy != null) {
            starSystem.setSystemEconomy(database.getReferenceEntityHelper().getOrCreateEconomy(systemEconomy));
        }

        String powerplayState = (String) valueMap.get("PowerplayState");
        if (powerplayState != null) {
            starSystem.setPowerPlayState(database.getReferenceEntityHelper().getOrCreatePowerPlayState(powerplayState));
        }

        String systemGovernment = (String) valueMap.get("SystemGovernment");
        if (systemGovernment != null) {
            starSystem.setSystemGovernment(database.getReferenceEntityHelper().getOrCreateGovernment(systemGovernment));
        }

        // Readd all powers to the system ;)
        @SuppressWarnings("unchecked")
        List<String> powers = (List<String>) valueMap.get("Powers");
        if (powers != null) {
            starSystem.getPowers().clear();
            for (String powerKey : powers) {
                starSystem.getPowers().add(database.getReferenceEntityHelper().getOrCreatePower(powerKey));
            }
        }

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> factionsMap = (List<Map<String, Object>>) valueMap.get("Factions");
        if (factionsMap != null) {
            addFactionsToStarsystem(starSystem, factionsMap);
        }

    }

    private void handleLocationJournalEntry(StarSystem starSystem, Map<String, Object> valueMap) {

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> factionsMap = (List<Map<String, Object>>) valueMap.get("Factions");
        if (factionsMap != null) {
            addFactionsToStarsystem(starSystem, factionsMap);
        }

    }

    private void addFactionsToStarsystem(StarSystem starSystem, List<Map<String, Object>> factionsMap) {
        // Well, remove all ;)
        starSystem.getSystemFactions().clear();

        for (Map<String, Object> factionMap : factionsMap) {

            StarSystemFaction starSystemFaction = database.getMainEntityHelper().createSystemFactionInStarSystem(starSystem);

            starSystemFaction.setFaction(database.getReferenceEntityHelper().getOrCreateFaction((String) factionMap.get("Name")));
            starSystemFaction.setAllegiance(database.getReferenceEntityHelper().getOrCreateAllegiance((String) factionMap.get("Allegiance")));
            starSystemFaction.setGovernment(database.getReferenceEntityHelper().getOrCreateGovernment((String) factionMap.get("Government")));
            starSystemFaction.setFactionState(database.getReferenceEntityHelper().getOrCreateFactionState((String) factionMap.get("FactionState")));

            starSystemFaction.setInfluence(toDouble(factionMap.get("Influence")));

            if (factionMap.get("PendingStates") != null) {
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> pendingStates = (List<Map<String, Object>>) factionMap.get("PendingStates");

                for (Map<String, Object> pendingStateMap : pendingStates) {
                    PendingState pendingState = database.getReferenceEntityHelper().getOrCreatePendingState((String) pendingStateMap.get("State"));
                    int trend = (int) pendingStateMap.get("Trend");

                    StarSystemFactionPendingState starSystemFactionPendingState = database.getMainEntityHelper().createPendingStateInFaction(starSystemFaction);

                    starSystemFactionPendingState.setPendingState(pendingState);
                    starSystemFactionPendingState.setTrend(trend);

                }
            }

            if (factionMap.get("RecoveringStates") != null) {
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> recoveringStates = (List<Map<String, Object>>) factionMap.get("RecoveringStates");

                for (Map<String, Object> recoveringStateMap : recoveringStates) {
                    RecoveringState recoveringState = database.getReferenceEntityHelper().getOrCreateRecoveringState((String) recoveringStateMap.get("State"));
                    int trend = (int) recoveringStateMap.get("Trend");

                    StarSystemFactionRecoveringState starSystemFactionRecoveringState = database.getMainEntityHelper().createRecoveringStateInFaction(starSystemFaction);

                    starSystemFactionRecoveringState.setRecoveringState(recoveringState);
                    starSystemFactionRecoveringState.setTrend(trend);
                }
            }

        }

    }

    private void handleScanJournalEntry(StarSystem starSystem, Map<String, Object> valueMap) {

        String bodyName = (String) valueMap.get("BodyName");
        if (bodyName == null) {
            throw new IllegalArgumentException("No body key given");
        }

        Body bodyToEdit = database.getMainEntityHelper().getOrCreateBodyInStarSystem(starSystem, bodyName);

        Double distance = toDouble(valueMap.get("DistanceFromArrivalLS"));
        if (distance != null) {
            bodyToEdit.setDistanceFromArrivalLS(distance);
        }

        String starType = (String) valueMap.get("StarType");
        if (starType != null) {
            bodyToEdit.setStarType(database.getReferenceEntityHelper().getOrCreateStarType(starType));
        }

        Double stellarMass = toDouble(valueMap.get("StellarMass"));
        if (stellarMass != null) {
            bodyToEdit.setStellarMass(stellarMass);
        }

        Double absoluteMagnitude = toDouble(valueMap.get("AbsoluteMagnitude"));
        if (stellarMass != null) {
            bodyToEdit.setAbsoluteMagnitude(absoluteMagnitude);
        }

        Double rotationPeriod = toDouble((valueMap.get("RotationPeriod")));
        if (stellarMass != null) {
            bodyToEdit.setRotationPeriod(rotationPeriod);
        }

        Double surfaceTemperature = toDouble(valueMap.get("SurfaceTemperature"));
        if (stellarMass != null) {
            bodyToEdit.setSurfaceTemperature(surfaceTemperature);
        }

        String atmosphere = (String) valueMap.get("Atmosphere");
        if (atmosphere != null) {
            bodyToEdit.setAtmosphere(database.getReferenceEntityHelper().getOrCreateAtmosphere(atmosphere));

        }
        String terraformState = (String) valueMap.get("TerraformState");
        if (terraformState != null) {
            bodyToEdit.setTerraFormState(database.getReferenceEntityHelper().getOrCreateTerraformState(terraformState));
        }

        String planetClass = (String) valueMap.get("PlanetClass");
        if (planetClass != null) {
            bodyToEdit.setPlanetClass(database.getReferenceEntityHelper().getOrCreatePlanetClass(planetClass));
        }

        String volcanism = (String) valueMap.get("Volcanism");
        if (volcanism != null) {
            bodyToEdit.setVolcanism(database.getReferenceEntityHelper().getOrCreateVolacnism(volcanism));
        }

        Double surfaceGravity = toDouble(valueMap.get("SurfaceGravity"));
        if (surfaceGravity != null) {
            bodyToEdit.setSurfaceGravity(surfaceGravity);
        }

        Double surfacePressure = toDouble(valueMap.get("SurfacePressure"));
        if (surfacePressure != null) {
            bodyToEdit.setSurfacePressure(surfacePressure);
        }

        Boolean tidalLock = (Boolean) valueMap.get("TidalLock");
        if (tidalLock != null) {
            bodyToEdit.setTidalLock(tidalLock);
        }

        Boolean landable = (Boolean) valueMap.get("Landable");
        if (landable != null) {
            bodyToEdit.setLandable(landable);
        }

        Double semiMajorAxis = toDouble(valueMap.get("SemiMajorAxis"));
        if (semiMajorAxis != null) {
            bodyToEdit.setSemiMajorAxis(semiMajorAxis);
        }

        Double eccentricity = toDouble(valueMap.get("Eccentricity"));
        if (eccentricity != null) {
            bodyToEdit.setEccentricity(eccentricity);
        }

        Double orbitalInclination = toDouble(valueMap.get("OrbitalInclination"));
        if (orbitalInclination != null) {
            bodyToEdit.setOrbitalInclination(orbitalInclination);
        }

        Double periapsis = toDouble(valueMap.get("Periapsis"));
        if (periapsis != null) {
            bodyToEdit.setPeriapsis(periapsis);
        }

        Double orbitalPeriod = toDouble(valueMap.get("OrbitalPeriod"));
        if (orbitalPeriod != null) {
            bodyToEdit.setOrbitalPeriod(orbitalPeriod);
        }

        Double ageMy = toDouble(valueMap.get("Age_MY"));
        if (ageMy != null) {
            bodyToEdit.setAgeMy(ageMy);
        }

        Double radius = toDouble(valueMap.get("Radius"));
        if (radius != null) {
            bodyToEdit.setRadius(radius);
        }

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> bodyRingsMap = (List<Map<String, Object>>) valueMap.get("Rings");

        if (bodyRingsMap != null) {
            bodyToEdit.getRings().clear();

            for (Map<String, Object> bodyRingMap : bodyRingsMap) {

                BodyRing bodyring = database.getMainEntityHelper().createBodyRingOnBody(bodyToEdit);

                bodyring.setOuterRad(toDouble(bodyRingMap.get("OuterRad")));
                bodyring.setInnerRad(toDouble(bodyRingMap.get("InnerRad")));
                bodyring.setMassMt(toDouble(bodyRingMap.get("MassMT")));
                bodyring.setName((String) bodyRingMap.get("Name"));
                bodyring.setRingClass(database.getReferenceEntityHelper().getOrCreateRingClass((String) bodyRingMap.get("RingClass")));

            }

        }

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> bodyMaterialsMap = (List<Map<String, Object>>) valueMap.get("Materials");

        if (bodyMaterialsMap != null) {
            bodyToEdit.getMaterial().clear();

            for (Map<String, Object> bodyMaterialMap : bodyMaterialsMap) {
                BodyMaterial bodyMaterial = database.getMainEntityHelper().createBodyMaterialOnBody(bodyToEdit);

                bodyMaterial.setPercent(toDouble(bodyMaterialMap.get("Percent")));
                bodyMaterial.setMaterial(database.getReferenceEntityHelper().getOrCreateMaterial((String) bodyMaterialMap.get("Name")));
            }
        }

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> bodyAtmosphereCompositionsMap = (List<Map<String, Object>>) valueMap.get("AtmosphereComposition");

        if (bodyAtmosphereCompositionsMap != null) {
            bodyToEdit.getAtmosphereComposition().clear();

            for (Map<String, Object> bodyAtmosphereCompositionMap : bodyAtmosphereCompositionsMap) {
                BodyAtmosphereComposition bodyAtmosphereComposition = database.getMainEntityHelper().createBodyAtmosphereCompositionOnBody(bodyToEdit);

                bodyAtmosphereComposition.setPercent(toDouble(bodyAtmosphereCompositionMap.get("Percent")));
                bodyAtmosphereComposition.setAtmosphereComposition(database.getReferenceEntityHelper().getOrCreateAtmosphereComposition((String) bodyAtmosphereCompositionMap.get("Name")));
            }
        }

    }

    public void processJournalEvent(EddnJournal journal) {
        try {

            long startMs = System.currentTimeMillis();

            database.transactionStart();

            String systemKey = journal.getMessage().getStarSystem();
            if (systemKey == null) {
                throw new IllegalArgumentException("No System key given");
            }

            StarSystem starSystem = database.getMainEntityHelper().getOrCreateStarSystem(systemKey);
            starSystem.setStarPosX(journal.getMessage().getStarPos().get(0));
            starSystem.setStarPosY(journal.getMessage().getStarPos().get(1));
            starSystem.setStarPosZ(journal.getMessage().getStarPos().get(2));

            switch (journal.getMessage().getEvent()) {
                case DOCKED: {
                    handleDockedJournalEntry(starSystem, journal.getMessage().getAdditionalProperties());
                    LOG.debug("Docked processed, StarSystem: " + starSystem);
                    break;
                }
                case FSD_JUMP: {
                    handleFSDJumpJournalEntry(starSystem, journal.getMessage().getAdditionalProperties());
                    LOG.debug("FSD Jump processed, StarSystem: " + starSystem);
                    break;
                }
                case LOCATION: {
                    handleLocationJournalEntry(starSystem, journal.getMessage().getAdditionalProperties());
                    LOG.debug("Location processed, StarSystem: " + starSystem);
                    break;
                }
                case SCAN:
                    handleScanJournalEntry(starSystem, journal.getMessage().getAdditionalProperties());
                    LOG.debug("Location processed, StarSystem: " + starSystem);
                    break;
                default:
                    break;
            }

            database.transactionCommit();
            database.clearEntityManager();

            long totalMs = System.currentTimeMillis() - startMs;

            String message = "Processed Journal event of Type " + journal.getMessage().getEvent() + " on StarSystem : " + starSystem.getId() + " in " + totalMs + " ms.";
            eventListener.eddnMessageProcessed(message);
            LOG.info(message);


        } catch (Exception e) {
            database.transactionRollback();
            throw e;
        }
    }

    public void processCommidityEvent(EddnCommodity jsonCommodityBinding) {

        try {

            long startMs = System.currentTimeMillis();
            database.transactionStart();

            StarSystem starSystem = database.getMainEntityHelper().getOrCreateStarSystem(jsonCommodityBinding.getMessage().getSystemName());
            Station station = database.getMainEntityHelper().getOrCreateStationInStarSystem(starSystem, jsonCommodityBinding.getMessage().getStationName());

            station.getStationCommodities().clear();

            for (JsonCommodityMessageEntry jsonCommodity : jsonCommodityBinding.getMessage().getCommodities()) {

                StationCommodity stationCommodity = database.getMainEntityHelper().createStationCommodityOnStation(station);

                stationCommodity.setCommodity(database.getReferenceEntityHelper().getOrCreateCommodity(jsonCommodity.getName()));
                stationCommodity.setBuyPrice(jsonCommodity.getBuyPrice());
                stationCommodity.setDemand(jsonCommodity.getDemand());

                stationCommodity.setMeanPrice(jsonCommodity.getMeanPrice());
                stationCommodity.setSellPrice(jsonCommodity.getSellPrice());
                stationCommodity.setStatusFlags(jsonCommodity.getStatusFlags());
                stationCommodity.setStock(jsonCommodity.getStock());

                stationCommodity.setDemandBracket(database.getReferenceEntityHelper().getOrCreateCommodityBracket(jsonCommodity.getDemandBracket().toString()));
                stationCommodity.setStockBracket(database.getReferenceEntityHelper().getOrCreateCommodityBracket(jsonCommodity.getStockBracket().toString()));

            }

            station.getStationCommoditiesProhibited().clear();
            if (jsonCommodityBinding.getMessage().getProhibited() != null) {
                for (String commodity : jsonCommodityBinding.getMessage().getProhibited()) {
                    StationCommodityProhibited prohibitedCommodity = database.getMainEntityHelper().createStationCommodityProhibitedOnStation(station);
                    prohibitedCommodity.setCommodity(database.getReferenceEntityHelper().getOrCreateCommodity(commodity));
                }
            }

            station.getStationEconomies().clear();

            if (jsonCommodityBinding.getMessage().getEconomies() != null) {
                for (Map<String, Object> economy : jsonCommodityBinding.getMessage().getEconomies()) {
                    StationEconomy stationEconomy = database.getMainEntityHelper().createStationEconomyOnStation(station);

                    stationEconomy.setEconomy(database.getReferenceEntityHelper().getOrCreateEconomy((String) economy.get("name")));
                    if (economy.get("proportion") instanceof Integer) {
                        stationEconomy.setProportion(new Double((Integer) economy.get("proportion")));
                    } else {
                        stationEconomy.setProportion((Double) economy.get("proportion"));
                    }
                }
            }



            database.transactionCommit();
            database.clearEntityManager();


            long totalMs = System.currentTimeMillis() - startMs;

            String message = "Processed Commidity event on StarSystem.Station : " + starSystem.getId() + "." + station.getStationName() + " in " + totalMs + " ms.";
            eventListener.eddnMessageProcessed(message);
            LOG.info(message);


        } catch (Exception e) {
            database.transactionRollback();
            throw e;
        }

    }

    public void processBlackMarketEvent(EddnBlackMarket jsonBlackMarketBinding) {

        try {

            long startMs = System.currentTimeMillis();
            database.transactionStart();

            StarSystem starSystem = database.getMainEntityHelper().getOrCreateStarSystem(jsonBlackMarketBinding.getMessage().getSystemName());
            Station station = database.getMainEntityHelper().getOrCreateStationInStarSystem(starSystem, jsonBlackMarketBinding.getMessage().getStationName());

            StationCommodityBlackMarket stationCommodityBlackMarket = null;
            for (StationCommodityBlackMarket scbm : station.getStationCommoditiesBlackMarket()) {
                if (scbm.getCommodity().getId().equalsIgnoreCase(jsonBlackMarketBinding.getMessage().getName())) {
                    stationCommodityBlackMarket = scbm;
                }
            }

            if (stationCommodityBlackMarket == null) {
                stationCommodityBlackMarket = database.getMainEntityHelper().createStationCommodityBlackMarketOnStation(station);
                stationCommodityBlackMarket.setCommodity(database.getReferenceEntityHelper().getOrCreateCommodityBlackMarket(jsonBlackMarketBinding.getMessage().getName()));
            }

            stationCommodityBlackMarket.setProhibited(jsonBlackMarketBinding.getMessage().getProhibited());
            stationCommodityBlackMarket.setSellPrice(jsonBlackMarketBinding.getMessage().getSellPrice());

            database.transactionCommit();
            database.clearEntityManager();

            long totalMs = System.currentTimeMillis() - startMs;

            String message = "Processed BlackMarket event on StarSystem.Station : " + starSystem.getId() + "." + station.getStationName() + " in " + totalMs + " ms.";
            eventListener.eddnMessageProcessed(message);
            LOG.info(message);


        } catch (Exception e) {
            database.transactionRollback();
            throw e;
        }

    }

    public void processShipyardEvent(EddnShipyard eddnShipyard) {

        try {

            long startMs = System.currentTimeMillis();
            database.transactionStart();

            StarSystem starSystem = database.getMainEntityHelper().getOrCreateStarSystem(eddnShipyard.getMessage().getSystemName());
            Station station = database.getMainEntityHelper().getOrCreateStationInStarSystem(starSystem, eddnShipyard.getMessage().getStationName());

            station.getShipyard().clear();

            for (String shipKey : eddnShipyard.getMessage().getShips()) {
                if (shipKey != null && !shipKey.isEmpty()) {
                    Ship ship = database.getReferenceEntityHelper().getOrCreateShip(shipKey);
                    station.getShipyard().add(ship);
                }
            }

            database.transactionCommit();
            database.clearEntityManager();

            long totalMs = System.currentTimeMillis() - startMs;

            String message = "Processed Shipyard event on StarSystem.Station : " + starSystem.getId() + "." + station.getStationName() + " in " + totalMs + " ms.";
            eventListener.eddnMessageProcessed(message);
            LOG.info(message);


        } catch (Exception e) {
            database.transactionRollback();
            throw e;
        }
    }

    public void processOutfittingEvent(EddnOutfitting eddnOutfitting) {

        try {

            long startMs = System.currentTimeMillis();
            database.transactionStart();

            StarSystem starSystem = database.getMainEntityHelper().getOrCreateStarSystem(eddnOutfitting.getMessage().getSystemName());
            Station station = database.getMainEntityHelper().getOrCreateStationInStarSystem(starSystem, eddnOutfitting.getMessage().getStationName());

            station.getOutfitting().clear();

            for (String moduleKey : eddnOutfitting.getMessage().getModules()) {
                if (moduleKey != null && !moduleKey.isEmpty()) {
                    Module module = database.getReferenceEntityHelper().getOrCreateModule(moduleKey);
                    station.getOutfitting().add(module);
                }
            }
            database.transactionCommit();
            database.clearEntityManager();

            long totalMs = System.currentTimeMillis() - startMs;

            String message = "Processed Outfitting event on StarSystem.Station : " + starSystem.getId() + "." + station.getStationName() + " in " + totalMs + " ms.";
            eventListener.eddnMessageProcessed(message);
            LOG.info(message);

        } catch (Exception e) {
            database.transactionRollback();
            throw e;

        }
    }


    @Override
    public void jsconReceived(String json) {

        try {

            JsonFactory factory = new JsonFactory();
            ObjectMapper mapper = new ObjectMapper(factory);

            EddnEnvelope binding = mapper.readerFor(EddnEnvelope.class).readValue(json);

            if (binding.getSchemaRef().toUpperCase().contains("COMMODITY")) {
                EddnCommodity eddnCommodity = mapper.readerFor(EddnCommodity.class).readValue(json);
                processCommidityEvent(eddnCommodity);
            } else if (binding.getSchemaRef().toUpperCase().contains("JOURNAL")) {
                EddnJournal eddnJournal = mapper.readerFor(EddnJournal.class).readValue(json);
                processJournalEvent(eddnJournal);
            } else if (binding.getSchemaRef().toUpperCase().contains("SHIPYARD")) {
                EddnShipyard eddnShipyard = mapper.readerFor(EddnShipyard.class).readValue(json);
                processShipyardEvent(eddnShipyard);
            } else if (binding.getSchemaRef().toUpperCase().contains("OUTFIT")) {
                EddnOutfitting eddnOutfiting = mapper.readerFor(EddnOutfitting.class).readValue(json);
                processOutfittingEvent(eddnOutfiting);
            } else if (binding.getSchemaRef().toUpperCase().contains("BLACK")) {
                EddnBlackMarket eddnBlackMarket = mapper.readerFor(EddnBlackMarket.class).readValue(json);
                processBlackMarketEvent(eddnBlackMarket);
            }

        } catch (Exception e) {
            eventListener.eddnMessageProcessed("Unable to parse/process json: " + json + "\n" + e.getMessage());
            LOG.error("Unable to parse json: " + json, e);
        }


    }

}
