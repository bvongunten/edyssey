package ch.nostromo.edyssey.eddn;

public interface EddnDatabaseLoaderListener {

    public void eddnMessageProcessed(String message);
    public void eddnMessageFailed(String message);

}
