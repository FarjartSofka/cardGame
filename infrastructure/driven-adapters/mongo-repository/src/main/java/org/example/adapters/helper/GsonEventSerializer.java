package org.example.adapters.helper;


import com.google.gson.Gson;
import org.example.model.generic.DomainEvent;
import org.example.model.generic.StoredEvent;
import org.springframework.stereotype.Component;

@Component
public class GsonEventSerializer implements StoredEvent.EventSerializer {
    @Override
    public <T extends DomainEvent> T deserialize(String aSerialization, Class<?> classType) {

        return (T) new Gson().fromJson(aSerialization, classType);
    }

    @Override
    public String serialize(DomainEvent object) {
        return new Gson().toJson(object, object.getClass());
    }
}