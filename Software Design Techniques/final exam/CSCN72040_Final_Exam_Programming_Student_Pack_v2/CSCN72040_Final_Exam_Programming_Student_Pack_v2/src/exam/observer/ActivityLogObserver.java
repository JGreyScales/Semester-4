package exam.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple observer used by the self-checker to log every received event.
 */
public class ActivityLogObserver implements TaskObserver {
    /** Stored event messages in the order received. */
    private final List<String> receivedEvents = new ArrayList<>();

    /**
     * Stores the incoming event message.
     *
     * @param eventMessage event text sent by the subject
     */
    @Override
    public void update(String eventMessage) {
        receivedEvents.add(eventMessage);
    }

    /**
     * Gets all received events.
     *
     * @return received event messages
     */
    public List<String> getReceivedEvents() {
        return receivedEvents;
    }
}
