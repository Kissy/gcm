package fr.kissy.gcm.rest.server.task;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;

import java.io.IOException;
import java.util.List;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
public class GcmSenderTask implements Runnable {
    private String apiKey;
    private List<String> devices;

    public GcmSenderTask(String apiKey, List<String> devices) {
        this.apiKey = apiKey;
        this.devices = devices;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void run() {
        Sender sender = new Sender(apiKey);
        Message gcmMessage = new Message.Builder().build();
        try {
            sender.send(gcmMessage, devices, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
