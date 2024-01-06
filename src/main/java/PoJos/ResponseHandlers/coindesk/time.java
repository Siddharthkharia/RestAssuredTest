package PoJos.ResponseHandlers.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({"updated","updatedISO","updateduk"})
public class time {

    @JsonProperty("updated")
    private String updated;

    @JsonProperty("updatedISO")
    private String updatedISO;

    @JsonProperty("updateduk")
    private String updateduk;

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("updatedISO")
    public String getUpdatedISO() {
        return updatedISO;
    }

    @JsonProperty("updatedISO")
    public void setUpdatedISO(String updatedISO) {
        this.updatedISO = updatedISO;
    }

    @JsonProperty("updateduk")
    public String getUpdateduk() {
        return updateduk;
    }

    @JsonProperty("updateduk")
    public void setUpdateduk(String updateduk) {
        this.updateduk = updateduk;
    }

    public time(String updated, String updatedISO, String updateduk) {
        this.updated = updated;
        this.updatedISO = updatedISO;
        this.updateduk = updateduk;
    }

    public time() {
    }
}
