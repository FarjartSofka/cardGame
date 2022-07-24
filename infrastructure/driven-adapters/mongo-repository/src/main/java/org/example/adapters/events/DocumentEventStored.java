package org.example.adapters.events;

import co.com.sofka.infraestructure.store.StoredEvent;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DocumentEventStored {

    private String aggregateRootId;

    private StoredEvent storedEvent;

    public String getAggregateRootId() {
        return aggregateRootId;
    }

    public void setAggregateRootId(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }

    public StoredEvent getStoredEvent() {
        return storedEvent;
    }

    public void setStoredEvent(StoredEvent storedEvent) {
        this.storedEvent = storedEvent;
    }

}
