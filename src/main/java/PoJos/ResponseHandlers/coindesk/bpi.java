package PoJos.ResponseHandlers.coindesk;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class bpi {

    private Map<String, details> additionalProperties = new LinkedHashMap<String, details>();


    public bpi() {
    }

    @JsonAnyGetter
    public Map<String, details> getStringdetailsMap() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setStringdetailsMap(String name,details details) {
        this.additionalProperties.put(name,details);
    }

}
