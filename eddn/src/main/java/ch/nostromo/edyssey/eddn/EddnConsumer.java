package ch.nostromo.edyssey.eddn;

import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.apache.log4j.Logger;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

/**
 * Subscribe to zmq relay from EDDN
 */
public class EddnConsumer extends Thread {

    public static final Logger LOG = Logger.getLogger(EddnDatabaseLoader.class);

    public static final String SCHEMA_KEY = "$schemaRef";

    EddnConsumerListener eventListener;

    private boolean running = true;

    private String relay;

    public EddnConsumer(EddnConsumerListener eventListener, String relay) {
        this.relay = relay;
        this.eventListener = eventListener;
    }

    @Override
    public void run() {

        while (running) {
            try {
                pump();
            } catch (Exception e) {
                LOG.error("Failed to pump data from eddn", e);
            }

            if (running) {
                try {
                    LOG.warn("Sleep and retry to connect ...");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // ignored
                }
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = false;
    }

    public synchronized void pump() throws DataFormatException, UnsupportedEncodingException {

        ZContext ctx = null;
        try {
            ctx = new ZContext();
            ZMQ.Socket client = ctx.createSocket(ZMQ.SUB);
            client.subscribe("".getBytes());
            client.setReceiveTimeOut(30000);

            client.connect(relay);
            ZMQ.Poller poller = ctx.createPoller(2);
            poller.register(client, ZMQ.Poller.POLLIN);
            byte[] output = new byte[256 * 1024];

            while (running) {
                int poll = poller.poll(10);
                if (poll == ZMQ.Poller.POLLIN) {
                    poller.getItem(poll);

                    if (poller.pollin(0)) {
                        byte[] recv = client.recv(ZMQ.NOBLOCK);
                        if (recv.length > 0) {
                            // decompress
                            Inflater inflater = new Inflater();
                            inflater.setInput(recv);

                            int outlen = inflater.inflate(output);
                            String json = new String(output, 0, outlen, "UTF-8");

                            if (json.contains(SCHEMA_KEY)) {
                                this.eventListener.jsconReceived(json);
                            }

                        }
                    }
                }
            }
        } finally {
            try {
                if (ctx != null) {
                    ctx.close();
                }
            } catch (Exception e) {

            }
        }
    }

}