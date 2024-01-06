package PoJos.ResponseHandlers.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"time","disclaimer","chartName","bpi"})
public class ResponsePOJO {

    @JsonProperty("time")
    private time time;

    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("chartName")
    private String chartName;

    @JsonProperty("bpi")
    private bpi bpi;

    @JsonProperty("time")
    public PoJos.ResponseHandlers.coindesk.time getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(PoJos.ResponseHandlers.coindesk.time time) {
        this.time = time;
    }

    @JsonProperty("disclaimer")
    public String getDisclaimer() {
        return disclaimer;
    }

    @JsonProperty("disclaimer")
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    @JsonProperty("chartName")
    public String getChartName() {
        return chartName;
    }

    @JsonProperty("chartName")
    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    @JsonProperty("bpi")
    public PoJos.ResponseHandlers.coindesk.bpi getBpi() {
        return bpi;
    }

    @JsonProperty("bpi")
    public void setBpi(PoJos.ResponseHandlers.coindesk.bpi bpi) {
        this.bpi = bpi;
    }

    public ResponsePOJO(PoJos.ResponseHandlers.coindesk.time time, String disclaimer, String chartName, PoJos.ResponseHandlers.coindesk.bpi bpi) {
        this.time = time;
        this.disclaimer = disclaimer;
        this.chartName = chartName;
        this.bpi = bpi;
    }

    public ResponsePOJO() {
    }

}
